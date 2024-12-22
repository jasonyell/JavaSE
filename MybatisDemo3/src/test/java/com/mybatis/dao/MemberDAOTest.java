package com.mybatis.dao;

import com.mybatis.pojo.Member;
import com.mybatis.pojo.MemberSearchCondition;
import com.mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: Mybatis-Demo3
 * @description
 * @author: JasonYell
 * @create: 2023-06-30 01:39
 **/
public class MemberDAOTest {

    @Test
    public void testSearchMember(){

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("gender","女");
        params.put("city","西安");

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        MemberSearchCondition params2 = new MemberSearchCondition();
        params2.setGender("女");
//        params2.setMinAge(11);
//        params2.setMaxAge(30);
//        params2.setCity("西安");

        MemberDAO memberDAO = MyBatisUtil.getMapper(MemberDAO.class);
        List<Member> members = memberDAO.searchMember1(params2);

        for (Member m : members){
            System.out.println(m);
        }

    }


    @Test
    public void searchMemberByCity() {
        List<String> cities = new ArrayList<String>();
        cities.add("西安");
        cities.add("广元");
        cities.add("咸阳");

        MemberDAO members = MyBatisUtil.getMapper(MemberDAO.class);
        List<Member> members1 = members.searchMemberByCity(cities);
        for (Member m : members1) {
            System.out.println(m);
        }
    }


    @Test
    public void searchMemberByNick() {
        MemberDAO mapper = MyBatisUtil.getMapper(MemberDAO.class);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("keyWord","花");
        List<Member> members = mapper.searchMemberByNick(params);
        for (Member m: members) {
            System.out.println(m);
        }
    }

    @Test
    public void TestQueryMemberById(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        MemberDAO mapper = MyBatisUtil.getMapper(MemberDAO.class);
        Member member = mapper.queryMemberById(1);
        System.out.println(member);
        
//        sqlSession.clearCache();
//        sqlSession.close();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Member member1 = mapper.queryMemberById(1);
        System.out.println(member1);
    }

    @Test
    public void TestQueryMemberById1(){
        SqlSessionFactory factory = MyBatisUtil.getFactory();
        // 多个sqlsession对象必须来自于同一个sqlsessionfactory
        SqlSession sqlSession1 = factory.openSession(true);
        SqlSession sqlSession2 = factory.openSession(true);
        System.out.println(sqlSession1==sqlSession2);

        MemberDAO mapper1 = sqlSession1.getMapper(MemberDAO.class);
        Member member1 = mapper1.queryMemberById(1);
        System.out.println(member1);
        sqlSession1.commit();   //第一次查询后执行sqlsession.commit(),会将当前sqlsession的查询结果存到二级缓存

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        MemberDAO mapper = sqlSession2.getMapper(MemberDAO.class);
        Member member2 = mapper.queryMemberById(1);
        System.out.println(member2);
    }
}