package com.example.springbootMVC.mapper;

import com.example.springbootMVC.entity.Permission;
import com.example.springbootMVC.mapper.PermissionExample;
import org.springframework.stereotype.Repository;

/**
 * PermissionMapper继承基类
 */
@Repository
public interface PermissionMapper extends MyBatisBaseDao<Permission, Integer, PermissionExample> {

}
