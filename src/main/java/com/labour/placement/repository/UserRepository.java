package com.labour.placement.repository;

import com.labour.placement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // TODO: Define custom query methods (e.g., findByUsername) once Entity attributes are set.
}
