package com.jason.service;

import com.jason.bean.Clothes;
import com.jason.utils.BusinessException;

import java.util.List;

/**
 * @program: ClothesSupermarketSystem
 * @description
 * @author: JasonYell
 * @create: 2023-03-22 01:21
 **/
public interface ClothesService {
    List<Clothes> list() throws BusinessException;

    Clothes findById(String cid) throws BusinessException;

    void update() throws BusinessException;
}
