package com.sadman.medicalinventory;

import static org.assertj.core.api.Assertions.assertThat;

import com.sadman.medicalinventory.controller.UserController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * @author Sadman
 */
@SpringBootTest
public class SmokeTest {

    @Autowired
    private UserController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
