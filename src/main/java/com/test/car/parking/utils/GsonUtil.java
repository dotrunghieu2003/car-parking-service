package com.test.car.parking.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

public class GsonUtil {

    public static Gson createGson() {
        return new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateDeserializer())
                .create();
    }
}
