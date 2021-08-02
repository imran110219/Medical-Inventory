package com.sadman.medicalinventory;

import com.sadman.medicalinventory.controller.ReturnController;
import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.model.Sale;
import com.sadman.medicalinventory.model.Stock;
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
    private StockRepository stockRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleInvoiceRepository saleInvoiceRepository;

    @Test
    public void saveSaleRepositoryTest(){
        Sale sale = new Sale();
        sale.setSaleInvoice(saleInvoiceRepository.getOne("1627234685141"));
        sale.setStock(stockRepository.getOne(7L));
        sale.setDiscount(5);
        sale.setQuantity(2);
        sale.setUnitPrice(40);
        sale.setTotal(75);
        Sale newSale = saleRepository.save(sale);
        System.out.println(newSale.getId());
    }

    @Test
    public void getOutOfStockTest() throws Exception {
        List<Stock> outOfStockList = stockRepository.getOutOfStock();
        for (Stock stock : outOfStockList) {
            System.out.println(stock.getPurchase().getBrand().getName());
        }
    }


}
