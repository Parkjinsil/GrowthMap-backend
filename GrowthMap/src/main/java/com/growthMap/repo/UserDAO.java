package com.growthMap.repo;

import com.growthMap.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, String>, QuerydslPredicateExecutor<User>{

}
