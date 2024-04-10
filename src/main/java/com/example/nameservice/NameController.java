package com.example.nameservice;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {
  private final NameMapper nameMapper;

  public NameController(NameMapper nameMapper){
    this.nameMapper = nameMapper;
  }

  @GetMapping("/names")
  public List<Name> findByNames(@RequestParam String startsWith){
    return nameMapper.findByNameStartingWith(startsWith);
  }
}
