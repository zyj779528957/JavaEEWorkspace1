package com.service.impl;

import com.dao.IProductDao;
import com.dao.impl.ProductDao;
import com.entity.Product;
import com.service.IProductService;

import java.util.List;

/**
 * Created by Aeyjie on 2017-04-23.
 */
public class ProductService implements IProductService {

    IProductDao dao = new ProductDao(); //多态

    /**
     * 得到所有产品对象集合
     *
     * @return
     */
    @Override
    public List getAll() {
        return dao.getAll();
    }

    /**
     * 通过ID得到单个对象
     * @param pid
     * @return
     */
    @Override
    public Product getObjById(int pid) {
        return dao.getObjById(pid);
    }

    /**
     * 通过ID删除单个对象
     * @param pid
     * @return
     */
    @Override
    public int DelObjById(int pid) {
        return dao.DelObjById(pid);
    }
}
