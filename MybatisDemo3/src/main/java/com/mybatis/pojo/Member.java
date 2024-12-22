package com.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: Mybatis-Demo3
 * @description
 * @author: JasonYell
 * @create: 2023-06-21 00:22
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member implements Serializable {
    private int memberId;
    private String memberNick;
    private String memberGender;
    private Integer memberAge;
    private String  memberCity;
}
