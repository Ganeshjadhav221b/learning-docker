package com.example.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MessageController {
  @GetMapping
  public String greet()
  {
    return "Hello";
  }

  @Autowired
  RestTemplate restTemplate;

  @Value("${randomNumGeneratorUrl}")
  String randomNumGeneratorUrl;

  @GetMapping("/demo")
  public String greetWithNumber()
  {
    ResponseEntity<Integer> response = restTemplate.getForEntity(randomNumGeneratorUrl,Integer.class);
    return "Hello: "+response.getBody();
  }
}
