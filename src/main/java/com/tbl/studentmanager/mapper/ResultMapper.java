package com.tbl.studentmanager.mapper;

import com.tbl.studentmanager.model.TblResult;
import org.apache.ibatis.annotations.*;
import java.util.Date;
import java.util.List;

@Mapper
public interface ResultMapper {
    // 插入方法
    @Insert("INSERT INTO tblresult(UserId, CourseId, SubjectId, marks, PostingDate, UpdationDate) " +
            "VALUES(#{userId}, #{courseId}, #{subjectId}, #{marks}, #{postingDate}, #{updationDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertResult(TblResult result);

    // 更新方法
    @Update("UPDATE tblresult SET UserId = #{userId}, CourseId = #{courseId}, SubjectId = #{subjectId}, " +
            "marks = #{marks}, PostingDate = #{postingDate}, UpdationDate = #{updationDate} " +
            "WHERE id = #{id}")
    int updateResult(TblResult result);

    // 删除方法
    @Delete("DELETE FROM tblresult WHERE id = #{id}")
    int deleteResultById(int id);

    // 查询方法
    @Select("SELECT * FROM tblresult WHERE id = #{id}")
    @Results(id = "base", value = {
            @Result(property = "userId", column = "UserId"),
            @Result(property = "courseId", column = "CourseId"),
            @Result(property = "subjectId", column = "SubjectId"),
            @Result(property = "PostingDate", column = "PostingDate"),
            @Result(property = "updationDate", column = "UpdationDate"),
    })
    TblResult selectResultById(int id);

    // 如果你需要查询所有结果
    @Select({
            "<script>",
            "SELECT * FROM tblresult",
            "<if test='userId != null'>",
            "WHERE userId = #{userId}",
            "</if>",
            "</script>"
    })
    @ResultMap("base")
    List<TblResult> selectAllResults(String userId);
}
