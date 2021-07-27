package com.sadman.medicalinventory;

import com.sadman.medicalinventory.dto.PurchaseInvoiceDTO;
import com.sadman.medicalinventory.dto.PurchaseMedicineDTO;
import com.sadman.medicalinventory.iservice.POPService;
import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.model.PurchaseInvoice;
import com.sadman.medicalinventory.model.Sale;
import com.sadman.medicalinventory.repository.PurchaseRepository;
import com.sadman.medicalinventory.repository.SaleInvoiceRepository;
import com.sadman.medicalinventory.repository.SaleRepository;
import com.sadman.medicalinventory.repository.StockRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Sadman
 */
@SpringBootTest
public class ServiceTest {

    @Autowired
    private POPService popService;

    @Test
    public void makePurchasePaymentTest() throws ParseException {

        PurchaseMedicineDTO purchaseMedicineDTO = new PurchaseMedicineDTO();
        purchaseMedicineDTO.setBrandId(1L);
        purchaseMedicineDTO.setBoxId(2L);
        purchaseMedicineDTO.setLocationId(1L);
        purchaseMedicineDTO.setUnitPrice(200.0);
        purchaseMedicineDTO.setQuantity(2.0);
        purchaseMedicineDTO.setDiscount(8.0);
        purchaseMedicineDTO.setTotal(392.0);
        String string = "January 2, 2022";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date date = format.parse(string);
        purchaseMedicineDTO.setExpiryDate(date);

        List<PurchaseMedicineDTO> purchaseMedicineDTOList = new ArrayList<>();
        purchaseMedicineDTOList.add(purchaseMedicineDTO);

        PurchaseInvoiceDTO purchaseInvoiceDTO = new PurchaseInvoiceDTO();
        purchaseInvoiceDTO.setPurchaseMedicineDTOList(purchaseMedicineDTOList);
        purchaseInvoiceDTO.setSupplierId(1L);
        purchaseInvoiceDTO.setAverageDiscount(20.0);
        purchaseInvoiceDTO.setChangeAmount(28.0);
        purchaseInvoiceDTO.setGrandTotal(372.0);
        purchaseInvoiceDTO.setPaidAmount(400.0);
        purchaseInvoiceDTO.setTotalDiscount(28.0);
        PurchaseInvoice purchaseInvoice = popService.makePayment(purchaseInvoiceDTO);
        System.out.println(purchaseInvoice);
    }
}
