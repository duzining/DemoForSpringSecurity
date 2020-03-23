package com.du.security.security.service;

import com.du.security.model.SysUserEntity;
import com.du.security.security.entity.SelfUserEntity;
import com.du.security.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * SpringSecurity用户的业务实现
 */
@Component
public class SelfUserDetailsService implements UserDetailsService {

    private final SysUserService sysUserService;

    public SelfUserDetailsService(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @Override
    public SelfUserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        SysUserEntity sysUserEntity = sysUserService.selectUserByName(username);
        if (sysUserEntity != null){
            //组装参数
            SelfUserEntity selfUserEntity = new SelfUserEntity();
            BeanUtils.copyProperties(sysUserEntity,selfUserEntity);
            return selfUserEntity;
        }
        return null;
    }
}
