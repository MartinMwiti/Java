package com.shadowJava.Springboot.l1.repository;

import com.shadowJava.Springboot.l1.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("AI").departmentCode("Tech-08").departmentAddress("Gigiri").build();
//        persist
        entityManager.persist(department);
    }

    @Test
    public void whenFindById_theReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();

        assertEquals(department.getDepartmentName(), "AI");
    }
}