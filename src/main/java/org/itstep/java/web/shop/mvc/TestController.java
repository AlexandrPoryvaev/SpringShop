
package org.itstep.java.web.shop.mvc;

import java.util.List;
import org.itstep.java.web.shop.oraclemodel.OracleUser;
import org.itstep.java.web.shop.service.OracleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
@Transactional("txManagerOracle")
public class TestController {
    
    @Autowired
    OracleService osrv;
    
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String page(Model model) {
        
        List<OracleUser> users = osrv.findAll();
        model.addAttribute("users", users);
        
        return "test/userlist";
    }
}
