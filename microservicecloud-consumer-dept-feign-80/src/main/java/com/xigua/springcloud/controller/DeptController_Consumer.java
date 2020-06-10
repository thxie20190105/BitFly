package com.xigua.springcloud.controller;

import com.xigua.springcloud.entities.Dept;
import com.xigua.springcloud.server.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xigua
 * @description 客户端使用rest调用，提供了多种便捷访问远程Http服务的方法
 * @date 2020/6/4
 **/
@RestController
public class DeptController_Consumer {
    private DeptClientService service;

    @Autowired
    public DeptController_Consumer(DeptClientService service) {
        this.service = service;
    }

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {

        //发表对象
        //参数1是服务端地址、参数二是入参、参数三十返回类型。
        return service.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List list() {
        return service.list();
    }


}
