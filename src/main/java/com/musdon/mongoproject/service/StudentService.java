package com.musdon.mongoproject.service;

import com.musdon.mongoproject.entity.Student;
import com.musdon.mongoproject.repository.DepartmentRepository;
import com.musdon.mongoproject.repository.StudentRepository;
import com.musdon.mongoproject.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Component
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    public Student createStudent(Student student){
        if (student.getDepartment() != null){
            departmentRepository.save(student.getDepartment());
        }
        if (student.getSubjects() != null && student.getSubjects().size()>0){
            subjectRepository.saveAll(student.getSubjects());
        }
        return studentRepository.save(student);
    }

    public Student getStudentById(String id){
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    public String deleteStudent(String id){
        studentRepository.deleteById(id);
        return "Student has been deleted";
    }

    public List<Student> studentsByName(String name){
        return studentRepository.getByName(name);
    }

    public List<Student> studentsByNameAndEmail(String name, String email){
        return studentRepository.findByNameAndEmail(name, email);
    }

    public List<Student> studentsByNameOrEmail(String name, String email){
        return studentRepository.findByNameOrEmail(name, email);
    }

    public List<Student> getAllWithPagination(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1, pageSize, Sort.by("name"));
        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> allWithSorting(){
        Sort sort = Sort.by(Sort.Direction.ASC, "");
        return studentRepository.findAll(sort);
    }
    public List<Student> byDepartmentName(String deptName){
        return studentRepository.findByDepartmentDepartmentName(deptName);
    }

    public List<Student> bySubjectName(String subName){
        return studentRepository.findBySubjectsSubjectName(subName);
    }

    public List<Student> byDepartmentId(String deptId){
        return studentRepository.findByDepartmentId(deptId);
    }

    public List<Student> getByName(String name){
        return studentRepository.getByName(name);
    }


}
