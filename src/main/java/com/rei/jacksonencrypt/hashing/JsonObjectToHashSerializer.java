package com.rei.jacksonencrypt.hashing;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.hash.Hashing;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.rei.jacksonencrypt.views.Views;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JsonObjectToHashSerializer extends JsonSerializer<Object> {

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd' 'HH:mm:ss").create();

    @Override
    public void serialize(
            Object obj,
            JsonGenerator jsonGenerator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        if(provider.getActiveView() != null && provider.getActiveView().equals(Views.Hashed.class)){
            jsonGenerator.writeRaw(hashAsJsonObj(obj));
        }
        else{
            JsonElement jsonElement = gson.toJsonTree(obj);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            jsonGenerator.writeRaw(jsonObject.toString());
        }

    }

    private String hashAsJsonObj(Object obj){
        JsonElement jsonElement = gson.toJsonTree(obj);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        traverseAndHash(jsonObject);
        return jsonObject.toString();
    }

    private void traverseAndHash(JsonObject jsonObject){
        for (String key : jsonObject.keySet()){
            if(jsonObject.get(key).isJsonObject()) traverseAndHash(jsonObject.get(key).getAsJsonObject());
            else{
                jsonObject.addProperty(key, Hashing.sha256().hashString(jsonObject.get(key).getAsString(), StandardCharsets.UTF_8).toString());
            }
        }
    }

}
