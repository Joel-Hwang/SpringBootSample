package com.mapper;

import org.apache.ibatis.annotations.*;
import java.util.List;
import com.model.AppUser;
@Mapper
public interface UserMapper {

    @Select("SELECT ID, USERNAME, EMAIL FROM APP_USER")
    public List<AppUser> findAll();

    @Select("SELECT ID, USERNAME, EMAIL FROM APP_USER WHERE ID=#{id}")
    public AppUser findById(@Param("id") long id);
    
    @Insert("INSERT INTO APP_USER(username, email) VALUES(#{username}, #{email})")
    public int insert(AppUser user); 
    
}
