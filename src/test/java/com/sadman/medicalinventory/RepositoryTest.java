package com.sadman.medicalinventory;

import com.sadman.medicalinventory.controller.ReturnController;
import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.model.Sale;
import com.sadman.medicalinventory.model.SaleInvoice;
import com.sadman.medicalinventory.repository.PurchaseRepository;
import com.sadman.medicalinventory.repository.SaleInvoiceRepository;
import com.sadman.medicalinventory.repository.SaleRepository;
import com.sadman.medicalinventory.repository.StockRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Sadman
 */
@SpringBootTest
public class RepositoryTest {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleInvoiceRepository saleInvoiceRepository;

    @Autowired
    private StockRepository stockRepository;

    @Test
    public void findAllByIdNotContainsTest() {
        List<Long> purchaseIdList = Arrays.asList(1L,2L,3L,4L,5L,6L,7L,8L,9L,10L,11L,12L);
        List<Purchase> purchaseList = purchaseRepository.findAllByIdNotContains(purchaseIdList);
    }

    @Test
    public void createSaleTest() {
        Sale newSale = new Sale();
        newSale.setSaleInvoice(saleInvoiceRepository.getOne("1627275507972"));
        newSale.setStock(stockRepository.getOne(3L));
        newSale.setDiscount(15.0);
        newSale.setQuantity(1.0);
        newSale.setUnitPrice(300.0);
        newSale.setTotal(285.0);
        Sale sale = saleRepository.save(newSale);
    }
}
