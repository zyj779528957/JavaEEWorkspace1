package com.dao.impl;

import com.dao.IProductCategoryDao;
import com.entity.ProductCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Aeyjie on 2017-04-23.
 */
public class ProductCategoryDao extends BaseDao implements IProductCategoryDao {


    /**
     * 得到所有父产品类别对象集合（第一级）
     *
     * @return
     */
    @Override
    public List<ProductCategory> getAllParent() {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = super.init(); //初始化(即得到连接)

        ProductCategory pc1; //声明产品类别对象
        ArrayList<ProductCategory> list = new ArrayList<ProductCategory>();


        String sql = "select * from easybuy_product_category t where epc_id = epc_parent_id";

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){

                pc1 = new ProductCategory(rs.getInt("EPC_ID"), rs.getString("EPC_NAME"), rs.getInt("EPC_PARENT_ID")) ;

                list.add(pc1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.close(conn, ps, rs); //关闭连接
        }

        return list;
    }

    /**
     * 得到所有子产品类别对象集合（第二级）
     *
     * @return
     */
    @Override
    public List<ProductCategory> getAllChild() {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = super.init(); //初始化(即得到连接)

        ProductCategory pc1; //声明产品类别对象
        ArrayList<ProductCategory> list = new ArrayList<ProductCategory>();


        String sql = "select * from easybuy_product_category t where epc_id != epc_parent_id";

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){

                pc1 = new ProductCategory(rs.getInt("EPC_ID"), rs.getString("EPC_NAME"), rs.getInt("EPC_PARENT_ID")) ;

                list.add(pc1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.close(conn, ps, rs); //关闭连接
        }

        return list;
    }



}
