package com.woniu.pinyin.mapper;

import com.woniu.pinyin.entity.Zuiming;
import com.woniu.pinyin.entity.ZuimingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZuimingMapper {
    List findZm(String zm);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    int countByExample(ZuimingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    int deleteByExample(ZuimingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    int deleteByPrimaryKey(Integer zid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    int insert(Zuiming record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    int insertSelective(Zuiming record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    List<Zuiming> selectByExample(ZuimingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    Zuiming selectByPrimaryKey(Integer zid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    int updateByExampleSelective(@Param("record") Zuiming record, @Param("example") ZuimingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    int updateByExample(@Param("record") Zuiming record, @Param("example") ZuimingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    int updateByPrimaryKeySelective(Zuiming record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table zuiming
     *
     * @mbggenerated Thu Nov 28 12:24:58 CST 2019
     */
    int updateByPrimaryKey(Zuiming record);
}