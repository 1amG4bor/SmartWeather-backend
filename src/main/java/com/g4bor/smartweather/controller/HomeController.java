package com.g4bor.smartweather.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
@Api(value = "Basic endpoints", description = "Basic endpoints for the API.")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    @ApiOperation(value = "Redirect to swaggerUI page.")
    public void swaggerUI(HttpServletResponse response) {
        response.setHeader("Location", "/swagger-ui.html");
        response.setStatus(302);
    }
}

