package com.g4bor.smartweather.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.g4bor.smartweather.model.weather.WeatherData;
import com.g4bor.smartweather.service.WeatherService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ApiControllerTest {
    private static final String baseURL = "/api";
    private ObjectMapper mapper = new ObjectMapper();

    @Mock
    private WeatherService weatherServiceMock;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        final ApiController apiController = new ApiController(weatherServiceMock);
        mockMvc = MockMvcBuilders.standaloneSetup(apiController).build();
    }

    @Test
    public void forecastForToday_shouldReturnWithStatus200() throws Exception {
        String SUMMARY = "Mocked-weather";
        WeatherData weather = new WeatherData();
        weather.setSummary(SUMMARY);
        String jsonResponse = mapper.writeValueAsString(weather);

        Mockito.when(weatherServiceMock.getWeatherForToday()).thenReturn(weather);

        MvcResult result = mockMvc.perform(get(baseURL + "/today"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(jsonResponse, result.getResponse().getContentAsString());
    }
}