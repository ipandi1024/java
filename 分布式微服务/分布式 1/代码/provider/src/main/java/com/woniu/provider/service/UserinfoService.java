package com.woniu.provider.service;

import com.woniu.provider.entity.Userinfo;
import com.woniu.provider.mapper.UserinfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className:UserinfoService
 * @Description:TODO
 * @Author:Laohan
 * @Date:2019/11/20 10:08
 * @Version:1.0
 **/
@Service
public class UserinfoService {
    @Resource
    private UserinfoMapper userinfoMapper;

    @Transactional(readOnly = true)
    public List findAll(){
        return userinfoMapper.selectByExample(null);
    }
    @Transactional(readOnly = true)
    public Userinfo findById(Integer uid){
        return userinfoMapper.selectByPrimaryKey(uid);
    }
}
