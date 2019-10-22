package com.gnnu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gnnu.entity.Class;
import com.gnnu.dao.ClassMapper;
import com.gnnu.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements IClassService {

    @Autowired
    private ClassMapper classMapper;


    @Override
    public List<Class> showAllClass() {
        return classMapper.selectList(null);
    }

    @Override
    public Class selectByCid(Integer id) {
        return classMapper.selectById(id);
    }

    @Override
    public List<Class> selectClassesByCid(Integer tid) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("t_id",tid);
        return classMapper.selectList(queryWrapper);
    }
}
