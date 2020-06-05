package com.xigua.springcloud.server;

import com.xigua.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author xigua
 * @description 面向接口编程进一步访问
 * @date 2020/6/5
 **/
@FeignClient(value = "MICROSERVICECLOUD-DEPT")
public interface DeptClientService {
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    Dept get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    List<Dept> list();

    @RequestMapping(value = "/dept/add", method = RequestMethod.GET)
    boolean add(Dept dept);


}
