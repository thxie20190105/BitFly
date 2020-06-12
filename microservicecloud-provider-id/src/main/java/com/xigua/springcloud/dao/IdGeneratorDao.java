package com.xigua.springcloud.dao;

import com.xigua.springcloud.entities.idgenerator.IdGenerator;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xigua
 * @description
 * @date 2020/6/4
 **/
@Mapper
public interface IdGeneratorDao {

    IdGenerator findByBizType(long id);

    int updateMaxId(long bizType);

}
