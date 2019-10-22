package io.github.rluu.airdash.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    
    private static final Logger logger = LogManager.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String login() {
        logger.info("Entered login method.");
        return "login.html";
    }
}
