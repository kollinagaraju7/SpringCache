package com.spring.app.controller;

import com.spring.app.entity.Emp;
import com.spring.app.service.IEmpService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class EmpController {

    @Autowired
    private IEmpService empService;

    @ApiOperation(value = "View a list of available employees", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/employees")
    public ResponseEntity<List<Emp>> getAllEmployees() {
        List<Emp> list = empService.getEmployees();
        return new ResponseEntity<List<Emp>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Emp> getEmployeesById(@PathVariable("id") Long id) {
        Emp emp = empService.getEmpById(id);
        return new ResponseEntity<Emp>(emp, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * @param emp
     * @return
     */
    @PostMapping("/saveOrUpdateEmp")
    public ResponseEntity<String> saveOrUpdateEmp(@RequestBody Emp emp) {
        empService.saveOrUpdateEmp(emp);
        return new ResponseEntity<String>("Record save or updated successfully..", new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * @param id
     * @return
     */
    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long id) {
        empService.deleteEmp(id);
        return new ResponseEntity<String>("Record deleted successfully..", new HttpHeaders(), HttpStatus.OK);
    }
}
