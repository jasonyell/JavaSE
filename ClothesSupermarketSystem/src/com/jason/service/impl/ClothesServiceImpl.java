package com.jason.service.impl;

import com.jason.bean.Clothes;
import com.jason.service.ClothesService;
import com.jason.utils.BusinessException;
import com.jason.utils.ClothesIO;
import com.jason.utils.ProductsXmlUtils;

import java.io.IOException;
import java.util.List;

/**
 * @program: ClothesSupermarketSystem
 * @description
 * @author: JasonYell
 * @create: 2023-03-22 01:22
 **/
public class ClothesServiceImpl implements ClothesService {

    private ClothesIO clothesIO = new ClothesIO();

    @Override
    public List<Clothes> list() throws BusinessException {
        return clothesIO.list();
    }

    @Override
    public Clothes findById(String cid) throws BusinessException {
        return clothesIO.findById(cid);
    }

    @Override
    public void update() throws BusinessException {
        clothesIO.update();
    }


}
