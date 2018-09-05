/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.salle.custommoodle.dataacess.imple;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.salle.custommoodle.dataacess.StudentDAO;
import edu.salle.custommoodle.model.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Override
    public List<Student> findByLastName(String lastName) {
        List<Student> resStudentList = new ArrayList<>();
        lastName = lastName.toLowerCase().trim();
        for (Student student : StudentList) {
            if (student.getLastName().toLowerCase().contains(lastName) 
                    || student.getName().toLowerCase().contains(lastName)) {
                resStudentList.add(student);
            }
        }
        return resStudentList;
    }

    @Override
    public void delete(Student student) {
        StudentList.remove(student);
    }

    @Override
    public void update(Student student) {
        int pos = StudentList.indexOf(student);
        StudentList.set(pos,student);
    }

    @Override
    public void load() {
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader("students.json"));
            StudentList = gson.fromJson(br, new TypeToken<List<Student>>() {
        }.getType());
        br.close();
            if (StudentList==null) {
                StudentList = new ArrayList(); 
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void commitChanges() {
        try{
            Gson gson = new Gson();
            FileWriter writer = new FileWriter("students.json");
            writer.write(gson.toJson(StudentList));
            writer.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
