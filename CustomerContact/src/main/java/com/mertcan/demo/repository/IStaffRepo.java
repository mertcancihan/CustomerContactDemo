package com.mertcan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mertcan.demo.entity.Staff;

public interface IStaffRepo extends JpaRepository<Staff,Long>{

}
