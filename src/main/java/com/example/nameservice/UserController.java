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

  @ExceptionHandler(value = UserNotFoundException.class)
  public ResponseEntity<Map<String, String>> handleUserNotFoundExcetion(
      UserNotFoundException e, HttpServletRequest request) {
    Map<String, String> body = Map.of(
        "timestamp", ZonedDateTime.now().toString(),
        "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
        "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
        "message", e.getMessage(),
        "path", request.getRequestURI()
    );
    return new ResponseEntity<Map<String, String>>(body, HttpStatus.NOT_FOUND);
  }
}
