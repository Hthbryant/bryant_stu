package com.gnnu.service;

import com.gnnu.entity.Student;

import java.util.List;

public interface IStuService {
    List<Student> showAllStu();

    int addStu(Student student);

    int delOneById(Integer id);

    Student searchStuById(Integer id);

    int update(Student student);
}
