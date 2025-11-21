package com.fiap.futureskills.repository;

import com.fiap.futureskills.domain.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
