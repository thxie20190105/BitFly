package com.xigua.springcloud.controller;

import com.xigua.springcloud.service.CreateIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xigua
 * @description
 * @date 2020/6/12
 **/
@RestController
public class CreateIdController {

    private CreateIdService service;

    @Autowired
    public CreateIdController(CreateIdService service) {
        this.service = service;
    }

    //@PathVariable("id") long id
    @RequestMapping(value = "/Cid/deptId", method = RequestMethod.GET)
    public long createDeptId(@PathVariable("dataId") long dataId, @PathVariable("mcId") long mcId) {
        long l = service.createDeptId(dataId, mcId);
        System.out.println(l);
        return l;
    }

}
