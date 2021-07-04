package com.shadowJava.Springboot.l1.service;

import com.shadowJava.Springboot.l1.entity.Department;
import com.shadowJava.Springboot.l1.error.DepartmentNotFoundException;
import com.shadowJava.Springboot.l1.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        // Optional: A container object which may or may not contain a non-null value. If a value is present, isPresent() returns true. If no value is present, the object is considered empty and isPresent() returns false.
        Optional<Department> department = departmentRepository.findById(departmentId);
        // if the record doesn't exist throw exception error

        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department Not available");
        }

        return department.get(); // if you have found the record
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        // get the record from the database
        Department depDB = departmentRepository.findById(departmentId).get();

        // check if the new department name(from the endpoint) is not null and not blank then save it
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentName(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentName(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}