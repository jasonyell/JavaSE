package com.jason.utils;

/**
 * @program: ClothesSupermarketSystem
 * @description
 * @author: JasonYell
 * @create: 2023-03-20 00:27
 **/
public class BusinessException extends RuntimeException {

    public BusinessException(){
        super();
    }

    public BusinessException(String errorMessage){
        super(errorMessage);
    }
}
