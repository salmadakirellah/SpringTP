package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query; // Importez Query depuis le package correct
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

import java.util.Collection; // Importez Collection depuis le package correct

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findById(int id);

    @Query("select year(s.dateNaissance) as annee, count(*) as nbr from Student s group by year(s.dateNaissance) order by year(s.dateNaissance)") // Corrigez la requête JPQL
    Collection<?> findNbrStudentByYear();
}
