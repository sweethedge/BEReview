package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TodoDTO;
import com.example.demo.model.TodoEntity;
import com.example.demo.service.TodoService;

@RestController
@RequestMapping("todo")
public class TodoController {
	
	@Autowired
	private TodoService service;
	
	@GetMapping("/test")
	// Extension of HttpEntity that adds an HttpStatus status code.
	// HTTP 응답의 바디뿐만 아니라 여러 다른 매개변수들(status,header 등)을 조작하고 싶을 때 사용
	public ResponseEntity<?> testTodo() {
		String str = service.testService(); // 테스트 서비스 사용
		List<String> list = new ArrayList<>();
		list.add(str);
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping
	public ResponseEntity<?> createTodo(@AuthenticationPrincipal String userId, @RequestBody TodoDTO dto) {
		try {
			
			// TodoEntity로 변환
			TodoEntity entity = TodoDTO.toEntity(dto);
			
			// id를 null로 초기화. 생성 당시에는 id가 없어야 하기 때문
			entity.setId(null);
			
			// Authentication Bearer Token을 통해 받은 userId를 넘김
			entity.setUserId(userId);
			
			// 서비스를 이용해 Todo 엔티티를 생성
			List<TodoEntity> entities = service.create(entity);
			
			// 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO 리스트로 변환
			List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
			
			// 변환된 TodoDTO 리스트를 이용해 ResponseDTO를 초기화
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
			
			// ResponseDTO를 리턴
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			// 예외 처리
			String error = e.getMessage();
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> retrieveTodoList(@AuthenticationPrincipal String userId) {
		
		// 서비스 메서드의 retrieve 메서드를 사용해 Todo 리스트를 가져옴
		List<TodoEntity> entities = service.retrieve(userId);
		
		// 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO 리스트로 변환
		List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
		
		// 변환된 TodoDTO 리스트를 이용해 ResponseDTO를 초기화
		ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
		
		// ResponseDTO를 리턴
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping
	public ResponseEntity<?> updateTodo(@AuthenticationPrincipal String userId, @RequestBody TodoDTO dto) {
		
		// dto를 entity로 변환
		TodoEntity entity = TodoDTO.toEntity(dto);
		
		// Authentication Bearer Token을 통해 받은 userId를 넘김
		entity.setUserId(userId);
		
		// 서비스를 이용해 entity를 업데이트
		List<TodoEntity> entities = service.update(entity);
		
		// 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO 리스트로 변환
		List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
		
		// 변환된 TodoDTO 리스트를 이용해 ResponseDTO를 초기화
		ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
		
		// ResponseDTO를 리턴
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteTodo(@AuthenticationPrincipal String userId, @RequestBody TodoDTO dto) {
		try {
			
			// dto를 entity로 변환
			TodoEntity entity = TodoDTO.toEntity(dto);
			
			// Authentication Bearer Token을 통해 받은 userId를 넘김
			entity.setUserId(userId);
			
			// 서비스를 이용해 entity를 삭제
			List<TodoEntity> entities = service.delete(entity);
			
			// 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO 리스트로 변환
			List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
			
			// 변환된 TodoDTO 리스트를 이용해 ResponseDTO를 초기화
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
			
			// ResponseDTO를 리턴
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			// 예외가 나는 경우 dto 대신 error에 메시지를 넣어 리턴
			String error = e.getMessage();
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
			return ResponseEntity.badRequest().body(response);
		}
	}
}

/*
 * 응답을 딱 두개로 해 줌. error와 data. 
 * 어떤 data를 주냐면 TodoDTO의 데이터를 주는 거임.
 * TodoDTO의 데이터에 들어 있는게 뭐냐면 id, title, done.
 * 
 * create 메서드를 콜하면 responseDTO에서 2가지를 넘겨주고, 그 내용은 TodoDTO에서.
 * */

