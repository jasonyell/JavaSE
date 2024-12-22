package com.jason.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: mybatis-demo2
 * @description
 * @author: JasonYell
 * @create: 2023-06-09 01:50
 **/
//get set
@Data
// 无参构造
@NoArgsConstructor
// 全参构造
@AllArgsConstructor
@ToString
public class Users {
    private int userId;
    private String userName;
    private String userPwd;
    private String userRealname;
    private String userImg;

    private Detail detail;
}
