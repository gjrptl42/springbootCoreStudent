package net.javaSpring.springboot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.javaSpring.springboot.bean.Student;

@RestController
@RequestMapping("students")
public class StudentController {
	
	@GetMapping
	public ResponseEntity<Student> getStudent() {
		
		Student student = new Student(1,"Jigar","Patel");
		
		return ResponseEntity.ok(student);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> Students = new ArrayList<Student>();
		Students.add(new Student(1,"Jigar","Patel"));
		Students.add(new Student(2,"Jalpa","Rathod"));
		Students.add(new Student(3,"Appu","Patel"));
		
		return new ResponseEntity<>(Students,HttpStatus.OK);
		
	}

	@GetMapping("{id}/{firstName}/{lastName}")
	public Student getStudentByPathVariable(@PathVariable int id, @PathVariable String firstName, @PathVariable String lastName) {
		return new Student(id, firstName, lastName);
	}
	
	@GetMapping("query")
	public Student getStudentByRequestParam(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
		return new Student(id, firstName, lastName);
	}
	
	@PostMapping("create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	
	@PutMapping("{id}/update")
	public Student updateStudent(@RequestBody Student student,@PathVariable int id) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	
	@DeleteMapping("{id}/delete")
	public String deleteStudent(@PathVariable int id) {
		System.out.println(id);
		return "Student deleted successfully.";
	}
}
