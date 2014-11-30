package org.itstep.java.web.shop.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import org.itstep.java.web.shop.oraclemodel.OracleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "oracleService")
@Transactional("txManagerOracle")
public class OracleDAO implements OracleService {
    @Autowired
    @Qualifier(value = "sessionFactoryOracle")
    SessionFactory sf;

    @Override
    public List<OracleUser> findAll() {
        return sf.getCurrentSession().createQuery("from OracleUser").list();
    }
    
    
}
