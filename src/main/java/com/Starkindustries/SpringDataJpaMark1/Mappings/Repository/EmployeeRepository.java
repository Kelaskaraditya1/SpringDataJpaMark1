package com.Starkindustries.SpringDataJpaMark1.Mappings.Repository;

import com.Starkindustries.SpringDataJpaMark1.Mappings.OneToMany.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees,Integer> {

}
