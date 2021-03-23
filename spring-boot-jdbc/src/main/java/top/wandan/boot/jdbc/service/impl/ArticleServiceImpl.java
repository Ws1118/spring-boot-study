package top.liekai.boot.jdbc.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.liekai.boot.jdbc.dao.ArticleDAO;
import top.liekai.boot.jdbc.entity.Article;
import top.liekai.boot.jdbc.service.ArticleService;

import javax.annotation.Resource;

/**
 * @author admin
 * @date 2021/3/16
 * @description ArticleServiceImpl
 */
/*回滚*/
@Transactional
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleDAO articleDAO;

    @Override
    public boolean postArticle(Article article) {
        Article saveArticle = articleDAO.save(article);
//        发生的异常
        int  a = 3/0;
        System.out.println(a);
        return saveArticle != null;

    }


}