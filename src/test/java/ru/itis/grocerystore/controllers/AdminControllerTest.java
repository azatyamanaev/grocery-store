package ru.itis.grocerystore.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureWebMvc
@Transactional
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithUserDetails(value = "admin", userDetailsServiceBeanName = "myUserDetailsService")
    public void getPage_admin() throws Exception {
        mockMvc.perform(get("/admin")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "STUDENT")
    public void getPage_student() throws Exception {
        mockMvc.perform(get("/admin")).andExpect(status().isForbidden());
    }
}
