package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.dto.InvoiceDTO;
import com.sadman.medicalinventory.model.Invoice;
import com.sadman.medicalinventory.model.User;
import com.sadman.medicalinventory.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.sql.Timestamp;

/**
 * @author Sadman
 */
@Service
public class POSService {

    @Autowired
    InvoiceRepository invoiceRepository;

    public void makePayment(InvoiceDTO invoiceDTO) {
        String invoiceId = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        long userId = user.getId();


        Invoice invoice = new Invoice(invoiceId, userId, invoiceDTO.getGrandTotal()+invoiceDTO.getTotalDiscount(), 0, invoiceDTO.getTotalDiscount(), invoiceDTO.getGrandTotal(), );


    }
}
