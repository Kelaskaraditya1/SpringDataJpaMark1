package com.Starkindustries.SpringDataJpaMark1.Repository;

import com.Starkindustries.SpringDataJpaMark1.Model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByUsername(String username);

    public User findByUsernameAndName(String username,String name);

    public List<User> findByNameContaining(String pattern, Sort sort);

}
