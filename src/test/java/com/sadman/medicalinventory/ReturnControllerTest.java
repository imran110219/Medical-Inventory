package com.sadman.medicalinventory;

import com.sadman.medicalinventory.controller.ReturnController;
import com.sadman.medicalinventory.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Sadman
 */
@SpringBootTest
public class ReturnControllerTest {

    @Autowired
    private ReturnController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
