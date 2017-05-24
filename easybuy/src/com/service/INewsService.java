package com.service;

import com.entity.News;

import java.util.List;

/**
 * Created by Aeyjie on 2017-04-20.
 */
public interface INewsService {

    /**
     * 得到所有新闻对象集合
     * @return
     */
    public List<News> getAll();

}
