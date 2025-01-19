package com.Starkindustries.SpringDataJpaMark1.Repository;

import com.Starkindustries.SpringDataJpaMark1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByName(String name);
}
