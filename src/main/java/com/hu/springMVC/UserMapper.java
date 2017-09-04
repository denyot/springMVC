package com.hu.springMVC;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select(" INSERT INTO user (username, password) VALUES (#{username}, #{password})")
    @Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
    void save(User user);

    void delete(Long id);

    void update(User user);

    User get(Long id);

    List<User> queryByIn(List list);

    List<User> list();

    List<User> query(QueryObject qo);

    Long queryByCount(QueryObject qo);

    /*
    *如果你的映射器的方法需要多个参数, @Param ,这个注解可以被应用于映射器的方法 参数来给每个参数一个名字
    。否则,多 参数将会以它们的顺序位置来被命名 (不包括任何 RowBounds 参数) 比如。 #{param1}
    , #{param2} 等 , 这 是 默 认 的 。 使 用 @Param(“person”),参数应该被命名为 #{person}。
     */
    User login(@Param("username") String username, @Param("password") String password);

}
