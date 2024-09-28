package com.techtitans.tms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techtitans.tms.model.Attendance;
import com.techtitans.tms.repository.AttendanceRepo;


@Service
public class AttendanceService {

    @Autowired
    AttendanceRepo attendanceRepo;

        // Method to update attendance counts based on the present students
    public void incrementAttendanceCount(List<Integer> presentIds)
    {
        // Fetch attendance records by student IDs
        List<Attendance> attendances = attendanceRepo.findByAttnIdIn(presentIds);

        // Increment the attendance count for each student
        for (Attendance attendance : attendances) {
            attendance.setAttn_count(attendance.getAttn_count() + 1); // Increment count
        }

        // Save all the updated attendance records
        attendanceRepo.saveAll(attendances);
    }
}
