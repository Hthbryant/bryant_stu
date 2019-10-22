package com.gnnu.controller;

import com.gnnu.entity.Student;
import com.gnnu.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuController {

    @Autowired
    private IStuService stuService;

    @RequestMapping("/showAllStu")
    public String showAllStu(ModelMap map){

        List<Student> studentList =stuService.showAllStu();
        map.put("stuList",studentList);
        return "stuList";
    }
    @RequestMapping("/toAddStu")
    public String toAddStu(){
        return "addStu";
    }
    @RequestMapping("/addStu")
    @ResponseBody
    public String addStu(Student student){
        int result = stuService.addStu(student);
        if(result>0){
            return "<script>location.href='/stu/showAllStu';</script>";
        }
        return "<script>alert('添加学生失败');location.href='/stu/showAllStu';</script>";
    }
    @RequestMapping("/delOne")
    @ResponseBody
    public String delOne(Integer id){
        int result = stuService.delOneById(id);
        if(result>0){
            return "<script>location.href='/stu/showAllStu';</script>";
        }
        return "<script>alert('删除学生失败');location.href='/stu/showAllStu';</script>";
    }
    @RequestMapping("/toUpdate")
    public String toUpdate(Integer id ,ModelMap map){
        Student student = stuService.searchStuById(id);
        map.put("student",student);
        return "update";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(Student student){
        System.out.println(student);
        int result =  stuService.update(student);
        if(result>0){
            return "<script>location.href='/stu/showAllStu';</script>";
        }
        return "<script>alert('修改学生资料失败');location.href='/stu/showAllStu';</script>";
    }
}
