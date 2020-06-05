package com.xigua.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.xigua.springcloud.entities.Dept;

import java.util.List;

/**
 * @author xigua
 * @description 客户端使用rest调用，提供了多种便捷访问远程Http服务的方法
 * @date 2020/6/4
 **/
@RestController
public class DeptController_Consumer {

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";


    private RestTemplate template;

    @Autowired
    public DeptController_Consumer(RestTemplate template) {
        this.template = template;
    }

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {

        //发表对象
        //参数1是服务端地址、参数二是入参、参数三十返回类型。
        return template.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get")
    public Dept get(@PathVariable("id") Long id) {
        return template.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List list() {
        return template.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        return template.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);

    }


}
