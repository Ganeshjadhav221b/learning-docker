package com.example.randomnumgenerator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {

  @GetMapping
  public int getNumber()
  {
    return 1;
  }
}
