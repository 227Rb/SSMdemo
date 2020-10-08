package cn.yygcloud.ssmdemo.common.exception;

import cn.yygcloud.ssmdemo.common.enums.ExceptionEnum;
import cn.yygcloud.ssmdemo.common.util.JsonUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: MyHandlerExceptionResolver
 * @Description:
 * @author: Nan
 * @date: 2020/9/25 18:58
 * @version: V1.0
 */

@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    ModelAndView mv =new ModelAndView();
    private static final Logger logger = LogManager.getLogger(MyHandlerExceptionResolver.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //判断时候为AJAX
        if (httpServletRequest.getHeader("X-Requested-With")!=null){
            //自定义的异常
            MyException ex=null;
            if(e instanceof MyException){
                ex =(MyException)e;
            }else{
                logger.error(e);
                ex=new MyException(ExceptionEnum.SYSTEM_ERROR,e.toString());
            }
            try {
                httpServletResponse.setContentType("text/javascript;charset=utf-8");
                httpServletResponse.setCharacterEncoding("utf-8");
//                httpServletResponse.setStatus(ex.getEe().getCode());
                httpServletResponse.getWriter().println(JsonUtils.ExceptiontoJson(ex));
            } catch (IOException e1) {
                return null;
            }
            return mv;
        }else{
            logger.error(e);
            mv.setViewName("500");
            return mv;
        }

    }
}
