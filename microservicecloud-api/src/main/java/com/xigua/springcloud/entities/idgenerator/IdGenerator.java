package com.xigua.springcloud.entities.idgenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author xigua
 * @description
 * @date 2020/6/12
 **/
@NoArgsConstructor
@Data
@Accessors(chain = true)
@SuppressWarnings("serial")
public class IdGenerator {
    private long id;

    private long maxId;

    private long step;

    private long version;
}
