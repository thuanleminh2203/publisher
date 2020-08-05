package com.venesa.publisher.controller;

import com.venesa.publisher.dto.UserDTO;
import com.venesa.publisher.sender.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sender")
public class SenderController {

    @Autowired
    private RabbitMQSender sender;

    @PostMapping
    public String sendMessage(@RequestBody UserDTO userDTO){
        sender.sender(userDTO, "exchange" , "key_common" );
        return "Send mess oke";
    }
}
