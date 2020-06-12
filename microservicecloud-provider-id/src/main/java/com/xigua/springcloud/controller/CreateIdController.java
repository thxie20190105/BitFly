package com.xigua.springcloud.controller;

import com.xigua.springcloud.service.CreateIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

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

    /**
     * 雪花ID
     *
     * @param dataId
     * @param mcId
     * @return
     */
    //@PathVariable("id") long id
    @RequestMapping(value = "/Cid/deptId/{dataId}/{mcId}", method = RequestMethod.GET)
    public long createDeptId(@PathVariable("dataId") long dataId, @PathVariable("mcId") long mcId) {
        long l = service.createDeptId(dataId, mcId);
        System.out.println(l);
        return l;
    }

    /**
     * 通过数据库号段模式,返回一个id集合
     *
     * @param bizType
     * @return
     */
    @RequestMapping(value = "/Cid/deptIdForDb/{bizType}", method = RequestMethod.GET)
    @Transactional
    public LinkedList<Long> createDeptIdForDb(@PathVariable("bizType") long bizType) {
        long l = service.createDeptIdForDb(bizType);
        System.out.println(l);
        LinkedList<Long> list = new LinkedList<Long>();
        for (long i = l; i < l + 500; i++) {
            list.addFirst(i);
        }

        return list;
    }

}
