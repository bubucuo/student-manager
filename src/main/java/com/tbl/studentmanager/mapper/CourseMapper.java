package com.tbl.studentmanager.mapper;
import com.tbl.studentmanager.model.Course;
import org.apache.ibatis.annotations.*;
import java.util.Date;
import java.util.List;

@Mapper
public interface CourseMapper {

    @Insert("INSERT INTO tblcourse (CourseName, CourseNameNumber, Section, CreateDate, UpdateDate) VALUES (#{courseName}, #{courseNameNumber}, #{section}, #{createDate}, #{updateDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertCourse(Course course);

    @Delete("DELETE FROM tblcourse WHERE id = #{id}")
    int deleteCourseById(Integer id);

    @Update("UPDATE tblcourse SET CourseName = #{courseName}, CourseNameNumber = #{courseNameNumber}, Section = #{section}, CreateDate = #{createDate}, UpdateDate = #{updateDate} WHERE id = #{id}")
    int updateCourse(Course course);

    @Select("SELECT * FROM tblcourse WHERE id = #{id}")
    Course selectCourseById(Integer id);

    @Select("SELECT * FROM tblcourse")
    List<Course> selectAllCourses();
}
