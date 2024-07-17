package com.test.jobejavamatawansolution;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class HealthCheckTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnGoodResponse() throws Exception {
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk()); // status only check is okay here
    }
}
