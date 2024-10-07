package com.tbl.studentmanager.mapper;

import com.tbl.studentmanager.model.Fee;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface FeeMapper{
    // 插入操作
    @Insert("INSERT INTO tblfees(fee, Fees_Status, Scolarship_Status, UserId) VALUES(#{fee}, #{feesStatus}, #{scolarshipStatus}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertFee(Fee fees);

    // 根据id查询操作
    @Select("SELECT * FROM tblfees WHERE id = #{id}")
    Fee selectFeesById(int id);

    // 查询所有费用记录
    @Select({
            "<script>",
            "SELECT * FROM tblfees where 1 =1",
            "<if test='userId != null'>",
            " and userId = #{userId}",
            "</if>",
            "<if test='feesStatus != null'>",
            " and feesStatus = #{Fees_Status}",
            "</if>",
            "<if test='scolarshipStatus != null'>",
            " and Scolarship_Status = #{scolarshipStatus}",
            "</if>",
            "</script>"
    })
    @Results(id = "base", value = {
            @Result(property = "userId", column = "UserId"),
            @Result(property = "feesStatus", column = "Fees_Status"),
            @Result(property = "scolarshipStatus", column = "Scolarship_Status"),
    })
    List<Fee> selectAllFees(Fee fee);

    // 根据id更新费用信息
    @Update("UPDATE tblfees SET fee = #{fee}, Fees_Status = #{feesStatus}, Scolarship_Status = #{scolarshipStatus}, UserId = #{userId} WHERE id = #{id}")
    int updateFee(Fee fees);

    // 根据id删除费用记录
    @Delete("DELETE FROM tblfees WHERE id = #{id}")
    int deleteFeeById(int id);

    @Update("update tblfees set Fees_Status = #{feesStatus} where WHERE id = #{id}")
    void updateFeeStatus(Fee fee);
}
