package cn.yygcloud.ssmdemo.controller;

import cn.yygcloud.ssmdemo.common.enums.ExceptionEnum;
import cn.yygcloud.ssmdemo.common.exception.MyException;
import cn.yygcloud.ssmdemo.common.util.JsonUtils;
import cn.yygcloud.ssmdemo.domain.Employee;
import cn.yygcloud.ssmdemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName: EmployeeController
 * @Description:
 * @author: Nan
 * @date: 2020/9/26 1:21
 * @version: V1.0
 */

@Controller
@RequestMapping("demo")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("emp")
    public  ResponseEntity<List<Employee>> findAll(){
        List<Employee> employees = employeeService.findAll();
        System.out.println(employees);
        return ResponseEntity.ok(employees) ;
    }


    @PostMapping("emp")

    public ResponseEntity<Integer> add(@Valid @RequestBody Employee employee, BindingResult bindingResult, Model model){
        System.out.println(employee);
        if(bindingResult.hasErrors()){
            StringBuffer exMsg=new StringBuffer();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                exMsg.append(fieldError.getField()+":"+fieldError.getDefaultMessage()+"/");
            }
            throw new MyException(ExceptionEnum.INPUT_DATA_ERROR,exMsg.toString());
        }
        int result = employeeService.add(employee);
        model.addAttribute(result);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("emp")
    public ResponseEntity<Integer> update(@Valid @RequestBody Employee employee,BindingResult bindingResult){
        System.out.println("Put");
        System.out.println(employee);
        if(bindingResult.hasErrors()){
            StringBuffer exMsg=new StringBuffer();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                exMsg.append(fieldError.getField()+":"+fieldError.getDefaultMessage()+"/");
            }
            throw new MyException(ExceptionEnum.INPUT_DATA_ERROR,exMsg.toString());
        }
        employeeService.update(employee);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("emp/{id}")
    public ResponseEntity<Integer>  del(@PathVariable int id){
        int result = employeeService.del(id);
        return ResponseEntity.ok(result);
    }




}
