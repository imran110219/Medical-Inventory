package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.dto.InvoiceDTO;
import com.sadman.medicalinventory.dto.MedicineDTO;
import com.sadman.medicalinventory.dto.PurchaseInvoiceDTO;
import com.sadman.medicalinventory.dto.PurchaseMedicineDTO;
import com.sadman.medicalinventory.iservice.POPService;
import com.sadman.medicalinventory.model.*;
import com.sadman.medicalinventory.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sadman
 */
@Service
public class POPServiceImpl implements POPService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private PurchaseInvoiceRepository purchaseInvoiceRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BoxRepository boxRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private LocationRepository locationRepository;

    public PurchaseInvoice makePayment(PurchaseInvoiceDTO purchaseInvoiceDTO) {
        String serial = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
        String invoiceId = "PI" + serial;

        PurchaseInvoice invoice = new PurchaseInvoice();
        invoice.setId(invoiceId);
        invoice.setSupplier(supplierRepository.getOne(purchaseInvoiceDTO.getSupplierId()));
        invoice.setTotal(purchaseInvoiceDTO.getGrandTotal()+purchaseInvoiceDTO.getTotalDiscount());
        invoice.setVat(0);
        invoice.setDiscount(purchaseInvoiceDTO.getTotalDiscount());
        invoice.setPayable(purchaseInvoiceDTO.getGrandTotal());
        invoice.setPaid(purchaseInvoiceDTO.getPaidAmount());
        invoice.setReturned(purchaseInvoiceDTO.getChangeAmount());

        purchaseInvoiceRepository.save(invoice);

        for (int i = 0; i < purchaseInvoiceDTO.getPurchaseMedicineDTOList().size(); i++) {
            PurchaseMedicineDTO purchaseMedicineDTO = purchaseInvoiceDTO.getPurchaseMedicineDTOList().get(i);
            Purchase purchase = new Purchase();
            purchase.setBrand(brandRepository.getOne(purchaseMedicineDTO.getBrandId()));
            purchase.setPurchaseInvoice(purchaseInvoiceRepository.getOne(invoiceId));
            if(purchaseMedicineDTO.getBatchNo() == null || purchaseMedicineDTO.getBatchNo().equals("")){
                String batchId = "B" + serial + (i+1) ;
                purchase.setBatchNo(batchId);
            }
            else {
                purchase.setBatchNo(purchaseMedicineDTO.getBatchNo());
            }
            purchase.setBox(boxRepository.getOne(purchaseMedicineDTO.getBoxId()));
            purchase.setQuantity(purchaseMedicineDTO.getQuantity());
            purchase.setUnitPrice(purchaseMedicineDTO.getUnitPrice());
            purchase.setDiscount(purchaseMedicineDTO.getDiscount());
            purchase.setTotal(purchaseMedicineDTO.getTotal());
            purchase.setExpiryDate(purchaseMedicineDTO.getExpiryDate());
            purchase = purchaseRepository.save(purchase );
            purchaseRepository.flush();
            Stock stock = new Stock();
            stock.setLocation(locationRepository.getOne(purchaseMedicineDTO.getLocationId()));
            double netQuantity = purchase.getQuantity() * purchase.getBox().getQuantity();
            stock.setQuantity(netQuantity);
            stock.setPurchase(purchaseRepository.getOne(purchase.getId()));
            stockRepository.save(stock);
        }
        return invoice;
    }
}
