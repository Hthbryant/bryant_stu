package com.gnnu.service;

import com.gnnu.entity.Class;
import com.gnnu.entity.Teacher;

import java.util.List;

public interface ITeacherService {
    Teacher login(Teacher teacher);

    List<Class> getClassesById(Integer id);

    Class selectClassById(Integer cid);
}
