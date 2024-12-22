package com.mybatis.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/**
 * @program: Mybatis-Demo3
 * @description
 * @author: JasonYell
 * @create: 2023-09-18 01:48
 **/
public class DruidDataSourceFactory extends PooledDataSourceFactory {

    public DruidDataSourceFactory(){
        this.dataSource = new DruidDataSource();
    }
}
