package com.du.security.security.handler;


import com.du.security.config.JWTConfig;
import com.du.security.security.entity.SelfUserEntity;
import com.du.security.util.JWTTokenUtil;
import com.du.security.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *  登录成功处理类
 */
@Slf4j
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {
    /**
     * 登录成功返回结果
     * @param httpServletRequest
     * @param httpServletResponse
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //组装JWT
        SelfUserEntity selfUserEntity = (SelfUserEntity) authentication.getPrincipal();
        String token = JWTTokenUtil.createAccessToken(selfUserEntity);
        token = JWTConfig.tokenPrefix + token;

        //封装返回参数
        Map<String,Object> resultData = new HashMap<>();
        resultData.put("code",200);
        resultData.put("msg","登录成功");
        resultData.put("token",token);
        ResultUtil.responseJson(httpServletResponse,resultData);
    }
}
