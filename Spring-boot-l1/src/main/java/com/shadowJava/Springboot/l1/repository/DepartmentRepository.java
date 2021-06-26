package com.shadowJava.Springboot.l1.repository;

import com.shadowJava.Springboot.l1.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
