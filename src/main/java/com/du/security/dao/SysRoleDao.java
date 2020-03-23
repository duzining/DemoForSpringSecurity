package com.du.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.du.security.model.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {
}
