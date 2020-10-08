package cn.yygcloud.ssmdemo.services.impl;

import cn.yygcloud.ssmdemo.common.enums.ExceptionEnum;
import cn.yygcloud.ssmdemo.common.exception.MyException;
import cn.yygcloud.ssmdemo.common.util.MsgUtils;
import cn.yygcloud.ssmdemo.common.util.RedisUtils;
import cn.yygcloud.ssmdemo.domain.Sms;
import cn.yygcloud.ssmdemo.services.MsgService;
import com.github.qcloudsms.SmsSenderUtil;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @ClassName: MsgServiceImpl
 * @Description:
 * @author: Nan
 * @date: 2020/10/6 22:12
 * @version: V1.0
 */

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
   private RedisUtils redisUtils;


    @Override
    public String CheckPhoneNum(Sms sms) {
        //以有验证码检验
        if(  !StringUtils.isEmpty(sms.getCode()) ){
            if(sms.getCode().length()==6){
                if( redisUtils.get(sms.getPhoneNumber())!=null &&
                     redisUtils.simpleGet(sms.getPhoneNumber()).equals(sms.getCode())
                ){
                    redisUtils.remove(sms.getPhoneNumber());
                    return "success";
                }else{
                    throw new MyException(ExceptionEnum.CODE_ERROR);
                }
            } else{
                throw new MyException(ExceptionEnum.CODE_ERROR);
            }
        }

        //判断时候 是否 发送验证
        if (redisUtils.exists(sms.getPhoneNumber())){
            if(redisUtils.getExpire(sms.getPhoneNumber())>240L){
                throw new MyException(ExceptionEnum.REQUEST_TO_FAST);
            }
        }

        //发送验证码
        String code= SmsSenderUtil.getRandom()+"";
//        String result = MsgUtils.sendVerification(sms.getPhoneNumber(), code);

        //加入缓存result.equals("OK")
        if(true){
            redisUtils.simpleSet(sms.getPhoneNumber(),code,300L);
        }

        return "wait";
    }



}
