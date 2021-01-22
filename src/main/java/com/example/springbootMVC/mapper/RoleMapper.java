package com.example.springbootMVC.mapper;

import com.example.springbootMVC.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * RoleMapper继承基类
 */
@Repository
public interface RoleMapper extends MyBatisBaseDao<Role, Integer, RoleExample> {
    //void addPermissions(int id, int[] permissions);

//    void addPermission(int id, int permission);

    void addPermissions(int id, int[] permissions);

    Role findById(int id);
}