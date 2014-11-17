package org.itstep.java.web.shop.service;

import java.util.List;
import org.itstep.java.web.shop.model.Category;
import org.itstep.java.web.shop.model.Good;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GoodService {
    public List<Good> getList(Integer id);
    public List<Category> getCategoryList();
    public Good find(Integer id);
    public Category findCategory(Integer id);
}
