package com.Starkindustries.SpringDataJpaMark1.Repository;

import com.Starkindustries.SpringDataJpaMark1.Model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface PagingAndSortingRepository extends org.springframework.data.repository.PagingAndSortingRepository<User,Integer> {

}
