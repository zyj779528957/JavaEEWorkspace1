package com.service.impl;

import com.dao.IProductCategoryDao;
import com.dao.impl.ProductCategoryDao;
import com.entity.ProductCategory;
import com.service.IProductCategoryService;

import java.util.List;

/**
 * Created by Aeyjie on 2017-04-23.
 */
public class ProductCategoryService implements IProductCategoryService {

    IProductCategoryDao dao = new ProductCategoryDao(); //多态

    /**
     * 得到所有父产品类别对象集合（第一级）
     *
     * @return
     */
    @Override
    public List<ProductCategory> getAllParent() {
        return dao.getAllParent();
    }

    /**
     * 得到所有子产品类别对象集合（第二级）
     *
     * @return
     */
    @Override
    public List<ProductCategory> getAllChild() {
        return dao.getAllChild();
    }



}
