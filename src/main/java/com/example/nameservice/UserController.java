package com.example.nameservice;

import jakarta.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  private final UserService userService;

  public UserController(UserService userService){
    this.userService = userService;
  }

  @GetMapping("/users")
  public List<User> getNames(){
    return userService.findAll();
  }
  @GetMapping("/users/{id}")
  public User getUser(@PathVariable("id") int id){
    return userService.findUser(id);
  }
}
