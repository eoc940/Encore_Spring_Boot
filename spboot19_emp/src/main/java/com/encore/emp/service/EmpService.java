package com.encore.emp.service;

import java.util.List;

import com.encore.emp.domain.EmployeeDto;

public interface EmpService {
	public List<EmployeeDto> findAllEmployees() throws Exception;
	public EmployeeDto findEmployeeById(int id) throws Exception;
	public  int getEmployeesTotal()throws Exception;	
	public List<EmployeeDto> findLikeEmployees(String name) throws Exception;	
	public void addEmployee(EmployeeDto emp) throws Exception;
	public boolean updateEmployee(EmployeeDto emp) throws Exception;
	public boolean deleteEmployee(int id) throws Exception;	
	public List<EmployeeDto>  findEmployeesByManagerId(int managerId)throws Exception;
	public List<EmployeeDto> findDepartmentsBydeptid(int dept_id)throws Exception;	
}
