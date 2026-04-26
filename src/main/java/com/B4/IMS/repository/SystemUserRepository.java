package com.B4.IMS.repository;

import com.B4.IMS.model.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Long> {
    // Custom method to fetch a user by their registration number (username)
    Optional<SystemUser> findByUsername(String username);
}