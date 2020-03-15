package remember.service;

import java.util.List;

import remember.entity.UserEntity;

public interface UserService {
	
	//Create
	void saveUser(UserEntity user) throws Exception;
	
	//Read
	UserEntity selectUser(int userId) throws Exception;
	List<UserEntity> selectUserList() throws Exception;
	
	//Update
	
	
	//Delete
	void deleteUser(int userId);
	
	

}
