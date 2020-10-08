package cn.yygcloud.ssmdemo.dao;


import cn.yygcloud.ssmdemo.domain.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface EmployeeDao {

    @Select("Select * from tb_employee")
    List<Employee> findAll();

    @Insert("insert into tb_employee(eName,age,sex,address,phone,password) values (#{eName},#{age},#{sex},#{address},#{phone},#{password})")
    int add(Employee employee);

    @Update("update tb_employee set eName=#{eName},age=#{age},sex=#{sex},address=#{address},phone=#{phone},password=#{password} where eid=#{eid}")
    int update(Employee employee);


    @Delete("delete from tb_employee where eid=#{eid}")
    int del(int id);
}
