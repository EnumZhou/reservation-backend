package com.company.reservation.controller;

import com.company.reservation.annotation.AccessLog;
import com.company.reservation.entity.Customer;
import com.company.reservation.service.CustomerService;
import com.company.reservation.service.EmailService;
import com.company.reservation.util.MessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController extends BaseController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/send")
    @AccessLog(operation = "Send Simple text email message")
    public MessageResult sendSimpleMessage() {
        try {
            emailService.sendSimpleMessage("yinan.zhou2014@gmail.com","Test","Hello, My Friend.");
            return success("Successfully send Email");
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return error("Failed to send Email");
    }
    @GetMapping("/send1")
    @AccessLog(operation = "Send Simple HTML email message.")
    public MessageResult sendHTMLMessage() {

        try{
            Customer customer= customerService.findOne(1L);
            emailService.sendHTMLMessage("yinan.zhou2014@gmail.com","HTML Template",customer);
            return success("Send Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return error("Failed to send");
    }

}
