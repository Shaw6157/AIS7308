package com.ais.test2activities;

/**
 * Copyright (C) 2018 CYu. All rights reserved.
 *
 * @Package: com.ais.test2activities
 * @Description:
 * @author: Shaw
 * @date: 16/10
 */
public class EmployeeBean {
    private String name;
    private String position;
    private String type;
    private int salary;

    public EmployeeBean(String pName, String pPosition, String pType, int pSalary) {
        name = pName;
        position = pPosition;
        type = pType;
        salary = pSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String pPosition) {
        position = pPosition;
    }

    public String getType() {
        return type;
    }

    public void setType(String pType) {
        type = pType;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int pSalary) {
        salary = pSalary;
    }
}
