package com.shadowJava.Springboot.l1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data // from lombok(equivalent to @Getters, @ Setters, @ToString). Don't need getters and setters. Else just use @Getters, @ Setters
@NoArgsConstructor // Default constructor
@AllArgsConstructor // constructor created with all arguments
@Builder
public class Department {
//    Declarations
    @Id // make departmentId primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
//    @Length(min=2, max = 100)
//    @NotBlank(message = "Please Add Department Name")
//    @PastOrPresent // for date field
//    @Future // for date field
//    @FutureOrPresent // for date field
    @NotBlank(message = "Please Add Department Name") // make sure departmentName is always available when passed by client
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}


// Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.