package com.woniu.pinyin.entity;

public class Zuiming {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zuiming.zid
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    private Integer zid;

    @Override
    public String toString() {
        return "Zuiming{" +
                "zid=" + zid +
                ", zname='" + zname + '\'' +
                ", simplecode='" + simplecode + '\'' +
                ", fullcode='" + fullcode + '\'' +
                '}';
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zuiming.zname
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    private String zname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zuiming.simplecode
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    private String simplecode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zuiming.fullcode
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    private String fullcode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zuiming.zid
     *
     * @return the value of zuiming.zid
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public Integer getZid() {
        return zid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zuiming.zid
     *
     * @param zid the value for zuiming.zid
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public void setZid(Integer zid) {
        this.zid = zid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zuiming.zname
     *
     * @return the value of zuiming.zname
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public String getZname() {
        return zname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zuiming.zname
     *
     * @param zname the value for zuiming.zname
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public void setZname(String zname) {
        this.zname = zname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zuiming.simplecode
     *
     * @return the value of zuiming.simplecode
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public String getSimplecode() {
        return simplecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zuiming.simplecode
     *
     * @param simplecode the value for zuiming.simplecode
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public void setSimplecode(String simplecode) {
        this.simplecode = simplecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zuiming.fullcode
     *
     * @return the value of zuiming.fullcode
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public String getFullcode() {
        return fullcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zuiming.fullcode
     *
     * @param fullcode the value for zuiming.fullcode
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    public void setFullcode(String fullcode) {
        this.fullcode = fullcode;
    }
}