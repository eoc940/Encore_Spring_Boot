package com.encore.emp.repo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.emp.domain.EmployeeDto;


@Repository
public class EmpDaopImpl implements EmpDao{
	
	private String ns = "EmpMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<EmployeeDto> findAllEmployees() throws Exception {		
		return sqlSession.selectList(ns+"findAllEmployees");
	}

	@Override
	public EmployeeDto findEmployeeById(int id) throws Exception {
		return sqlSession.selectOne(ns+"findEmployeeById", id);
	}

	@Override
	public int getEmployeesTotal() throws Exception {
		return sqlSession.selectOne(ns+"getEmployeesTotal");
	}
	@Override
	public List<EmployeeDto> findLikeEmployees(String name) throws Exception {
		return sqlSession.selectList(ns+"findLikeEmployees", name);
	}
	@Override
	public void addEmployee(EmployeeDto emp) throws Exception {
		sqlSession.insert(ns+"addEmployee", emp);		
	}
	@Override
	public boolean updateEmployee(EmployeeDto emp) throws Exception {
		int result=sqlSession.update(ns+"updateEmployee", emp);
		if(result>0) return true;
		return false;
	}
	@Override
	public boolean deleteEmployee(int id) throws Exception {
		int result=sqlSession.delete(ns+"deleteEmployee", id);
		if(result>0) return true;
		return false;	
	}
	@Override
	public List<EmployeeDto> findEmployeesByManagerId(int managerId) throws Exception {
		return sqlSession.selectList(ns+"findEmployeesByManagerId", managerId);
	}
	@Override
	public List<EmployeeDto> findDepartmentsBydeptid(int dept_id) throws Exception {
		return sqlSession.selectList(ns+"findDepartmentsBydeptid", dept_id);
	}
}
