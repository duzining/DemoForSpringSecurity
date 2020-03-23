package com.du.security.security.handler;

import com.du.security.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败处理类
 */
@Slf4j
@Component
public class UserLoginFailureHander implements AuthenticationFailureHandler {

    /**
     * 登录失败返回结果
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //这些对呀财政的处理类可以根据不同异常进行不同处理
        if (e instanceof UsernameNotFoundException){
            log.info("【登录失败】" + e.getMessage());
            ResultUtil.responseJson(httpServletResponse,ResultUtil.resultCode(500,"用户名不存在"));
        }
        if (e instanceof LockedException){
            log.info("【登录失败】" + e.getMessage());
            ResultUtil.responseJson(httpServletResponse,ResultUtil.resultCode(500,"用户被冻结"));

        }
        if (e instanceof BadCredentialsException){
            log.info("【登录失败】" + e.getMessage());
            ResultUtil.responseJson(httpServletResponse,ResultUtil.resultCode(500,"用户名密码不正确"));
        }
        ResultUtil.responseJson(httpServletResponse,ResultUtil.resultCode(500,"登录失败"));
    }
}
