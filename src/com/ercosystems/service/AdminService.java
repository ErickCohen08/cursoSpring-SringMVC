package com.ercosystems.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ercosystems.dao.AdminDao;
import com.ercosystems.pojo.Admin;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public boolean save(Admin admin){
		admin.setFechaCreacion(new Timestamp(new Date().getTime()));
		return adminDao.save(admin);
	}
	
	public int[] saveAll(List<Admin> admins){
		return adminDao.saveAll(admins);
	}
}
