package cn.yygcloud.ssmdemo.dao;


import cn.yygcloud.ssmdemo.domain.Employee;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/*
*@Author : Nan
*@Description :
*@Date : 18:12 2020/9/25
*@Param :
*@return :
*@Desc :
*/
@Repository
public interface HelloDao {

    @Select("Select * from tb_employee where id=#{id} ")
    Employee findOne(int id);

}
