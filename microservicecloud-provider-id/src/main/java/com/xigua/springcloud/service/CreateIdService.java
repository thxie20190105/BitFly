package com.xigua.springcloud.service;

import com.xigua.springcloud.dao.IdGeneratorDao;
import com.xigua.springcloud.entities.idgenerator.IdGenerator;
import com.xigua.springcloud.util.SnowFlakeShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xigua
 * @description
 * @date 2020/6/12
 **/
@Service
public class CreateIdService {
    private IdGeneratorDao dao;


    @Autowired
    public CreateIdService(IdGeneratorDao dao) {
        this.dao = dao;
    }


    public long createDeptId(long dataId, long mcId) {
        SnowFlakeShortUrl snowFlake = new SnowFlakeShortUrl(dataId, mcId);
        return snowFlake.nextId();
    }

    public long createDeptIdForDb(long bizType) {
        IdGenerator i = dao.findByBizType(bizType);
        dao.updateMaxId(bizType);
        return i.getMaxId();
    }
}
