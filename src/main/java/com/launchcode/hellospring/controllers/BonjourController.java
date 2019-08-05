package com.launchcode.hellospring.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class BonjourController {

    @RequestMapping(value = "bonjour", method = RequestMethod.GET)
    @ResponseBody
    public String createMessage() {
        String html = "<form method='post'>" +
                "<input type='text' name='name' value='Your Name Here' />" +
                " in " +
                "<select name='langselect'>"+
                "<option value='English'>English</option>" +
                "<option value='French'>French</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='Japanese'>Japanese</option>" +
                "<option value='Swedish'>Swedish</option>" +
                "</select>" +
                "<input type='submit' value='Submit' />" +
                "</form>";
        return html;
    }
    @RequestMapping(value = "bonjour", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest nameRequest, HttpServletRequest languageRequest) {
        String name = nameRequest.getParameter("name");
        String language = nameRequest.getParameter("langselect");

        HashMap<String, String> hmap = new HashMap<String, String>();
        hmap.put("English", "Hello");
        hmap.put("Swedish", "Hej");
        hmap.put("French", "Bonjour");
        hmap.put("Japanese", "Konnichiwa");
        hmap.put("Spanish", "Hola");

        String hello = hmap.get(language);
        return hello + " " + name;
    }
}