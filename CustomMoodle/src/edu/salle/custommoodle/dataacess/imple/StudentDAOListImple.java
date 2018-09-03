/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.salle.custommoodle.dataacess.imple;

import edu.salle.custommoodle.dataacess.StudentDAO;
import edu.salle.custommoodle.model.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gerardo Vallejo
 */
public class StudentDAOListImple implements StudentDAO {
    
    private static List<Student> StudentList = new ArrayList<>();

    @Override
    public Student save(Student student) {
        String id= Integer.toString(StudentList.size()+1);
        student.setId(id);
        StudentList.add(student);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return StudentList;
    }

    @Override
    public Student find(String id) {
        
        for (Student student: StudentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        
        return null;
    }   
}
