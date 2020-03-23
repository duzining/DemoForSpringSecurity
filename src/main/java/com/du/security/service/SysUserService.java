package com.du.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.du.security.model.SysMenuEntity;
import com.du.security.model.SysRoleEntity;
import com.du.security.model.SysUserEntity;

import java.util.List;

/**
 * 系统用户业务接口
 */
public interface SysUserService extends IService<SysUserEntity> {

    SysUserEntity selectUserByName(String username);

    List<SysRoleEntity> selectSysRoleByUserId(Long userId);

    List<SysMenuEntity> selectSysMenuByUserId(Long userId);
}
