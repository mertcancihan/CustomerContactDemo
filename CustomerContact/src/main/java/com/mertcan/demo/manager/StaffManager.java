package com.mertcan.demo.manager;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mertcan.demo.dto.StaffDTO;
import com.mertcan.demo.entity.Staff;
import com.mertcan.demo.service.IStaffService;
import com.mertcan.demo.repository.IStaffRepo;

@Service
public class StaffManager implements IStaffService {

	@Autowired
	private IStaffRepo staffRepo;
    private ModelMapper modelMapper;

    public StaffManager(IStaffRepo staffRepo, ModelMapper modelMapper) {
        this.staffRepo = staffRepo;
        this.modelMapper = modelMapper;
    }
	
	@Override
	public void save(Staff staff) {
		staffRepo.save(staff);		
	}

	@Override
	public List<StaffDTO> getAll() {
		List<Staff> listStaff = staffRepo.findAll();
		return Arrays.asList(modelMapper.map(listStaff, StaffDTO[].class));
	}

	@Override
	public StaffDTO update(Long id, StaffDTO staffDTO) {
		Staff staff = staffRepo.getOne(id);
		staff.setName(staffDTO.getName());
		staff.setLastname(staffDTO.getLastname());
		staff.setPhone(staffDTO.getPhone());
		staffRepo.save(staff);
		return modelMapper.map(staff, StaffDTO.class);
	}

	@Override
	public StaffDTO getById(Long id) {
		return modelMapper.map(staffRepo.getOne(id),StaffDTO.class);
	}

}
