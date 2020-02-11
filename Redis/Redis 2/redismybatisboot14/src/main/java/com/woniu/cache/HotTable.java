package com.woniu.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HotTable {
	@Value("${hottable}")
	private List<String> list;
	
	public List<String> getHotTable(){
		return list;
	}
}
