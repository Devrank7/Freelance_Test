package com.example.client_2.controller;

import com.example.client_2.repo.Repo_Cars;
import com.example.client_2.repo.Repo_Employee;
import com.example.client_2.model.*;
import com.example.client_2.repo.Repo_Home;
import com.example.client_2.repo.Repo_Project;
import com.example.client_2.repo.Repo_Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class ARestController {

    private Repo_Employee repoEmployee;

    private Repo_Cars repoCars;

    private Repo_Work repoWork;

    private Repo_Home repoHome;

    private Repo_Project repoProject;

    @Autowired
    public ARestController(Repo_Employee repoEmployee, Repo_Cars repoCars,Repo_Work repoWork,Repo_Home repoHome,Repo_Project repoProject) {
        this.repoEmployee = repoEmployee;
        this.repoCars = repoCars;
        this.repoWork = repoWork;
        this.repoHome = repoHome;
        this.repoProject = repoProject;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Employee>> findAll() {
        return new ResponseEntity<>(repoEmployee.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") int id) {
        if (!idIsValid(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(repoEmployee.findById(id).orElseThrow(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return new ResponseEntity<>(repoEmployee.save(employee), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") int id, @RequestBody Employee employee) {
        if (!idIsValid(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        employee.setId(id);
        return new ResponseEntity<>(repoEmployee.save(employee), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable("id") int id) {
        if (!idIsValid(id)) return HttpStatus.NOT_FOUND;
        repoEmployee.deleteById(id);
        return HttpStatus.OK;
    }

    @PostMapping("/join/{id}")
    public ResponseEntity<Car> carsAdhereID(@PathVariable("id")int id,@RequestBody Car car) {
        if (!idIsValid(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        car.setEmployee(repoEmployee.findById(id).orElseThrow());
        return new ResponseEntity<>(repoCars.save(car),HttpStatus.CREATED);
    }

    @PostMapping("/work/{id}")
    public ResponseEntity<Work> workAdhereID(@PathVariable("id")int id,@RequestBody Work work) {
        if (!idIsValid(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        work.getEmployees().add(repoEmployee.findById(id).orElseThrow());
        return new ResponseEntity<>(repoWork.save(work),HttpStatus.CREATED);
    }

    @PostMapping("/work/{id}/by/{idd}")
    public ResponseEntity<Work> workAdhereID(@PathVariable("id")int id,@PathVariable("idd")int id1) {
        if (!idIsValid(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Work work = repoWork.findById(id1).orElseThrow(() -> new RuntimeException("wtf exception"));
        work.getEmployees().add(repoEmployee.findById(id).orElseThrow());
        return new ResponseEntity<>(repoWork.save(work),HttpStatus.OK);
    }
    @DeleteMapping("/detach/{id}/bu/{idd}")
    public ResponseEntity<Work> detachWork(@PathVariable("id")int id,@PathVariable("idd")int id1) {
        if (!idIsValid(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Work work = repoWork.findById(id1).orElseThrow(() -> new RuntimeException("wtf exception"));
        int index = work.getEmployees().indexOf(repoEmployee.findById(id).orElseThrow());
        System.out.println(index);
        work.getEmployees().set(index,null);
        return new ResponseEntity<>(repoWork.save(work),HttpStatus.OK);

    }
    @GetMapping("/home/all")
    public ResponseEntity<List<House>> getHome() {
        return new ResponseEntity<>(repoHome.findAll(),HttpStatus.OK);
    }
    @PostMapping("/home/create/{id}")
    public ResponseEntity<House> createHome(@PathVariable("id")int id,@RequestBody House house) {
        if (!idIsValid(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        house.setEmployee(repoEmployee.findById(id).orElseThrow());
        return new ResponseEntity<>(repoHome.save(house),HttpStatus.CREATED);
    }
    @GetMapping("/pro/all")
    public ResponseEntity<List<Project>> listResponseEntity() {
        return new ResponseEntity<>(repoProject.findAll(),HttpStatus.OK);
    }
    @GetMapping("/pro/{id}")
    public ResponseEntity<Project> getProject(@PathVariable("id")int id) {
        return new ResponseEntity<>(repoProject.findById(id).orElseThrow(),HttpStatus.OK);
    }
    @PostMapping("/pro/create")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return new ResponseEntity<>(repoProject.save(project),HttpStatus.CREATED);
    }
    @PutMapping("/pro/update/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id")int id,@RequestBody Project project) {
        return new ResponseEntity<>(repoProject.save(project.setId(id)),HttpStatus.OK);
    }
    @DeleteMapping("/pro/delete/{id}")
    public HttpStatus deleteProject(@PathVariable("id")int id) {
        repoProject.deleteById(id);
        return HttpStatus.OK;
    }
    @PostMapping("/pro/join/{id}/by/{idd}")
    public ResponseEntity<Employee> joinToProject(@PathVariable("id")int id,@PathVariable("idd")int id1) {
        Employee employee = repoEmployee.findById(id).orElseThrow();
        employee.setProject(repoProject.findById(id1).orElseThrow());
        return new ResponseEntity<>(repoEmployee.save(employee),HttpStatus.OK);
    }
    @DeleteMapping("/pro/detach/{id}")
    public ResponseEntity<Employee> detachFromProject(@PathVariable("id")int id) {
        Employee employee = repoEmployee.findById(id).orElseThrow();
        employee.setProject(null);
        return new ResponseEntity<>(repoEmployee.save(employee),HttpStatus.OK);
    }





    public boolean idIsValid(int id) {
        return repoEmployee.existsById(id);
    }
}
