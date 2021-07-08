package com.encore.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.emp.domain.EmployeeDto;
import com.encore.emp.repo.EmpDao;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDao  empDao;
	
	@Override
	public List<EmployeeDto> findAllEmployees() throws Exception {
		return empDao.findAllEmployees();
	}

	@Override
	public EmployeeDto findEmployeeById(int id) throws Exception {
		return empDao.findEmployeeById(id);
	}

	@Override
	public int getEmployeesTotal() throws Exception {
		return empDao.getEmployeesTotal();
	}

	@Override
	public List<EmployeeDto> findLikeEmployees(String name) throws Exception {
		return empDao.findLikeEmployees(name);
	}

	@Override
	public void addEmployee(EmployeeDto emp) throws Exception {
		empDao.addEmployee(emp);
		
	}

	@Override
	public boolean updateEmployee(EmployeeDto emp) throws Exception {
		return empDao.updateEmployee(emp);
	}

	@Override
	public boolean deleteEmployee(int id) throws Exception {
		return empDao.deleteEmployee(id);
	}

	@Override
	public List<EmployeeDto> findEmployeesByManagerId(int managerId) throws Exception {
		return empDao.findEmployeesByManagerId(managerId);
	}

	@Override
	public List<EmployeeDto> findDepartmentsBydeptid(int dept_id) throws Exception {
		return empDao.findDepartmentsBydeptid(dept_id);
	}

}
