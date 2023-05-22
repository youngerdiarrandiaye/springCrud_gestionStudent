package com.groupeisi.gestionetudiant.controller;

import com.groupeisi.gestionetudiant.entities.Student;
import com.groupeisi.gestionetudiant.repossitory.StudentRepository;
import com.groupeisi.gestionetudiant.service.StudentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    public StudentController(StudentService studentService) {
       this.studentService = studentService;
    }
    //listes des students
      @RequestMapping("/list")
      public String listStudents(Model model,
              @RequestParam(name = "page",defaultValue = "0")int page,
              @RequestParam(name = "size",defaultValue = "5")int size){
              Page<Student> pageStudent= (Page<Student>) studentService.getAllStudent();
              model.addAttribute("pageStudent",pageStudent);
              model.addAttribute("currentePage",page);
              model.addAttribute("size",size);
              model.addAttribute("pages",new int[pageStudent.getTotalPages()]);
            return "student";
        }
        
     @GetMapping("/students/new")
     public String createStudentForm(Model model) {
        // create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
     }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/list";
    }
    //delete student
    @GetMapping("/list/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/list";
    }
}
