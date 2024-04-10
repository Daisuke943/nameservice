package com.example.nameservice;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NameMapper {
  @Select("select * from names")
  List<Name> findAll();

  @Select("select * from names where name like concat(#{prefix}, '%')")
  List<Name> findByNameStartingWith(String prefix);
}
