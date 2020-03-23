package com.du.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.du.security.model.SysMenuEntity;
import com.du.security.model.SysRoleEntity;
import com.du.security.model.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {

    List<SysRoleEntity> selectSysRoleByUserId(Long userId);

    List<SysMenuEntity> selectSysMenuByUserId(Long userId);
}
