package com.Starkindustries.SpringDataJpaMark1.Repository;

import com.Starkindustries.SpringDataJpaMark1.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

}
