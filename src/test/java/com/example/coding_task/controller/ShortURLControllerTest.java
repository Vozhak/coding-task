package com.example.coding_task.controller;

import com.example.coding_task.service.ShortURLService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static net.bytebuddy.utility.RandomString.make;
import static org.assertj.core.util.Lists.list;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ShortURLControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShortURLService shortUrlService;

    @Test
    public void providesRestEndpointAndReturnsTitlesBasedOnServiceLayer() throws Exception {
        String shorten = make(5);
        given(shortUrlService.findShortsWithClicksLessOrEqualsThan(5)).willReturn(list(shorten));
        this.mockMvc.perform(get("/shorts?clicks=5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(shorten)));
    }
}
