package com.example.nameservice;

import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
  @Select("select * from users")
  List<User> findAll();

  @Select("select * from users where name like concat(#{prefix}, '%')")
  List<User> findByNameStartingWith(String prefix);

  @Select("select * from users where id = #{id}")
  Optional<User> findById(int id);
}
