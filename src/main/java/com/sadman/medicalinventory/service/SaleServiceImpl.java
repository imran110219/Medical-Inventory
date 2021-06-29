package com.sadman.medicalinventory.service;

import com.sadman.medicalinventory.exception.RecordNotFoundException;
import com.sadman.medicalinventory.iservice.SaleService;
import com.sadman.medicalinventory.model.Sale;
import com.sadman.medicalinventory.repository.SaleRepository;
import com.sadman.medicalinventory.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SaleRepository repository;

    public List<Sale> getAllSales() {
        return repository.findAll();
    }

    public List<Sale> getAllSalesBySaleInvoiceId(String saleInvoiceId) {
        return repository.findAllBySaleInvoiceId(saleInvoiceId);
    }

    public Sale getSaleById(Long id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Sale createSale(Sale sale){
        return repository.save(sale);
    }

    public Sale updateSale(Sale newSale, Long id) {
        return repository.findById(id)
                .map(sale -> {
                    sale.setStock(newSale.getStock());
                    sale.setSaleInvoice(newSale.getSaleInvoice());
                    sale.setUnitPrice(newSale.getUnitPrice());
                    sale.setQuantity(newSale.getQuantity());
                    sale.setTotal(newSale.getTotal());
                    return repository.save(sale);
                })
                .orElseGet(() -> {
                    newSale.setId(id);
                    return repository.save(newSale);
                });
    }

    public void deleteSaleById(Long id){
        repository.deleteById(id);
    }

    public double getTotalSaleAmount(){
        return repository.getTotalSaleAmount();
    }

    public Map<String, Double> getHighestSale(){
        Map<String,Double> map = DataUtil.convertMapToMap(repository.getHighestSale());
        Map<String,Double>  sortedMapReverseOrder =  map.entrySet().
                stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedMapReverseOrder);
        return sortedMapReverseOrder;
    }

    public Map<String, Double> getLowestSale(){
        Map<String,Double> map = DataUtil.convertMapToMap(repository.getHighestSale());
        Map<String,Double>  sortedMap =  map.entrySet().
                stream().
                sorted(Map.Entry.comparingByValue()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedMap);
        return sortedMap;
    }
}
