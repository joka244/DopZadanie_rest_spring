package com.example.rest_example.service;

import com.example.rest_example.model.PaymentResult;
import com.example.rest_example.model.UserOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService = new PaymentService();


    @PostMapping(value = "/payment")
    public ResponseEntity<PaymentResult> create(@RequestBody UserOrder userOrder) {
        PaymentResult paymentResult = paymentService.buyClothes(userOrder);
        return new ResponseEntity<>(paymentResult, HttpStatus.CREATED);
    }
}
