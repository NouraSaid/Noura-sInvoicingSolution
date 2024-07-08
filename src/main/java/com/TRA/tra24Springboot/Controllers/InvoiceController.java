package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Models.Invoice;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Service.InvoiceService;
import com.TRA.tra24Springboot.Service.ProductService;
import com.TRA.tra24Springboot.Service.SlackService;
import com.TRA.tra24Springboot.Utils.DateHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        slackService.sendMessage("practice","new Invoice has been added");
        return invoiceService.createInvoice(invoice);
    }
    @Scheduled(cron = "0 0 9 * * ?")
    @PostMapping("dueDate")
    public void sendDueDateReminder() {
        Integer remainingDays = 3;
        List<Invoice> invoices = invoiceService.getInvoiceDueInNextDays(remainingDays);
        for (Invoice invoice : invoices) {
            StringBuilder message = new StringBuilder();
            message.append("Reminder: Invoice #")
                    .append(invoice.getId())
                    .append(" is due on ")
                    .append(invoice.getDueDate().toString());
            SlackService.sendMessage("practice", message.toString());
        }
    }

    @Scheduled(cron = "0 0 9 * * ?")
    @PostMapping("overdue")
    public void sendOverdueReminder(){
        List<Invoice> overdueInvoices = invoiceService.getOverDueInvoices();
        for (Invoice invoice : overdueInvoices) {
            StringBuilder message = new StringBuilder();
            message.append("Alert: Invoice #")
                    .append(invoice.getId())
                    .append(" is overdue since ")
                    .append(invoice.getDueDate().toString());
            slackService.sendMessage("practice", message.toString());
        }
    }
}



