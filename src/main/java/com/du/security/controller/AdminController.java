package com.du.security.controller;

import com.du.security.model.SysMenuEntity;
import com.du.security.model.SysRoleEntity;
import com.du.security.model.SysUserEntity;
import com.du.security.security.entity.SelfUserEntity;
import com.du.security.service.SysMenuService;
import com.du.security.service.SysRoleService;
import com.du.security.service.SysUserService;
import com.du.security.util.ResultUtil;
import com.du.security.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理端
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final SysUserService sysUserService;
    private final SysRoleService sysRoleService;
    private final SysMenuService sysMenuService;

    public AdminController(SysUserService sysUserService, SysRoleService sysRoleService, SysMenuService sysMenuService) {
        this.sysUserService = sysUserService;
        this.sysRoleService = sysRoleService;
        this.sysMenuService = sysMenuService;
    }

    /**
     * 管理端信息
     * @return
     */
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Map<String,Object> userLogin(){
        Map<String,Object> result = new HashMap<>();
        SelfUserEntity userDetails = SecurityUtil.getUserInfo();
        result.put("title","管理端信息");
        result.put("data",userDetails);
        return ResultUtil.resultSuccess(result);
    }


    /**
     * 拥有ADMIN或者USER角色可以访问
     */
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map<String,Object> list(){
        Map<String,Object> result = new HashMap<>();
        List<SysUserEntity> sysUserEntityList = sysUserService.list();
        result.put("title","拥有用户或者管理员角色都可以查看");
        result.put("data",sysUserEntityList);
        return ResultUtil.resultSuccess(result);
    }

    /**
     * 拥有ADMIN和USER角色可以访问
     */
    @PreAuthorize("hasRole('ADMIN') and hasRole('USER')")
    @RequestMapping(value = "/menuList",method = RequestMethod.GET)
    public Map<String,Object> menuList(){
        Map<String,Object> result =new HashMap<>();
        List<SysMenuEntity> sysMenuEntityList = sysMenuService.list();
        result.put("title","拥有用户和管理员角色都可以查看");
        result.put("data",sysMenuEntityList);
        return ResultUtil.resultSuccess(result);
    }

    /**
     * 拥有sys:user:info权限可以访问
     * hasPermission 第一个参数是请求路径 第二个参数是权限表达式
     */

    @PreAuthorize("hasPermission('/admin/userList','sys:user:info')")
    @RequestMapping(value = "/userList",method = RequestMethod.GET)
    public Map<String,Object> userList(){
        Map<String,Object> result =new HashMap<>();
        List<SysUserEntity> sysUserEntityList = sysUserService.list();
        result.put("title","拥有sys:user:info权限都卡宴查看");
        result.put("data",sysUserEntityList);
        return ResultUtil.resultSuccess(result);
    }


    /**
     * 拥有ADMIN角色和sys:role:info权限可以访问
     */
    @PreAuthorize("hasRole('ADMIN') and hasPermission('/admin/adminRoleList','sys:role:info')")
    @RequestMapping(value = "/adminRoleList",method = RequestMethod.GET)
    public Map<String,Object> adminRoleList(){
        Map<String,Object> result = new HashMap<>();
        List<SysRoleEntity> sysRoleEntityList = sysRoleService.list();
        result.put("title","拥有ADMIN角色和sys:role:info 权限可以访问");
        result.put("data",sysRoleEntityList);
        return ResultUtil.resultSuccess(result);
    }
}
