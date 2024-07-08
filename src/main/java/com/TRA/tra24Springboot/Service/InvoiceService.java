package com.TRA.tra24Springboot.Service;
import com.TRA.tra24Springboot.Models.Invoice;
import com.TRA.tra24Springboot.Models.Product;
import com.TRA.tra24Springboot.Repository.InvoiceRepository;
import com.TRA.tra24Springboot.Repository.ProductRepository;
import com.TRA.tra24Springboot.Utils.DateHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service

public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    ProductService productService;

    public Invoice createInvoice(Invoice invoice) {
        Product product = new Product();

        Product products = productService.add(product);
        invoice.setProducts(Arrays.asList(products));
        invoice.setPaidAmount(78.5);
        invoice.setTotalAmount(45.6);
        invoice.setIsActive(Boolean.TRUE);
        invoice.setCreatedDate(new Date());
        invoice.setDueDate(new Date());
        return invoiceRepository.save(invoice);
    }

    // method to get invoices due in next few days
    public List<Invoice> getInvoiceDueInNextDays(Integer days) {
        Date today = new Date();
        Date dueDate = DateHelperUtils.addDays(today, days);
        return invoiceRepository.getInvoicesByDueDateBetween(today, dueDate);

    }
}
