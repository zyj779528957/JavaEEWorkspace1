package com.service;

import com.entity.ProductCategory;

import java.util.List;

/**
 * 业务层产品类别接口
 * Created by Aeyjie on 2017-04-23.
 */
public interface IProductCategoryService {

    /**
     * 得到所有父产品类别对象集合（第一级）
     * @return
     */
    public List<ProductCategory> getAllParent();

    /**
     * 得到所有子产品类别对象集合（第二级）
     * @return
     */
    public List<ProductCategory> getAllChild();



}
