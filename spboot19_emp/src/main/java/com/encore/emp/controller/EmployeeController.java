package com.encore.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.encore.emp.domain.EmployeeDto;
import com.encore.emp.service.EmpService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("api")
@CrossOrigin(origins = {" * "}, maxAge = 6000) // 정리하자
@Api(tags = {"Encore HRM"})
public class EmployeeController {
	
	@Autowired
	private EmpService service;
	
	@ApiOperation(value="모든 사원의 정보를 반환한다", response=List.class)
	@GetMapping("findAllEmployees")
	public ResponseEntity<List<EmployeeDto>> findAllEmployees() throws Exception {
		List<EmployeeDto> emps = service.findAllEmployees();
		if(emps.isEmpty()) return new ResponseEntity<List<EmployeeDto>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<EmployeeDto>>(emps,HttpStatus.OK);
	}
	
	@ApiOperation(value="모든 사원의 총 인원수를 반환한다", response=Integer.class)
	@GetMapping("getEmployeesTotal")
	public ResponseEntity<Integer> getEmployeesTotal() throws Exception {
		Integer empTotal = service.getEmployeesTotal();
		if(empTotal == 0) return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Integer>(empTotal, HttpStatus.OK);
	}
	
	@ApiOperation(value="사원아이디로 사원의 정보를 찾는다", response=EmployeeDto.class)
	@GetMapping("findEmployeeById/{id}")
	public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable int id) throws Exception {
		EmployeeDto emp = service.findEmployeeById(id);
		if(emp == null) return new ResponseEntity<EmployeeDto>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<EmployeeDto>(emp, HttpStatus.OK);
	}
	// 이따가 해보자 -> postman에서 한글이 안먹는 거였음
	@ApiOperation(value="특정한 이름이 들어간 사원을 찾는다", response=List.class)
	@GetMapping("findLikeEmployees/{name}")
	public ResponseEntity<List<EmployeeDto>> findEmployeeById(@PathVariable String name) throws Exception {
		List<EmployeeDto> emps = service.findLikeEmployees(name);
		System.out.println(emps);
		if(emps.isEmpty()) return new ResponseEntity<List<EmployeeDto>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<EmployeeDto>>(emps, HttpStatus.OK);
	}
	
	@ApiOperation(value="특정한 매니저에 소속된 사원들을 찾는다", response=List.class) // response에 EmployeeDto.class 라고 해도 된다
	@GetMapping("findEmployeesByManagerId/{managerId}")
	public ResponseEntity<List<EmployeeDto>> findEmployeesByManagerId(@PathVariable int managerId) throws Exception {
		List<EmployeeDto> emps = service.findEmployeesByManagerId(managerId);
		if(emps.isEmpty()) return new ResponseEntity<List<EmployeeDto>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<EmployeeDto>>(emps, HttpStatus.OK);
	}
	
	@ApiOperation(value="특정한 사원을 추가한다", response=EmployeeDto.class)
	@PostMapping("addEmployee")
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto emp) throws Exception {
		try {
			service.addEmployee(emp);
			return new ResponseEntity<EmployeeDto>(HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<EmployeeDto>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="사원의 정보를 수정한다", response=EmployeeDto.class)
	@PutMapping("updateEmployee")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto emp) throws Exception {
		boolean result = service.updateEmployee(emp);
		if (!result) return new ResponseEntity<EmployeeDto>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<EmployeeDto>(HttpStatus.OK);
	}
	
	@ApiOperation(value="특정한 사원을 삭제한다", response=EmployeeDto.class)
	@DeleteMapping("deleteEmployee/{id}")
	public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable int id) throws Exception {
		boolean result = service.deleteEmployee(id);
		if (!result) return new ResponseEntity<EmployeeDto>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<EmployeeDto>(HttpStatus.OK);
	}
	
	
}
