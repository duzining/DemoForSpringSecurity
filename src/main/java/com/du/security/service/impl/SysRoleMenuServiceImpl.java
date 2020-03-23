package com.du.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.du.security.dao.SysRoleMenuDao;
import com.du.security.model.SysRoleMenuEntity;
import com.du.security.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenuEntity> implements SysRoleMenuService {
}
