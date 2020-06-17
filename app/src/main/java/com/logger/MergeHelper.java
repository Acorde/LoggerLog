package com.logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


public class MergeHelper {

    private static ObjectMapper objectMapper = new ObjectMapper();


    /**
     * return a merge JsonNode, merge newJson into oldJson; override or insert
     * fields from newJson into oldJson
     *
     * @param oldJson
     * @param newJson
     * @return
     */
    public static JsonNode mergeJsonObject(String firstJson, String secondJson) {
        ObjectNode merged = objectMapper.createObjectNode();
        JsonNode firstJsonNode = null;
        JsonNode secondJsonNode = null;

        try {
        firstJsonNode = objectMapper.readTree(firstJson);
        secondJsonNode = objectMapper.readTree(secondJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        merged.setAll((ObjectNode) firstJsonNode);
        merged.setAll((ObjectNode) secondJsonNode);
        return merged;
    }
}
