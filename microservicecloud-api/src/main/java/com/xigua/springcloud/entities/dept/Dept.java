package com.xigua.springcloud.entities.dept;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xigua
 * @description
 * @date 2020/6/4
 **/

@NoArgsConstructor
@Data
@Accessors(chain = true)
@SuppressWarnings("serial")
public class Dept implements Serializable {

    private Long deptno;

    private String dname;

    private String db_source;

    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setDb_source("").setDname("");

    }
}
