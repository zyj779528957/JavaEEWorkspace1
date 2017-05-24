package com.dao.impl;

import com.dao.IProductDao;
import com.entity.Product;
import com.entity.ProductCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aeyjie on 2017-04-23.
 */
public class ProductDao extends BaseDao implements IProductDao {

    /**
     * 得到所有产品对象集合
     *
     * @return
     */
    @Override
    public List getAll() {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = super.init(); //初始化(即得到连接)

        Product p1 = null; //声明产品对象
        ArrayList<Product> list = new ArrayList<Product>();


        String sql = "select * from easybuy_product";

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){

               /*
                Integer pid;			//商品ID
                String  pname;			//商品名称
                String  pprice;			//价格
                String  pdescription;	//商品描述
                String  pstock;			//库存
                Integer pcid;			//类别ID
                Integer pchildid; 		//二级分类ID（即子ID）
                String  pfilename;		//上传文件路径*/

                p1 = new Product();

                p1.setPid(rs.getInt("EP_ID"));
                p1.setPname(rs.getString("EP_NAME"));
                p1.setPprice(rs.getString("EP_PRICE"));
                p1.setPdescription(rs.getString("EP_DESCRIPTION"));
                p1.setPstock(rs.getString("EP_STOCK"));
                p1.setPcid(rs.getInt("EPC_ID"));
                p1.setPchildid(rs.getInt("EPC_CHILD_ID"));
                p1.setPfilename(rs.getString("EP_FILE_NAME"));

                list.add(p1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.close(conn, ps, rs); //关闭连接
        }

        return list;
    }

    /**
     * 通过ID得到单个对象
     *
     * @return
     */
    @Override
    public Product getObjById(int pid) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        conn = super.init(); //初始化(即得到连接)

        Product p1 = null; //声明产品对象


        String sql = "select * from easybuy_product t where ep_id = ?";

        try {

            ps = conn.prepareStatement(sql);
            ps.setInt(1, pid);
            rs = ps.executeQuery();

            while(rs.next()){
               /* Integer pid;			//商品ID
                String  pname;			//商品名称
                String  pprice;			//价格
                String  pdescription;	//商品描述
                String  pstock;			//库存
                Integer pcid;			//类别ID
                Integer pchildid; 		//二级分类ID（即子ID）
                String  pfilename;		//上传文件路径*/

                p1 = new Product();

                p1.setPid(rs.getInt("EP_ID"));
                p1.setPname(rs.getString("EP_NAME"));
                p1.setPprice(rs.getString("EP_PRICE"));
                p1.setPdescription(rs.getString("EP_DESCRIPTION"));
                p1.setPstock(rs.getString("EP_STOCK"));
                p1.setPcid(rs.getInt("EPC_ID"));
                p1.setPchildid(rs.getInt("EPC_CHILD_ID"));
                p1.setPfilename(rs.getString("EP_FILE_NAME"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.close(conn, ps, rs); //关闭连接
        }

        return p1;
    }


    /**
     * 通过ID删除单个对象
     * @param pid
     * @return
     */
    @Override
    public int DelObjById(int pid) {
        String sql= "delete from easybuy_product where ep_id = ?";
        int count = super.updade(sql, pid);
        return count;
    }
}
