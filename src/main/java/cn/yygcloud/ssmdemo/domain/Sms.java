package cn.yygcloud.ssmdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @ClassName: Sms
 * @Description:
 * @author: Nan
 * @date: 2020/10/7 15:06
 * @version: V1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sms {

        @Pattern(regexp = "(([1-9+]{2,4}-)?1[0-9]{10})")
        private String phoneNumber ;

        @Size(min=6,max=6)
        @Pattern(regexp = "[0-9A-Za-z]]{6}")
        private  String code;

        private   final  int min =5;


}
