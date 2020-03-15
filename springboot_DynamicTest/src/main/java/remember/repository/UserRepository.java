package remember.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import remember.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
	List<UserEntity> findAllByOrderByUserIdDesc();

}
