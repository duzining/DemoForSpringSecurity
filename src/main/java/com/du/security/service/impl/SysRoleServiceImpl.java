package com.du.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.du.security.dao.SysRoleDao;
import com.du.security.model.SysRoleEntity;
import com.du.security.service.SysRoleService;
import org.springframework.stereotype.Service;

@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {
}
