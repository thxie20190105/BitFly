package com.xigua.springcloud.server;

import com.xigua.springcloud.entities.dept.Dept;

import java.util.List;

/**
 * @author xigua
 * @description
 * @date 2020/6/4
 **/
public interface DeptServer {
    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();

}
