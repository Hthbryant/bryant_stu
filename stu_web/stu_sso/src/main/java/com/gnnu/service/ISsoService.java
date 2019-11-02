package com.gnnu.service;

import com.gnnu.entity.Student;
import com.gnnu.entity.Teacher;

public interface ISsoService {
    Student isStuLogin(Student student);

    Teacher isTeaLogin(Teacher teacher);

    Student stuLogin(Student student);

    Teacher teaLogin(Teacher teacher);
}
