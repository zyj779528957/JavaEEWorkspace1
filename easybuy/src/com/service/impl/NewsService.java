package com.service.impl;

import com.dao.INewsDao;
import com.dao.impl.NewsDao;
import com.entity.News;
import com.service.INewsService;

import java.util.List;

/**
 * Created by Aeyjie on 2017-04-20.
 */
public class NewsService implements INewsService{

    INewsDao dao = new NewsDao(); //多态

    /**
     * 得到所有新闻对象集合
     *
     * @return
     */
    @Override
    public List<News> getAll() {
        return dao.getAll();
    }



}
