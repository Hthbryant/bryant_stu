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

    @RequestMapping("/showAllTeacher")
    public String showAllTeacher(){

        return "teacherList";
    }
    @RequestMapping("/login")
    public String login(Teacher teacher, ModelMap map){
        Teacher teacher1 = teacherService.login(teacher);
        if(teacher1!=null){
            map.put("teacher",teacher1);
            return "teacherIndex";
        }
        return "index";
    }
    @RequestMapping("/showClasses")
    public String showClasses(Integer id,ModelMap map){
        System.out.println("id为："+id);
        List<Class> classList = teacherService.getClassesById(id);
        map.put("classList",classList);
        return "classes";
    }
}
