package org.edwinepr.springbootmagic;

import org.edwinepr.springbootmagic.main.SpringBootMagicApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = SpringBootMagicApplication.class)
@AutoConfigureMockMvc
class SpringBootMagicApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test that /home page can be successfully called.")
    void testPageRequestAndContent() throws Exception {
        mockMvc.perform(get("/home.html"))
                .andExpect(status().isOk());
    }

}
