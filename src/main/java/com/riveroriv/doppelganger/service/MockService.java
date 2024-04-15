package com.riveroriv.doppelganger.service;


import com.riveroriv.doppelganger.config.MockConfig;
import com.riveroriv.doppelganger.dto.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MockService {
    private final Map<String, Mock> mocks;
    private final Mock defaultMock;

    @Autowired
    public MockService(
            MockConfig mockConfig,
            @Value("${mock.default.status}") Integer defaultStatus,
            @Value("${mock.default.response}") String defaultResponse,
            @Value("${mock.default.type}") String defaultType
    ) {
        mocks = mockConfig.getMocks().values().stream().collect(
                Collectors.toMap(
                        mock -> mock.getMethod()+mock.getPath(),
                        mock -> mock
                ));
        defaultMock = new Mock(null, null, defaultResponse, defaultStatus, defaultType);
    }

    public Mock getResponse(String method, String path) {
        return mocks.getOrDefault(method+path, defaultMock);
    }

}
