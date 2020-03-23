package com.du.security.util;

import com.du.security.security.entity.SelfUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *Security工具类
 */
public class SecurityUtil {

    private SecurityUtil() {
    }

    /**
     * 获取当前用户信息
     * @return
     */
    public static SelfUserEntity getUserInfo(){
        SelfUserEntity userDetails = (SelfUserEntity) SecurityContextHolder
                                                    .getContext()
                                                    .getAuthentication()
                                                    .getPrincipal();

        return userDetails;
    }

    /**
     * 获取当前用户ID
     */
    public static Long getUserId(){
        return getUserInfo().getUserId();
    }

    /**
     * 获取当前用户账号
     */
    public static String getUserName(){
        return getUserInfo().getUsername();
    }
}
