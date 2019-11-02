package com.gnnu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gnnu.dao.TeacherMapper;
import com.gnnu.entity.Class;
import com.gnnu.entity.Teacher;
import com.gnnu.feign.ClassFeign;
import com.gnnu.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private ClassFeign classFeign;


    @Override
    public Teacher login(Teacher teacher) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",teacher.getName());
        queryWrapper.eq("password",teacher.getPassword());
        return teacherMapper.selectOne(queryWrapper);
    }

    @Override
    public List<Class> getClassesById(Integer id) {
        return classFeign.selectClassesByTid(id);
//        System.out.println("实现类里面id:"+id);
//        return null;
    }

    @Override
    public Class selectClassById(Integer cid) {
        //调用classfeign查询指定班级信息
        return classFeign.selectByCid(cid);
        //根据班级id查询该班级的所有授课老师

        //根据班级id查询该班级的所有学生

    }
}
