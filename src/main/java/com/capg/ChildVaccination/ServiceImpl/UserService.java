package com.capg.ChildVaccination.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ChildVaccination.Entity.User;
import com.capg.ChildVaccination.Exceptions.ParentAlreadyExistsException;
import com.capg.ChildVaccination.Exceptions.WrongPasswordException;
import com.capg.ChildVaccination.Repository.IUserRepository;
import com.capg.ChildVaccination.Repository.ParentRepository;
//import org.springframework.transaction.annotation.Transactional;



@Service
public class UserService {

	@Autowired
	IUserRepository userRepository;

	@Autowired
	ParentRepository parentRepository;

	public User userSignUp(User user) throws ParentAlreadyExistsException {
		User user1 = userRepository.findByUserName(user.getUserName());
		if (user1 != null) {
			throw new ParentAlreadyExistsException("UserName already exists.");
		} else {
			userRepository.save(user);
			return user;
		}
	}

	public User userSignIn(User user) throws WrongPasswordException {
		User user1 = userRepository.findByUserName(user.getUserName());
		if (user.getPassword().equals(user1.getPassword())) {
			return user1;
		} else {
			throw new WrongPasswordException("Wrong Password");
		}
	}

}
