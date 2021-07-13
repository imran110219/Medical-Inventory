package com.sadman.medicalinventory;

import com.sadman.medicalinventory.controller.GenericController;
import com.sadman.medicalinventory.model.Generic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Sadman
 */
@SpringBootTest
public class GenericControllerTest {

    @Autowired
    private GenericController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void getGenericByIdTest() throws Exception {
        ResponseEntity<Generic> generic = controller.getGenericById(1L);
        System.out.println(generic.getBody());
        assertThat(controller).isNotNull();
    }
}
