package Ehospital.employee.repository;

import Ehospital.employee.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDomain,Long> {

    UserDomain findByUsername(String username);
}
