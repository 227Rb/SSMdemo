package cn.yygcloud.ssmdemo.services.impl;

import cn.yygcloud.ssmdemo.dao.HelloDao;
import cn.yygcloud.ssmdemo.domain.Employee;
import cn.yygcloud.ssmdemo.services.HelloServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
*@Author : Nan
*@Description :
*@Date : 18:11 2020/9/25
*@Param :
*@return :
*@Desc :
*/
@Service("HelloServices")
public class HelloServicesImpl implements HelloServices {

    @Autowired
    private HelloDao helloDao;

    @Override
    public String find(int id) {

        Employee target = helloDao.findOne(id);
        return target.getName();
    }
}
