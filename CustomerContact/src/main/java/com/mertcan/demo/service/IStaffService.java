package com.mertcan.demo.service;

import com.mertcan.demo.entity.Staff;

import java.util.List;

import com.mertcan.demo.dto.StaffDTO;

public interface IStaffService {
	
	void save(Staff staff);

    List<StaffDTO> getAll();
    
    StaffDTO update (Long id, StaffDTO staffDTO);
    
    StaffDTO getById(Long id);

}
