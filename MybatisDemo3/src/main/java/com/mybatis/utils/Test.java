package com.mybatis.utils;

import com.mybatis.dao.MemberDAO;
import com.mybatis.pojo.Member;

import java.util.HashMap;
import java.util.List;

/**
 * @program: Mybatis-Demo3
 * @description
 * @author: JasonYell
 * @create: 2023-09-18 01:09
 **/
public class Test {
    public static void main(String[] args) {
        MemberDAO mapper = MyBatisUtil.getMapper(MemberDAO.class);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("keyWord","花");
        List<Member> members = mapper.searchMemberByNick(params);
        for (Member m: members) {
            System.out.println(m);
        }
    }
}
