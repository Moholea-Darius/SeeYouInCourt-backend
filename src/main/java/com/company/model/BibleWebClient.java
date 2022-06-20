package com.company.model;

import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public class BibleWebClient {
    public String HolyBibleBaseUrl = "https://api.scripture.api.bible/v1/";
    public String AuthorizationKey = "c48c593737cac03df28c34266741aadc";
    public String AllBiblesUri = "bibles";
    private WebClient _webClient;

    public BibleWebClient() {
        _webClient = WebClient.builder()
                .defaultHeader("api-key", AuthorizationKey)
                .baseUrl(HolyBibleBaseUrl).build();
    }

//    public List<com.company.model.Bible> GetAllBibles() {
//        return _webClient.get()
//                .uri(AllBiblesUri)
//                .retrieve()
//                .bodyToFlux(com.company.model.Bible.class);
//    }
}
