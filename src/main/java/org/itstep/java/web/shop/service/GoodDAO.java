package org.itstep.java.web.shop.service;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.itstep.java.web.shop.model.Category;
import org.itstep.java.web.shop.model.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "goodDAO")
@Transactional
public class GoodDAO implements GoodService {

    @Autowired
    SessionFactory sf;
    
    @Override
    public List<Good> getList(Integer id) {
        Query q = sf.getCurrentSession().createQuery("from Good g where g.category.id = :catId");
        q.setInteger("catId", id);
        return q.list();
    }

    @Override
    public List<Category> getCategoryList() {
        Query q = sf.getCurrentSession().createQuery("from Category");
        return q.list();
    }

    @Override
    public Good find(Integer id) {
        return (Good) sf.getCurrentSession().get(Good.class, id);
    }
    
}
