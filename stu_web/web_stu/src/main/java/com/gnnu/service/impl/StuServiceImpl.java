package com.gnnu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gnnu.dao.StuMapper;
import com.gnnu.entity.Student;
import com.gnnu.feign.ClassFeign;
import com.gnnu.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuServiceImpl implements IStuService {

    @Autowired
    private StuMapper stuMapper;

    @Autowired
    private ClassFeign classFeign;

    @Override
    public List<Student> showAllStu() {
        List<Student> studentList = stuMapper.selectList(null);
        for (Student stu : studentList) {
            stu.setCls(classFeign.selectByCid(stu.getCId()));
        }
        return  studentList;
    }

    @Override
    public int addStu(Student student) {
        return stuMapper.insert(student);
    }

    @Override
    public int delOneById(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",id);
        return stuMapper.delete(queryWrapper);
    }

    @Override
    public Student searchStuById(Integer id) {
        return stuMapper.selectById(id);
    }

    @Override
    public int update(Student student) {
        return stuMapper.updateById(student);
    }
}
