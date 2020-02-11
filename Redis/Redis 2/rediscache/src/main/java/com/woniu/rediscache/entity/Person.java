package com.woniu.rediscache.entity;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private List cars;

    public List getCars() {
        return cars;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cars=" + cars +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                '}';
    }

    public void setCars(List cars) {
        this.cars = cars;
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.pid
     *
     * @mbggenerated Fri Nov 15 09:45:21 CST 2019
     */
    private Integer pid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.name
     *
     * @mbggenerated Fri Nov 15 09:45:21 CST 2019
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.pid
     *
     * @return the value of person.pid
     *
     * @mbggenerated Fri Nov 15 09:45:21 CST 2019
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.pid
     *
     * @param pid the value for person.pid
     *
     * @mbggenerated Fri Nov 15 09:45:21 CST 2019
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.name
     *
     * @return the value of person.name
     *
     * @mbggenerated Fri Nov 15 09:45:21 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.name
     *
     * @param name the value for person.name
     *
     * @mbggenerated Fri Nov 15 09:45:21 CST 2019
     */
    public void setName(String name) {
        this.name = name;
    }
}