
package repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository<User> extends JpaRepository<User, String> {
    User findByUsername(String username);
}




