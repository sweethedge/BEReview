package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.TodoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;

	public String testService() {
		// TodoEntity 생성
		TodoEntity entity = TodoEntity.builder().title("My first todo item").build();
		// TodoEntity 저장
		repository.save(entity);
		// TodoEntity 검색
		TodoEntity savedEntity = repository.findById(entity.getId()).get();
		return savedEntity.getTitle();
	}

	public List<TodoEntity> create(final TodoEntity entity) {
		// Validations
		validate(entity);
		// 엔티티를 DB에 저장
		repository.save(entity);
		// 로그
		log.info("Entity id : {} is saved", entity.getId());
		// 저장된 엔티티를 포함하는 새 리스트 리턴
		return repository.findByUserId(entity.getUserId());
	}
	
	// 리팩토링한 메서드
	private void validate(final TodoEntity entity) {
		if (entity == null) {
			log.warn("Entity cannot be null.");
			throw new RuntimeException("Entity cannot be null.");
		}
		if (entity.getUserId() == null) {
			log.warn("Unknown user.");
			throw new RuntimeException("Unknown user.");
		}
	}
	
	public List<TodoEntity> retrieve(final String userId) {
		return repository.findByUserId(userId);
	}
	
	public List<TodoEntity> update(final TodoEntity entity) {
		// 저장할 Entity가 유효한지 확인
		validate(entity);
		
		// 넘겨받은 엔티티 id를 이용해 TodoEntity를 가져옴.
		final Optional<TodoEntity> original = repository.findById(entity.getId());
		
		if (original.isPresent()) {
			// 반환된 TodoEntity가 존재하면 값을 새 entity의 값으로 덮어 씌움
			final TodoEntity todo = original.get();
			// todoEntity의 lombok의 @Data에 getter/setter가 포함되어 있음. 
			todo.setTitle(entity.getTitle());
			todo.setDone(entity.isDone());
			
			// DB에 새 값을 저장
			repository.save(entity);
		}
		// Retrieve 메서드를 이용해 유저의 모든 Todo 리스트를 리턴
		return retrieve(entity.getUserId());
	}
	
	public List<TodoEntity> delete(final TodoEntity entity) {
		validate(entity);
		
		try {
			repository.delete(entity);
		} catch (Exception e) {
			// exception 발생시 id와 exception을 로깅
			log.error("error deleting entity " + entity.getId(), e);
			
			// 컨트롤러로 exception을 던지는데 다 보여주지 말고 id만 보여줌. 캡슐화를 위해서임.
			throw new RuntimeException("error deleting entity " + entity.getId());
		}
		
		// 새 Todo 리스트를 가져와 리턴
		return retrieve(entity.getUserId());
	}
}
