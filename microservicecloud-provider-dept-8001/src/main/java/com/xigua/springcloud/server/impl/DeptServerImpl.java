package com.xigua.springcloud.server.impl;

import com.xigua.springcloud.dao.DeptDao;
import com.xigua.springcloud.server.DeptServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xigua.springcloud.entities.Dept;

import java.util.List;

/**
 * @author xigua
 * @description
 * @date 2020/6/4
 **/
@Service
public class DeptServerImpl implements DeptServer {

    private DeptDao dao;

    @Autowired
    public DeptServerImpl(DeptDao dao) {
        this.dao = dao;
    }


    @Override
    public boolean add(Dept dept) {
        return dao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return dao.findAll();
    }
}
