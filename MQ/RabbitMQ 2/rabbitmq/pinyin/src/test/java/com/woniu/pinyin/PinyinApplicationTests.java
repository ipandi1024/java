package com.woniu.pinyin;

import com.woniu.pinyin.entity.Zuiming;
import com.woniu.pinyin.mapper.ZuimingMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class PinyinApplicationTests {
    @Resource
    private ZuimingMapper zuimingMapper;

    @Test
    void contextLoads() {
    }
    @Test
    public void testupdate(){
        List<Zuiming> list = zuimingMapper.selectByExample(null);
        for (Zuiming zm: list) {
            try {
                String simplecode = Tools.getSimple(zm.getZname());
                String fullcode = Tools.convert(zm.getZname());
                zm.setSimplecode(simplecode);
                zm.setFullcode(fullcode);
                zuimingMapper.updateByPrimaryKey(zm);

            }catch(Exception e){

            }

        }
    }
}
