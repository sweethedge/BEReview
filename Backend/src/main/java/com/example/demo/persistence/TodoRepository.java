package com.example.demo.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
	List<TodoEntity> findByUserId(String userId);
	
	// ?1 은 메서드의 매개변수의 순서 위치
	// *는 JPA에서는 못 씀
	@Query("select t from TodoEntity t where t.userId = ?1")
	List<TodoEntity> findByUserIdQuery(String userId);
	
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	// JPA가 알아서 쿼리를 짜는데 다만 메서드 이름과 매개변수를 국룰대로 해야 된다.

}
