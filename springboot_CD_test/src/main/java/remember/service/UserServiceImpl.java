package remember.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import remember.entity.UserEntity;
import remember.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	//Create
	@Override
	public void saveUser(UserEntity user) throws Exception{
		userRepository.save(user);
	}
	
	//Read
	public UserEntity selectUser(int userId) throws Exception{
		Optional <UserEntity> optional = userRepository.findById(userId);
		
		if(optional.isPresent())
			return optional.get();
		else
			throw new NullPointerException();
	}
	
	
	public List<UserEntity> selectUserList() throws Exception{
		return userRepository.findAllByOrderByUserIdDesc();
	}
	
	//Update
	
	
	//Delete
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}
	

}
