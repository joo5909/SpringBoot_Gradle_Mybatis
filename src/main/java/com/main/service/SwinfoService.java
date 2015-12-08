package com.main.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.domain.SwinfoDto.SwinfoDtl;
import com.main.repository.SwinfoRepository;

@Service
public class SwinfoService {

	@Autowired
	private SwinfoRepository swinfoRepository;

	Map<String, Object> param = new HashMap<>();
	
	public List<SwinfoDtl> getSwinfo(String skey) {
		param.put("skey", skey);
		return swinfoRepository.findSwinfoDtl(param);
	}
}
