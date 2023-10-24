package com.exemple.demo.controller;
import com.example.demo.repository.StudentRepository;
import com.example.demo.entity.Student; // Importez la classe Student si ce n'est pas déjà fait
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
	
@Autowired
private StudentRepository studentRepository;

@PostMapping("/save")
public void save(@RequestBody Student student){
studentRepository.save(student);
}
@DeleteMapping("/delete/{id}" )
public void delete(@PathVariable (required = true) String id){
Student s = studentRepository.findById(Integer. parseInt(id));
studentRepository.delete( s);
}
@GetMapping("/all")
public List<Student> findAll(){
return studentRepository.findAll();
}
@GetMapping(value = "/count" )
public long countStudent() {
return studentRepository.count();
}
@GetMapping(value = "/byYear" )
public Collection<?> findByYear() {
return studentRepository.findNbrStudentByYear();
}
}