package com.woniu.mapper;

import com.woniu.entity.Car;
import com.woniu.entity.CarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    int countByExample(CarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    int deleteByExample(CarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    int deleteByPrimaryKey(Integer carid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    int insert(Car record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    int insertSelective(Car record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    List<Car> selectByExample(CarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    Car selectByPrimaryKey(Integer carid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    int updateByExample(@Param("record") Car record, @Param("example") CarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    int updateByPrimaryKeySelective(Car record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car
     *
     * @mbggenerated Tue Aug 20 09:44:17 CST 2019
     */
    int updateByPrimaryKey(Car record);
}