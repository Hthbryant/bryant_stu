package com.gnnu.controller;

import com.gnnu.entity.Class;
import com.gnnu.entity.Teacher;
import com.gnnu.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    /**
     * 展示教室列表
     * @return
     */
    @RequestMapping("/showAllTeacher")
    public String showAllTeacher(){

        return "teacherList";
    }

    /**
     * 教师登录
     * @param teacher
     * @param map
     * @return
     */
    @RequestMapping("/login")
    public String login(Teacher teacher, ModelMap map){
        Teacher teacher1 = teacherService.login(teacher);
        if(teacher1!=null){
            map.put("teacher",teacher1);
            return "teacherIndex";
        }
        return "index";
    }

    /**
     * 展示该教师带的所有班级
     * @param id
     * @param map
     * @return
     */
    @RequestMapping("/showClasses")
    public String showClasses(Integer id,ModelMap map){
        System.out.println("id为："+id);
        List<Class> classList = teacherService.getClassesById(id);
        map.put("classList",classList);
        return "classes";
    }

    /**
     * 展示某个班级
     * @return
     */
    @RequestMapping("/showClassById")
    public String showClassById(Integer cid,ModelMap map){
        //根据班级id,查询该班级的信息
        Class cls = teacherService.selectClassById(cid);
        map.put("class",cls);
        return "class";
    }
}
