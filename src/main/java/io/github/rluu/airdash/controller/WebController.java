package io.github.rluu.airdash.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    
    private static final Logger logger = LogManager.getLogger(WebController.class);

    @RequestMapping("/")
    public String rootPath() {
        logger.trace("Entered rootPath method.");
        return "index.html";
    }

    @RequestMapping("/login")
    public String login() {
        logger.trace("Entered login method.");
        return "login.html";
    }
}
