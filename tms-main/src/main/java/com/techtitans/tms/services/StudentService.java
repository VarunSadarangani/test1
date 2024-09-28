package com.techtitans.tms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techtitans.tms.model.Students;
import com.techtitans.tms.repository.StudentRepo;

@Service
public class StudentService {


    @Autowired
    StudentRepo studentRepo;

    public List<Students> getAllStudents()
    {
        return studentRepo.findAll();
    }

}
