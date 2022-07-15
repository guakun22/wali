package com.guakun22.robot.wali.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HelloControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(new HelloController())
                .build();
    }

    @Test
    void testSayHi() throws Exception {
        // Arrange & Act & Assert
        mockMvc.perform(get("/v1/greeting")
                        .param("name", "Not support chinese yet."))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Hello, Not support chinese yet.\"}"));

    }
}
