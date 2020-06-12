package com.xigua.springcloud.service;

import com.xigua.springcloud.util.SnowFlakeShortUrl;
import org.springframework.stereotype.Service;

/**
 * @author xigua
 * @description
 * @date 2020/6/12
 **/
@Service
public class CreateIdService {

    public long createDeptId(long dataId, long mcId) {
        SnowFlakeShortUrl snowFlake = new SnowFlakeShortUrl(dataId, mcId);
        return snowFlake.nextId();
    }
}
