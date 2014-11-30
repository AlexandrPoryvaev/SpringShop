package org.itstep.java.web.shop.service;

import java.util.List;
import org.itstep.java.web.shop.oraclemodel.OracleUser;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OracleService {
    public List<OracleUser> findAll();
}
