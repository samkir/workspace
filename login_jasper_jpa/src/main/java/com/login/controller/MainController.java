package com.login.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import com.login.service.UserService;
import com.login.utils.WebUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class MainController {
 
    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }
 
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
         
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
         
        return "adminPage";
    }
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
 
        return "loginPage";
    }
 
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }
 
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
 
        // After user login successfully.
        String userName = principal.getName();
 
        System.out.println("User Name: " + userName);
 
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
 
        return "jasper";
    }
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/jasper", method = RequestMethod.GET)
    public void export(ModelAndView model,@RequestParam int c_invoice_id,@RequestParam int c_bpartner_id,
    HttpServletResponse response) throws IOException, JRException, SQLException {
   	 JasperPrint jasperPrint = null;
     response.setContentType("application/x-download");
     response.setHeader("Content-Disposition", String.format("attachment; filename=\"users.pdf\""));

     OutputStream out = response.getOutputStream();
     jasperPrint = userService.exportPdfFile(c_invoice_id,c_bpartner_id);
     JasperExportManager.exportReportToPdfStream(jasperPrint, out);
    }
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
            String userInfo = WebUtils.toString(loginedUser);
 
            model.addAttribute("userInfo", userInfo);
 
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
 
        }
 
        return "403Page";
    }
 
}