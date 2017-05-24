package com.dao;

import com.entity.Product;

import java.util.List;

/**
 * 数据层产品接口
 * Created by Aeyjie on 2017-04-23.
 */
public interface IProductDao {

    /**
     * 得到所有产品对象集合
     * @return
     */
    public List getAll();

    /**
     * 通过ID得到单个对象
     * @return
     */
    public Product getObjById(int pid);

    /**
     * 通过ID删除单个对象
     * @param pid
     * @return
     */
    public int DelObjById(int pid);



}
