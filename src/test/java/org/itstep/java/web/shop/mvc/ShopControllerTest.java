/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.itstep.java.web.shop.mvc;

import java.util.ArrayList;
import java.util.List;
import org.itstep.java.web.shop.model.Basket;
import org.itstep.java.web.shop.model.Category;
import org.itstep.java.web.shop.model.Good;
import org.itstep.java.web.shop.service.GoodService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.ui.ModelMap;

/**
 *
 * @author andrii
 */
public class ShopControllerTest {
    
    GoodService srv;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        model = new ModelMap();
        srv = new GoodService() {

            @Override
            public List<Good> getList(Integer id) {
                List<Good> goods = new ArrayList<>();
                goods.add(new Good());
                return goods;
            }

            @Override
            public List<Category> getCategoryList() {
                List<Category> cats = new ArrayList<>();
                cats.add(new Category());
                return cats;
            }

            @Override
            public Good find(Integer id) {
                if (id == 0) {
                    return null;
                }
                Good good = new Good();
                good.setId(id);
                good.setName("good");
                return good;
            }

            @Override
            public Category findCategory(Integer id) {
                Category cat = new Category();
                cat.setName("cat");
                cat.setId(id);
                return cat;
            }
        };
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of categories method, of class ShopController.
     */
    @org.junit.Test
    public void testCategories() {
        System.out.println("categories");
        ShopController instance = new ShopController(srv);
        String expResult = "categories";
        String result = instance.categories(model);
        assertEquals(expResult, result);
        
        assertEquals("Categories", model.get("title"));
        assertTrue(model.get("cats") instanceof List);
    }

    /**
     * Test of goods method, of class ShopController.
     */
    @org.junit.Test
    public void testGoods() {
        System.out.println("goods");
        Integer id = 1;
        ShopController instance = new ShopController(srv);
        String expResult = "goodlist";
        String result = instance.goods(id, model);
        assertEquals(expResult, result);
        
        Category cat = srv.findCategory(id);
        assertEquals(cat.getName(), model.get("title"));
        assertTrue(model.get("goods") instanceof List);
    }

    /**
     * Test of addToBasket method, of class ShopController.
     */
    @org.junit.Test
    public void testAddToBasket() {
        System.out.println("addToBasket");
        Integer catId = 1;
        Integer id = 1;
        ShopController instance = new ShopController(srv);
        String expResult = "redirect:/shop/category/1";
        String result = instance.addToBasket(catId, id, model);
        assertEquals(expResult, result);
        
        assertTrue(model.get("basket") instanceof Basket);
        Basket b = (Basket) model.get("basket");
        assertFalse(b.values().isEmpty());
        assertEquals(1, b.values().size());
        assertTrue(b.containsKey(id));
        
        instance.addToBasket(catId, 0, model);
        assertEquals(1, b.values().size());
        assertFalse(b.containsKey(0));
        assertTrue(b.containsKey(id));
    }
    ModelMap model;
    
}
