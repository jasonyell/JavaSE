package com.jason.utils;

/**
 * @program: ClothesSupermarketSystem
 * @description
 * @author: JasonYell
 * @create: 2023-03-20 01:03
 **/
public class EmptyUtils {
    public static boolean isEmpty(String string){
        if(null==string || "".equals(string)){
            return true;
        }else{
            return false;
        }
    }
}
