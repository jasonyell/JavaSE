package com.mybatis.pojo;

import lombok.Data;

/**
 * @program: Mybatis-Demo3
 * @description
 * @author: JasonYell
 * @create: 2023-06-30 02:03
 **/
@Data
public class MemberSearchCondition {

    private String gender;
    private Integer minAge;
    private Integer maxAge;
    private String city;

}
