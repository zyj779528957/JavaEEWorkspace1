package com;

import com.alibaba.fastjson.JSON;
import com.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * json测试类
 *
 * Created by Aeyjie on 2017-04-22.
 */
public class TestJason {

    /**
     * 得到单个对象并转换为json格式
     */
    public  static  void oneObj(){
        User u1 = new User("1","小明","admin","男");

        String jsons = JSON.toJSONString(u1);
        System.out.println("TestJason-oneObj: "+jsons);
    }

    /**
     * 得到多个对象的list集合并转换为json格式
     */
    public  static  void listObj(){

        User u1 = new User("1","小明","admin","男");
        User u2 = new User("2","小李","admin","男");
        User u3 = new User("3","小红","admin","女");

        List<User> list = new ArrayList<User>();

         list.add(u1);
         list.add(u2);
         list.add(u3);

        String jsons = JSON.toJSONString(list);
        System.out.println("TestJason-listObj: "+jsons);
    }


    /**
     * main方法入口
     * @param args
     */
    public static void main(String[] args) {

        //补注：在输出显示的json格式中,对象用{}包裹，数组和集合用[]包裹

        oneObj();  // TestJason-oneObj: {"uid":"1","uname":"小明","upwd":"admin","usex":"男"}
        listObj(); // TestJason-listObj: [{"uid":"1","uname":"小明","upwd":"admin","usex":"男"},{"uid":"2","uname":"小李","upwd":"admin","usex":"男"},{"uid":"3","uname":"小红","upwd":"admin","usex":"女"}]
    }

}
