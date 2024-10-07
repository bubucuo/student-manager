package com.tbl.studentmanager.mapper;
import com.tbl.studentmanager.model.User;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    /**
     * 插入一个新的用户记录
     * @param user 用户对象
     * @return 受影响的行数
     */
    @Insert("INSERT INTO tblusers(UserId, Name, RollId, Email, Gender, DOB, Address, Password) " +
            "VALUES(#{userId}, #{name}, #{rollId}, #{email}, #{gender}, #{dob}, #{address}, #{password})")
//    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int insert(User user);

    /**
     * 根据用户ID删除用户记录
     * @param userId 用户ID
     * @return 受影响的行数
     */
    @Delete("DELETE FROM tblusers WHERE UserId = #{userId}")
    int deleteByUserId(String userId);

    /**
     * 根据用户ID查找用户
     * @param userId 用户ID
     * @return 用户对象
     */
    @Select("SELECT * FROM tblusers WHERE UserId = #{userId}")
    @Results(id = "base", value = {
            @Result(property = "userId", column = "UserId"),
            @Result(property = "name", column = "Name"),
            @Result(property = "rollId", column = "RollId"),
            @Result(property = "email", column = "Email"),
            @Result(property = "gender", column = "Gender"),
            @Result(property = "dob", column = "DOB"),
            @Result(property = "address", column = "Address")
    })
    User findByUserId(String userId);

    @Update({
            "UPDATE tblusers",
            "SET Name = #{name},",
            "Email = #{email},",
            "Gender = #{gender},",
            "DOB = #{dob},",
            "Address = #{address},",
            "Password = #{password}",
            "WHERE UserId = #{userId}"
    })
    int updateByUserId(User user);

    @Select("SELECT * FROM tblusers ")
    @ResultMap("base")
    List<User> findAll(User user);
}
