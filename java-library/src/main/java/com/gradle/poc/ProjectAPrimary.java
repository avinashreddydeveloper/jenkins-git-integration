package com.gradle.poc;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProjectAPrimary {

    public void projectAPublicAPI(ObjectMapper objectMapper) {
        privateProjectAMethod(objectMapper);
    }

    private void privateProjectAMethod(ObjectMapper objectMapper) {
        try {
            Map testMap = new HashMap();
            testMap.put("key1", "value1");
            testMap.put("key2", "value2");
            System.out.println("Inside privateProjectAMethod" + objectMapper.writeValueAsString(testMap));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
