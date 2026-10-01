package com.example.payment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PaymentApplicationTests {
    private static final String MOCK_STAGING_KEY = "test_abc123456789";

    @Autowired MockMvc mvc;

    @Test
    void createsPaymentAndReadsLegacyReport() throws Exception {
        mvc.perform(post("/api/payments").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"merchantId\":\"merchant-demo\",\"amount\":12.50,\"currency\":\"USD\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.status").value("AUTHORIZED"));
        mvc.perform(get("/api/legacy/reports").param("merchant", "merchant-demo"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].MERCHANT_ID").value("merchant-demo"));
    }
}
