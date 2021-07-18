package com.sadman.medicalinventory.repository;

import com.sadman.medicalinventory.model.Brand;
import com.sadman.medicalinventory.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findAllBySaleInvoiceId(String saleInvoiceId);

    @Query("SELECT sum(total) FROM Sale")
    double getTotalSaleAmount();

//    @Query("SELECT stock.purchase.brand.name, sum(quantity) FROM Sale group by stock order by quantity desc")
    @Query("SELECT stock.purchase.brand.name, quantity FROM Sale order by quantity desc")
    List<Map<String, Long>> getHighestSale();

}
