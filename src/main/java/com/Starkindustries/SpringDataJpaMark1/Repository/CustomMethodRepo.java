package com.Starkindustries.SpringDataJpaMark1.Repository;

import com.Starkindustries.SpringDataJpaMark1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomMethodRepo extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.name = :name")
    User findbyName(@Param("name") String name);

}
