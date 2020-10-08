package cn.yygcloud.ssmdemo.common.util;


import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName: MsgUtils
 * @Description:
 * @author: Nan
 * @date: 2020/10/7 15:11
 * @version: V1.0
 */

public class MsgUtils {
    private static String fileName="sms.properties";
    private static SmsSingleSender smsSingleSender;
    private static Properties properties;

    private  static void  initSender(){
        properties  =new Properties();
        InputStream resourceAsStream = MsgUtils.class.getClassLoader().getResourceAsStream(fileName);
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException("配置文件"+fileName+"不存在");
        }
        smsSingleSender=new SmsSingleSender(Integer.parseInt(properties.getProperty("sms.appID")),properties.getProperty("sms.appKey"));
    }
    /*
    *@Author : Nan
    *@Description :发送验证码
    *@Date : 16:25 2020/10/7
    *@Param : [phoneNumber, code, work]
    *@return : com.github.qcloudsms.SmsSingleSenderResult
    *@Desc :
    */
    public  static  String sendVerification(String phoneNumber,String code){
        if(smsSingleSender==null){
            initSender();
        }

        String[] params={code};
        SmsSingleSenderResult result = null;
        try {
             result = smsSingleSender.sendWithParam("86", phoneNumber,
                            Integer.parseInt(properties.getProperty("sms.templateID")),
                            params, properties.getProperty("sms.sign"), "", "");
        } catch (HTTPException e) {
            System.out.println(e);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return  result.errMsg;
    }

}
