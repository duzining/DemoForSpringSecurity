package com.du.security.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.du.security.dao.SysMenuDao;
import com.du.security.model.SysMenuEntity;
import com.du.security.service.SysMenuService;
import org.springframework.stereotype.Service;

@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {
}
