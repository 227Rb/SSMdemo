package cn.yygcloud.ssmdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;


/*
*@Author : Nan
*@Description :
*@Date : 18:15 2020/9/25
*@Param :
*@return :
*@Desc :
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {


    private Integer eid;

    @Size(min=1,max = 10)
    private String eName;

    @Range(min=1,max=99)
    private Integer age;

    @Max(2)
    private Integer sex;

    @Size(max = 50)
    private String address;

    @Pattern(regexp = "(([1-9+]{2,4}-)?1[0-9]{10})")
    private String phone;

    @Size(min = 7,max = 20)
    @Pattern(regexp = "([1-9A-Za-z/*+_-]{7,20})")
    private String password;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
