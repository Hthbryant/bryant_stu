package com.gnnu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gnnu.dao.StuMapper;
import com.gnnu.dao.TeaMapper;
import com.gnnu.entity.Student;
import com.gnnu.entity.Teacher;
import com.gnnu.service.ISsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsoServiceImpl implements ISsoService {

    @Autowired
    private StuMapper stuMapper;

    @Autowired
    private TeaMapper teaMapper;


    @Override
    public Student isStuLogin(Student student) {
        return null;
    }

    @Override
    public Teacher isTeaLogin(Teacher teacher) {
        return null;
    }

    /**
     * 学生登录
     * @param student
     * @return
     */
    @Override
    public Student stuLogin(Student student) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",student.getName());
        Student student1 = stuMapper.selectOne(queryWrapper);
        //根据名字查询数据库是否有此人
        if(student1!=null){
            //有此人，比对密码
            boolean islogin = student1.getPassword().equals(student.getPassword());
            if(islogin){
                return student1;
            }else {
                return null;
            }
        }
        //没有此人，返回空
        return null;
    }

    /**
     * 老师登录
     * @param teacher
     * @return
     */
    @Override
    public Teacher teaLogin(Teacher teacher) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",teacher.getName());
        Teacher teacher1 = teaMapper.selectOne(queryWrapper);
        //根据名字查询数据库是否有此人
        if(teacher1!=null){
            //有此人，比对密码
            boolean islogin = teacher1.getPassword()== teacher1.getPassword()? true : false;
            if(islogin){
                return teacher1;
            }else {
                return null;
            }
        }
        //没有此人，返回空
        return null;
    }
}
