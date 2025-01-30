package com.Starkindustries.SpringDataJpaMark1.Controller;

import com.Starkindustries.SpringDataJpaMark1.Mappings.OneToMany.Employees;
import com.Starkindustries.SpringDataJpaMark1.Mappings.OneToMany.Projects;
import com.Starkindustries.SpringDataJpaMark1.Mappings.Repository.ProjectsRepository;
import com.Starkindustries.SpringDataJpaMark1.Mappings.Request.ProjectRequest;
import com.Starkindustries.SpringDataJpaMark1.Model.User;
import com.Starkindustries.SpringDataJpaMark1.Mappings.Repository.DepartmentRepository;
import com.Starkindustries.SpringDataJpaMark1.Mappings.Repository.EmployeeRepository;
import com.Starkindustries.SpringDataJpaMark1.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    public UserService userService;

    @Autowired
    public EmployeeRepository employeeRepository;

    @Autowired
    public DepartmentRepository departmentRepository;

    @Autowired
    public ProjectsRepository projectsRepository;

    @GetMapping("/hello")
    public String greetings(){
        return "Greetings!!\nI am Optimus Prime";
    }

    @PostMapping("/insert")
    public ResponseEntity<User> addUsers(@Valid @RequestBody User user){
        User user1 = null;
        try{
            user1=userService.insertUser(user);
            return ResponseEntity.of(Optional.of(user1));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("userId") int userId){
        User user1 = userService.updateUser(user,userId);
        if(user1!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(user1);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @GetMapping("/users")
    public ResponseEntity<List<User>> getStudents(){
        if(userService.getUsers().isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.of(Optional.of(userService.getUsers()));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") int userId){
        try{
            userService.deleteUSer(userId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") int userId){
        if(userService.getUser(userId)==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.getUser(userId));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByName(@PathVariable("username") String username){
        User user=userService.getUserByUsername(username);
        if(user!=null)
            return ResponseEntity.status(HttpStatus.OK).body(user);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/findByUsernameAndName/{username}/{name}")
    public ResponseEntity<User> findByUsernameAndName(@PathVariable("username") String username,@PathVariable("name") String name){
        if(userService.getUserByUsernameAndName(username,name)==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.getUserByUsernameAndName(username,name));
    }

    @GetMapping("/findUserContaining/{pattern}")
    public ResponseEntity<List<User>> findUsersContaining(@PathVariable("pattern") String pattern){
        if(userService.getNamesContaining(pattern).isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.FOUND).body(userService.getNamesContaining(pattern));
    }

    @GetMapping("/UsersUsingPagination/{pageNo}/{pageSize}")
    public ResponseEntity<List<User>> getUsersUsingPagination(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize){
        if(userService.getUserUsingPaging(pageNo,pageSize).isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserUsingPaging(pageNo,pageSize));
    }

//    @PostMapping("/insert-employee")
//    public ResponseEntity<Employee> insertEmployee(@RequestBody EmployeeRequest employeeRequest){
//        Department department = new Department(employeeRequest.getDepartment());
//        departmentRepository.save(department);
//
//        Employee employee = new Employee();
//        employee.setName(employeeRequest.getName());
//        employee.setDepartment(department);
//        employeeRepository.save(employee);
//        return ResponseEntity.status(HttpStatus.OK).body(employee);
//    }
//
//    @GetMapping("/find/byDepartment/{department}")
//    public ResponseEntity<List<Employee>> getEmployeeWithDepartment(@PathVariable("department") String department){
//        if(employeeRepository.findByDepartmentName(department).isEmpty())
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        return ResponseEntity.status(HttpStatus.OK).body(employeeRepository.findByDepartmentName(department));
//    }

    @PostMapping("/insert-project")
    public ResponseEntity<String> insertProject(@RequestBody ProjectRequest projectRequest){
        Employees employee = new Employees();
        employee.setEmpName(projectRequest.getEmpName());
        employeeRepository.save(employee);
        if(!projectRequest.getProjectsList().isEmpty()){
            projectRequest.getProjectsList().stream().forEach(project->{
                Projects projects = new Projects();
                projects.setName(project);
                projects.setEmployee(employee);
                projectsRepository.save(projects);
            });
            return ResponseEntity.status(HttpStatus.CREATED).body("Record inserted Successfully!!");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert Record!!");
    }
}
