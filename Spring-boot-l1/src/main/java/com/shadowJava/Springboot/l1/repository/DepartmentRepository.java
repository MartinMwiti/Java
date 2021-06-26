package com.shadowJava.Springboot.l1.repository;

import com.shadowJava.Springboot.l1.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // create a custom function for getting department record based on name. There is no jpa func for that. with the findByDepartmentName naming convention we should get the departmentName
    public Department findByDepartmentName(String departmentName);

    // Allow passing of either small or capital letter
    public Department findByDepartmentNameIgnoreCase(String departmentName);


}
