package com.example.nameservice;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserMapper userMapper;

  public UserService(UserMapper userMapper){
    this.userMapper = userMapper;
  }

  public List<User> findAll(){
    return userMapper.findAll();
  }
  public User findUser(int id){
    Optional<User> user = this.userMapper.findById(id);
    return user.orElseThrow(() -> new UserNotFoundException("user not found"));
  }
}
