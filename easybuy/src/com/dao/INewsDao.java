package com.dao;

import com.entity.News;

import java.util.List;

/**
 * 数据层新闻接口
 * Created by Aeyjie on 2017-04-20.
 */
public interface INewsDao {

    /**
     * 得到所有新闻对象集合
     * @return
     */
    public List<News> getAll();


}
