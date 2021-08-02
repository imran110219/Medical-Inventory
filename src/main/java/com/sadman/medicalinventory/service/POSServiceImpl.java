package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.dto.InvoiceDTO;
import com.sadman.medicalinventory.dto.MedicineDTO;
import com.sadman.medicalinventory.iservice.POSService;
import com.sadman.medicalinventory.model.SaleInvoice;
import com.sadman.medicalinventory.model.Sale;
import com.sadman.medicalinventory.model.Stock;
import com.sadman.medicalinventory.model.User;
import com.sadman.medicalinventory.repository.SaleInvoiceRepository;
import com.sadman.medicalinventory.repository.SaleRepository;
import com.sadman.medicalinventory.repository.StockRepository;
import com.sadman.medicalinventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sadman
 */
@Service
public class POSServiceImpl implements POSService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SaleInvoiceRepository saleInvoiceRepository;

    @Autowired
    StockRepository stockRepository;

    @Autowired
    SaleRepository saleRepository;

    public SaleInvoice makePayment(InvoiceDTO invoiceDTO) {
        String invoiceId = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userRepository.findByUserName(userName);

        SaleInvoice invoice = new SaleInvoice();
        invoice.setId(invoiceId);
        invoice.setUser(user);
        invoice.setTotal(invoiceDTO.getGrandTotal()+invoiceDTO.getTotalDiscount());
        invoice.setVat(0);
        invoice.setDiscount(invoiceDTO.getTotalDiscount());
        invoice.setPayable(invoiceDTO.getGrandTotal());
        invoice.setPaid(invoiceDTO.getPaidAmount());
        invoice.setReturned(invoiceDTO.getChangeAmount());

        saleInvoiceRepository.save(invoice);

        List<Sale> saleList = new ArrayList<>();
        for (int i = 0; i < invoiceDTO.getMedicineDTOList().size(); i++) {
            MedicineDTO medicineDTO = invoiceDTO.getMedicineDTOList().get(i);
            Stock stock = stockRepository.getOne(medicineDTO.getStockId());
            stock.setQuantity(stock.getQuantity()-medicineDTO.getQuantity());
            stockRepository.save(stock);
            Sale sale = new Sale();
            sale.setSaleInvoice(saleInvoiceRepository.getOne(invoiceId));
            sale.setStock(stock);
            sale.setDiscount(medicineDTO.getDiscount());
            sale.setQuantity(medicineDTO.getQuantity());
            sale.setUnitPrice(medicineDTO.getUnitPrice());
            sale.setTotal(medicineDTO.getTotal());
            saleList.add(sale);
        }

        saleRepository.saveAll(saleList);

        return invoice;
    }
}
