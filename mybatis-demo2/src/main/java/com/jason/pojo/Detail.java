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
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Detail {
    private int detailId;
    private String userAddr;
    private String userTel;
    private String userDesc;
    private int userId;
}
