package com.woniu.entity;

import java.io.Serializable;

public class Car implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */ 
	private static final long serialVersionUID = 1L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.carid
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    private Integer carid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.cname
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    private String cname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column car.uid
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    private Integer uid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.carid
     *
     * @return the value of car.carid
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    public Integer getCarid() {
        return carid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.carid
     *
     * @param carid the value for car.carid
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.cname
     *
     * @return the value of car.cname
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    public String getCname() {
        return cname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.cname
     *
     * @param cname the value for car.cname
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column car.uid
     *
     * @return the value of car.uid
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column car.uid
     *
     * @param uid the value for car.uid
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }
}