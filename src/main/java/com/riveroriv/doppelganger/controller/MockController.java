package com.riveroriv.doppelganger.controller;

import com.riveroriv.doppelganger.dto.Mock;
import com.riveroriv.doppelganger.service.MockService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MockController {

    private final Logger logger = LoggerFactory.getLogger(MockController.class);
    private final MockService mockService;

    @Autowired
    public MockController(MockService mockService) {
        this.mockService = mockService;
    }

    @RequestMapping(value = "/**/{any:.*}")
    ResponseEntity<String> request(@RequestBody String request, HttpServletRequest sr) {
        String uri = sr.getRequestURI();
        String method = sr.getMethod();
        logger.info(String.format("%n%s request for %s with body%n%s%n", method, uri, request));
        Mock mock = mockService.getResponse(method, uri);
        return ResponseEntity
                .status(mock.getStatus())
                .header("Content-Type", mock.getType())
                .body(mock.getResponse());
    }

}
