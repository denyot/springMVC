package com.hu.springMVC.many2one;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {
    private Long id;
    private String name;
    private Department dept;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
