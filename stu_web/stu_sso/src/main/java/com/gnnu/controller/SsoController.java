package com.gnnu.controller;

import com.gnnu.entity.ResultData;
import com.gnnu.entity.Student;
import com.gnnu.service.ISsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/sso")
public class SsoController {

    @Autowired
    private ISsoService ssoService;

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     *去到学生的登录界面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        System.out.println("进来了sso的toLogin方法");
        return "login";
    }

    /**
     * 学生登录
     * @param student
     * @param returnUrl
     * @param response
     * @return
     */
    @RequestMapping("/stuLogin")
    public String login(Student student,String returnUrl , HttpServletResponse response){

        Student student1 =  ssoService.stuLogin(student);
        if(student1!=null){
            //用户成功登录，存放至cookie及redis
            System.out.println("登录成功");

            //cookie 的UUID
            String stuLogin_token = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("stuLogin_token",stuLogin_token);
            cookie.setMaxAge(60 * 60 *24 *7);
            cookie.setPath("/");
            response.addCookie(cookie);
            //将用户信息存放至redis以及超时时间

            redisTemplate.opsForValue().set(stuLogin_token,student1);
            redisTemplate.expire(stuLogin_token,7, TimeUnit.DAYS);

            //跳回用户来登录之前的页面
            if(returnUrl==null || returnUrl!=""){
                returnUrl = "http://localhost:16666/stu/stuInfo";
            }
            return  "redirect:"+returnUrl;

        }else{
            System.out.println("登录失败");
            //回到登录页面
            return "redirect:http://localhost:16666/sso/toLogin";
        }
    }

    @RequestMapping("/isStuLogin")
    @ResponseBody
    public ResultData isStuLogin(@CookieValue(value = "stuLogin_token",required = false)String stuLoginToken){
        ResultData<Student> resultData = null;
        if(stuLoginToken==null){
            //未登录
            resultData = new ResultData().setCode("1000").setMsg("未登录");

        }else{
            //已登录，从redis中取用户信息
            Student student = (Student) redisTemplate.opsForValue().get(stuLoginToken);
            if(student!=null){
                //用户信息不为空
                resultData = new ResultData().setCode("0000").setMsg("已登录").setData(student);
            }else{
                resultData = new ResultData().setCode("1000").setMsg("未登录");
            }
        }
        return  resultData;
    }

    @RequestMapping("/logout")
    public String logout(@CookieValue(value = "stuLogin_token",required = false)String stuLoginToken,HttpServletResponse response){
        //从cookie里面取看看是否有值
        if(stuLoginToken!=null){
            //先从cookie中删除
            Cookie cookie = new Cookie("stuLogin_token",stuLoginToken);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);

            //从redis中删除
            redisTemplate.delete(stuLoginToken);
        }
        return "redirect:http://localhost:16666";
    }

}
