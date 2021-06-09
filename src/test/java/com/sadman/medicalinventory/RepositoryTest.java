package com.sadman.medicalinventory;

import com.sadman.medicalinventory.controller.ReturnController;
import com.sadman.medicalinventory.model.Purchase;
import com.sadman.medicalinventory.repository.PurchaseRepository;
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

    @Test
    public void findAllByIdNotContainsTest() throws Exception {
        List<Long> purchaseIdList = Arrays.asList(1L,2L,3L,4L,5L,6L,7L,8L,9L,10L,11L,12L);
        List<Purchase> purchaseList = purchaseRepository.findAllByIdNotContains(purchaseIdList);
    }


}
