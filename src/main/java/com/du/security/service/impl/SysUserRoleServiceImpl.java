package com.du.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.du.security.dao.SysUserRoleDao;
import com.du.security.model.SysUserRoleEntity;
import com.du.security.service.SysUserRoleService;
import org.springframework.stereotype.Service;

@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {
}
