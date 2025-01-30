package com.Starkindustries.SpringDataJpaMark1.Mappings.Repository;

import com.Starkindustries.SpringDataJpaMark1.Mappings.OneToOneMapping.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
