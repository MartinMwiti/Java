package com.shadowJava.Springboot.l1.service;

import com.shadowJava.Springboot.l1.entity.Department;
import com.shadowJava.Springboot.l1.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("Software").departmentAddress("Gigiri").departmentCode("Tech-06").departmentId(1L).build();

        // Mocking
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("Software")).thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on Valid Department Name")
    // not necessary, instead of displaying method name, show message
    @Disabled // disable test case
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "Software";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}