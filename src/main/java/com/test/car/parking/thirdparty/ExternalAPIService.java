package com.test.car.parking.thirdparty;

import com.google.gson.Gson;
import com.test.car.parking.utils.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class ExternalAPIService {

    private final RestTemplate restTemplate;

    protected Gson gson;


    @Value( "${app.transport.api.url}" )
    protected String apiUrl ;

    @Autowired
    public ExternalAPIService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();

    }

    @PostConstruct
    public void posConstruct(){
        this.gson= GsonUtil.createGson();
    }
    public String getDataFromExternalAPI() {
        // Make a GET request to the API
        log.info("Call external api {} to get car park availability", this.apiUrl);
        return restTemplate.getForObject(apiUrl, String.class);
    }

    public CarParkResponseData getCarParkAvailabilityData(){
        String jsonString = this.getDataFromExternalAPI();
        return this.gson.fromJson(jsonString,CarParkResponseData.class );
    }
}

