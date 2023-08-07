package com.yunuscrud.crudapi.repository;

import com.yunuscrud.crudapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {



}
