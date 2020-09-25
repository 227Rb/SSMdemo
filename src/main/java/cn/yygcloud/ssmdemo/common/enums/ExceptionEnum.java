package cn.yygcloud.ssmdemo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
*@Author : Nan
*@Description : 通用异常枚举
*@Date : 18:50 2020/9/25
*@Param :
*@return :
*@Desc :
*/
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnum {
    INPUT_DATA_ERROR(400,"输入数据有误"),
    SYSTEM_ERROR(500,"系统异常,请联系管理员")
    ;
    private Integer code;
    private String msg;
}
