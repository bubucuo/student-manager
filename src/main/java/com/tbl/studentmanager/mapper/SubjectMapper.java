package com.tbl.studentmanager.mapper;
import com.tbl.studentmanager.model.Subject;
import org.apache.ibatis.annotations.*;
import java.util.Date;
import java.util.List;

@Mapper
public interface SubjectMapper {

    @Insert("INSERT INTO tblsubjects (SubjectName, SubjectCode, Createdate, UpdateDate) VALUES (#{subjectName}, #{subjectCode}, #{createDate}, #{updateDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSubject(Subject subject);

    @Delete("DELETE FROM tblsubjects WHERE id = #{id}")
    int deleteSubjectById(Integer id);

    @Update("UPDATE tblsubjects SET SubjectName = #{subjectName}, SubjectCode = #{subjectCode}, Createdate = #{createDate}, UpdateDate = #{updateDate} WHERE id = #{id}")
    int updateSubject(Subject subject);

    @Select("SELECT * FROM tblsubjects WHERE id = #{id}")
    Subject selectSubjectById(Integer id);

    @Select("SELECT * FROM tblsubjects")
    List<Subject> selectAllSubjects();
}
