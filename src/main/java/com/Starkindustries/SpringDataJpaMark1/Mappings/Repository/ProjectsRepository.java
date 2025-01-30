package com.Starkindustries.SpringDataJpaMark1.Mappings.Repository;

import com.Starkindustries.SpringDataJpaMark1.Mappings.OneToMany.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Projects,Integer> {
}
