package cn.yygcloud.ssmdemo.controller;

import cn.yygcloud.ssmdemo.domain.Sms;
import cn.yygcloud.ssmdemo.services.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: MsgController
 * @Description:
 * @author: Nan
 * @date: 2020/10/6 22:05
 * @version: V1.0
 */

@Controller
@RequestMapping("msg")
public class MsgController {

        @Autowired
       private MsgService msgService;

        @PostMapping("/checkphonenum")
        public ResponseEntity<String> CheckPhoneNum(@RequestBody Sms sms){
                return  ResponseEntity.ok(msgService.CheckPhoneNum(sms)) ;
        }



}
