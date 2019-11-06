package pe.isil.isilcatalog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping(value = {"/", "/login"})
    private String login(){
        return "login";
    }

    @GetMapping("/index")
    private String index(){
        return "index";
    }
}
