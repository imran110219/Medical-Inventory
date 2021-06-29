package com.sadman.medicalinventory.iservice;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.model.Sale;
import com.sadman.medicalinventory.util.DataUtil;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Sadman
 */
public interface SaleService {
    List<Sale> getAllSales();

    List<Sale> getAllSalesBySaleInvoiceId(String saleInvoiceId);

    Sale getSaleById(Long id) throws RecordNotFoundException;

    Sale createSale(Sale sale);

    Sale updateSale(Sale newSale, Long id);

    void deleteSaleById(Long id);

    double getTotalSaleAmount();

    Map<String, Double> getHighestSale();

    Map<String, Double> getLowestSale();
}
