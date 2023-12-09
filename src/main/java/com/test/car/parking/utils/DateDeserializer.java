package com.test.car.parking.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
@Slf4j
public class DateDeserializer implements JsonDeserializer<Date> {

    private final SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        String dateString = json.getAsJsonPrimitive().getAsString();
        try {
            return format.parse(dateString);
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new Date();
        }
    }
}
