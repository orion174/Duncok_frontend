package aips.duncok.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Value("${backend-url}")
    private String backendUrl;

    @RequestMapping(value = "/test/{modelValue}", name = "테스트")
    public String test(@PathVariable("modelValue") String modelValue, Model model, HttpServletRequest req) {
        model.addAttribute("modelValue",modelValue);

        HttpSession session = req.getSession(true);
        session.setAttribute("sessionKey", "sessionValue");

        return "www/html/test/index.html";
    }
}