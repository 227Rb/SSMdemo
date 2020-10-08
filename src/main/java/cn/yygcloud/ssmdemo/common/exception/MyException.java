package cn.yygcloud.ssmdemo.common.exception;


import cn.yygcloud.ssmdemo.common.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @ClassName: MyException
 * @Description: 自定义异常
 * @author: Nan
 * @date: 2020/9/25 18:53
 * @version: V1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MyException extends RuntimeException {
    private ExceptionEnum ee;
    private String exMsg;

    public MyException(ExceptionEnum ee){
        this.ee=ee;
    }


}
