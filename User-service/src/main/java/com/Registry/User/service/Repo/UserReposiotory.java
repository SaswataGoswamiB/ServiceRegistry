package com.Registry.User.service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Registry.User.service.entities.User;

@Repository
public interface UserReposiotory extends JpaRepository<User,Integer>{


}
