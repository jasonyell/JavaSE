package com.jason.dao;

import com.jason.pojo.Detail;

/**
 * @program: mybatis-demo2
 * @description
 * @author: JasonYell
 * @create: 2023-06-09 01:57
 **/
public interface DetailDao {
    public int insertDetail(Detail detail);

    public Detail queryDetailByUserId(int uid);
}
