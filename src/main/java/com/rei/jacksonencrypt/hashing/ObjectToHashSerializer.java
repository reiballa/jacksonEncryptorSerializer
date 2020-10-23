package com.rei.jacksonencrypt.hashing;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.hash.Hashing;
import com.rei.jacksonencrypt.views.Views;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ObjectToHashSerializer extends JsonSerializer<Object> {

    @Override
    public void serialize(
            Object value,
            JsonGenerator jsonGenerator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        if(provider.getActiveView() != null && provider.getActiveView().equals(Views.Hashed.class)){
            jsonGenerator.writeObject(Hashing.sha256().hashString(value.toString(), StandardCharsets.UTF_8).toString());
        }
        else{
            jsonGenerator.writeObject(value.toString());
        }

    }

}
