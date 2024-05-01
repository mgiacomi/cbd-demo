package com.gltech.integration;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.gltech.demo.cow.Cow;

public class CrudTests {
    public static void main(String[] args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("MM/dd/uuuu");

        Cow cow = new Cow();
        cow.setTag("123");
        cow.setBirthDate(LocalDate.parse("10/01/2020", dtFormat));
        cow.setStatus("alive");

        URI uri = new URI("http://localhost:8080/cows");
        HttpEntity<Cow> request = new HttpEntity<>(cow, new HttpHeaders());
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        System.out.println(result.getStatusCode() +" : "+ result.getBody());
    }
}
