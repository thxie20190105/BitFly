package com.xigua.springcloud.controller;

import com.xigua.springcloud.entities.Dept;
import com.xigua.springcloud.server.DeptServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xigua
 * @description
 * @date 2020/6/4
 **/
@RestController
public class DeptController {

    private DeptServer server;


    /**
     * 发现客户端，对外提供自己的服务情况
     */
    private DiscoveryClient discoveryClient;

    @Autowired
    public DeptController(DeptServer server, DiscoveryClient discoveryClient) {
        this.server = server;
        this.discoveryClient = discoveryClient;
    }

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(Dept dept) {
        return server.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id) {
        return server.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return server.list();
    }

    /**
     * @return
     */
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {

        //盘点eureka里一共有多少微服务
        List<String> list = discoveryClient.getServices();
        System.out.println("共有服务" + list.size() + "个");


        //指定具体微服务的信息
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("microservicecloud-dept");

        for (ServiceInstance serviceInstance : serviceInstances) {
            System.out.println(serviceInstance.getServiceId());
            System.out.println(serviceInstance.getUri());
            System.out.println(serviceInstance.getHost());
            System.out.println(serviceInstance.getPort());

        }
        return this.discoveryClient;
    }

}
