package com.invillia.acme.user.repository;

import com.invillia.acme.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long>{
}
