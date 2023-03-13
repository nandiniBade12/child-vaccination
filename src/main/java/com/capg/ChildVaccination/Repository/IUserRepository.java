package com.capg.ChildVaccination.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.capg.ChildVaccination.Entity.User;



@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	User findUserById(Integer userId);

	User findByUserName(String email);

}
