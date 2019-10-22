package com.gnnu.service;

import com.gnnu.entity.Class;

import java.util.List;

public interface IClassService {
    List<Class> showAllClass();

    Class selectByCid(Integer id);

    List<Class> selectClassesByCid(Integer tid);
}
