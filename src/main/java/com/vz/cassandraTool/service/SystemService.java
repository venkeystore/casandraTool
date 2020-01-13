package com.vz.cassandraTool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vz.cassandraTool.dto.SystemDto;
import com.vz.cassandraTool.pojo.System;
import com.vz.cassandraTool.repo.SystemRepo;

@Service
public class SystemService {

	@Autowired
	SystemRepo systemRepo;

	// To get all system names like vision,dmd,ecpd etc.
	public List<SystemDto> getSystems() {

		List<System> systems = systemRepo.findAll();
		List<SystemDto> sysDtoList = new ArrayList<>();
		for (System sys : systems) {
			SystemDto sysdto = new SystemDto();
			sysdto.setSystemId(sys.getSystemId());
			sysdto.setSystemName(sys.getSystemName());
			sysDtoList.add(sysdto);
		}
		return sysDtoList;
	}
}
