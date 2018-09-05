/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.salle.custommoodle.businesslogic;

import edu.salle.custommoodle.dataacess.StudentDAO;
import edu.salle.custommoodle.dataacess.imple.StudentDAOListImple;
import edu.salle.custommoodle.model.Student;
import java.util.List;

/**
 *
 * @author Gerardo Vallejo
 */
public class StudentBLO {
    
    private StudentDAO studentDAO;
    
    public StudentBLO(){
        studentDAO = new StudentDAOListImple();
    }
    
    public Student save(Student student){
        return studentDAO.save(student);
    }
    
    public List<Student> findAll(){
        return studentDAO.findAll();
    }
    
    public Student find(String id){
        return studentDAO.find(id);
    }
    
    public List<Student> findByLastName(String lastName){
        return studentDAO.findByLastName(lastName);
    }
    
    public void delete(Student student){
        studentDAO.delete(student);
    }
    
    public void update(Student student){
        studentDAO.delete(student);
    }
    
    public void load(){
        studentDAO.load();
    }
    
    public void commitChanges(){
        studentDAO.commitChanges();
    }
            
}
