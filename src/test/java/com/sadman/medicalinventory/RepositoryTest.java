package com.sadman.medicalinventory;

import com.sadman.medicalinventory.controller.ReturnController;
import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.model.Stock;
import com.sadman.medicalinventory.repository.PurchaseRepository;
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

    @Test
    public void getOutOfStockTest() throws Exception {
        List<Stock> outOfStockList = stockRepository.getOutOfStock();
        for (Stock stock : outOfStockList) {
            System.out.println(stock.getPurchase().getBrand().getName());
        }
    }


}
