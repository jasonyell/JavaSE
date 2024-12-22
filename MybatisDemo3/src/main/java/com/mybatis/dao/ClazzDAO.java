package com.mybatis.dao;

import com.mybatis.pojo.Clazz;

/**
 * @program: Mybatis-Demo3
 * @description
 * @author: JasonYell
 * @create: 2023-09-21 01:42
 **/
public interface ClazzDAO {
      Clazz queryClassByCid(int cid);
}
