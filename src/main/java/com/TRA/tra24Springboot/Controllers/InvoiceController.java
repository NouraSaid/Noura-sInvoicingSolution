package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Invoice;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Service.InvoiceService;
import com.TRA.tra24Springboot.Service.ProductService;
import com.TRA.tra24Springboot.Service.SlackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    SlackService slackService;
    @PostMapping("/create")
    public Invoice addInvoice(Invoice invoice) {
        slackService.sendMessage("noura","new Invoice has been added");
        return invoiceService.createInvoice(invoice);
    }



}
