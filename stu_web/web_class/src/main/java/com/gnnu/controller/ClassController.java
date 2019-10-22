package com.gnnu.controller;

import com.gnnu.entity.Class;
import com.gnnu.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private IClassService classService;

    @RequestMapping("/showAllClass")
    @ResponseBody
    public List<Class> showAllClass(){

        List<Class> classList = classService.showAllClass();

        return classList;
    }
    @RequestMapping("/selectByCid/{cid}")
    @ResponseBody
    public Class selectByCid(@PathVariable Integer cid){
        return classService.selectByCid(cid);
    }
    @RequestMapping("/selectClassesByTid/{tid}")
    @ResponseBody
    public List<Class> selectClassesByTid(@PathVariable Integer tid){
        System.out.println("进来了class,tid为："+tid);
        return classService.selectClassesByCid(tid);
    }
}
