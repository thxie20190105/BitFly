package com.xigua.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.xigua.springcloud.entities.Dept;

import java.util.List;

/**
 * @author xigua
 * @description
 * @date 2020/6/4
 **/
@Mapper
public interface DeptDao {

    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
