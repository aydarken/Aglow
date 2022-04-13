package kz.iitu.aglow.repository;

import kz.iitu.aglow.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
