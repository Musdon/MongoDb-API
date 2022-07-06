package com.musdon.mongoproject.repository;

import com.musdon.mongoproject.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByName(String name);
    List<Student> findByNameAndEmail(String name, String email);
    List<Student> findByNameOrEmail(String name, String email);
    List<Student> findByDepartmentDepartmentName(String deptName);
    List<Student> findBySubjectsSubjectName(String subName);
    List<Student> findByDepartmentId(String deptId);

    @Query("{\name\": \"?0\"}")
    List<Student> getByName(String name);
}
