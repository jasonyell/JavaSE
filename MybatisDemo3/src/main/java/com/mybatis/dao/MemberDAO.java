package com.mybatis.dao;

import com.mybatis.pojo.Member;
import com.mybatis.pojo.MemberSearchCondition;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Mybatis-Demo3
 * @description
 * @author: JasonYell
 * @create: 2023-06-30 01:37
 **/
public interface MemberDAO {
    /**
     * 若条件查询中，如果查询条件个数不确定,可以直接使用hashmap作为参数,
     * 优点：无需单独定义存放查询条件的类
     * 缺点：当向map中存放参数时，kye必须与动态sql保持一致（）
     * @param params
     * @return
     */
    public List<Member> searchMember(HashMap<String,Object> params);

    /**
     * 也可以定义专门查询的条件的实体类存放参数
     * 优点： 设置参数时，无需关注属性
     * 缺点：需要单独定义一个类封装参数
     * @param params
     * @return
     */
    public List<Member> searchMember1(MemberSearchCondition params);

    public List<Member> searchMemberByCity(List<String> cities);

    /**
     * 根据昵称查询用户信息-模糊查询
     * 模糊查询需要使用${}取值，拼接SQL
     * 再使用${}时，即使只有一个参数也需要使用@Param注解声明参数的key（非string对象可以不用声明）
     * @param params
     * @return
     */
//    List<Member> searchMemberByNick(@Param("") String keyWord);

    List<Member> searchMemberByNick(HashMap<String,Object> params);

    Member queryMemberById(int mid);

    int updateMember(Member member);
}
