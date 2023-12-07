package com.BookWave.springbootlibrary.controller;


import com.BookWave.springbootlibrary.requestmodels.AddBookRequest;
import com.BookWave.springbootlibrary.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utils.ExtractJWT;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/secure/add/book")
    public void postBook(@RequestHeader(value="Authorization") String token,
                         @RequestBody AddBookRequest addBookRequest) throws Exception {
        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only");
        }
        adminService.postBook(addBookRequest);
    }

    @PutMapping("/secure/increase/book/quantity")
    public void increaseBookQuantity(@RequestHeader(value="Authorization") String token,
                                     @RequestParam Long bookId) throws Exception {
        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only");
        }
        adminService.increaseBookQuantity(bookId);
    }
    @PutMapping("/secure/decrease/book/quantity")
    public void decreaseBookQuantity(@RequestHeader(value="Authorization") String token,
                                     @RequestParam Long bookId) throws Exception {
        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only");
        }
        adminService.decreaseBookQuantity(bookId);
    }

}








