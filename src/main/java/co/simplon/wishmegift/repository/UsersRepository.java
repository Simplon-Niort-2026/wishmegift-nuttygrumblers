package co.simplon.wishmegift.repository;

import co.simplon.wishmegift.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}
