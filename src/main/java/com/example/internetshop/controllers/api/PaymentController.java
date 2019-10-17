package com.example.internetshop.controllers.api;

import com.example.internetshop.entities.Invoice;
import com.example.internetshop.entities.Payment;
import com.example.internetshop.repositories.InvoiceRepository;
import com.example.internetshop.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Collections;

@RestController
public class PaymentController {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @GetMapping
    public @ResponseBody
    String
    makePayment(@RequestParam int invoice_id)throws Exception{
        JSONObject jsonObject = new JSONObject();
        if(!invoiceRepository.existsById(invoice_id)){
            jsonObject.put("status", Boolean.FALSE);
            jsonObject.put("payment_details", "No such invoice");
            return jsonObject.toString();
        }else{
            jsonObject.put("status", Boolean.TRUE);
            Invoice invoice = invoiceRepository.findById(invoice_id).get();
            Payment payment = new Payment();

            payment.setAmount(invoice.getAmount());
            payment.setInvoice(invoice);
            payment.setTime(new Timestamp(System.currentTimeMillis()));
            invoice.setPayment(Collections.singletonList(payment));
            paymentRepository.save(payment);
            invoiceRepository.save(invoice);

            jsonObject.put("payment", payment);
        }


        return jsonObject.toString();
    }
}
