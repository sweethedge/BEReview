import './App.css';
import Todo from './Todo';
import React, { useEffect, useState } from 'react';
import { Container, List, Paper, Grid, Button, AppBar, Toolbar, Typography } from '@mui/material';
import AddTodo from "./AddTodo";
import { call, signout } from "./service/ApiService";

function App() {
  // 일단 처음에 loading을 true로 걸어 놓고
  const [loading, setLoading] = useState(true);
  const [items, setItems] = useState([]);

  /*
  useEffect(() => {
    const requestOptions = {
      method: "GET",
      Headers: {"Content-Type": "application/json"},
    };
  
    fetch("http://localhost:8080/todo", requestOptions)
    .then((response) => response.json())
    .then(
      (response) => {
        setItems(response.data);
      },
      (error) => {}
    );
  }, [])
  
  const addItem = (item) => {
    item.id = "ID-" + items.length; // key를 위한 id
    item.done = "false"; // done 초기화
    // 업데이트는 반드시 setItems로 하고 새 배열을 만들어야 한다.
    setItems([...items, item]);
    console.log("items: ", items);
  }

  const editItem = () => {
    setItems([...items]);
  }

  const deleteItem = (item) => {
    // 삭제할 아이템을 찾는다.
    const newItems = items.filter(e => e.id !== item.id);
    // 삭제할 아이템을 제외한 아이템을 다시 배열에 저장한다.
    setItems([...newItems]);
  }

  */

  useEffect(() => {
    call("/todo", "GET", null)
    .then((response) => setItems(response.data));
    // 다 긁으면 loading을 false로
    setLoading(false);
  }, []);

  const addItem = (item) => {
    call("/todo", "POST", item)
    .then((response) => setItems(response.data));
  };

  const editItem = (item) => {
    call("/todo", "PUT", item)
    .then((response) => setItems(response.data));
  };

  const deleteItem = (item) => {
    call("/todo", "DELETE", item)
    .then((response) => setItems(response.data));
  };

  let todoItems = items.length > 0 && (
    <Paper style={{ margin: 16 }}>
      <List>
        {items.map((item) => (
          // App 컴포넌트에서 Todo 컴포넌트 사용
          <Todo item={item} key={item.id} editItem={editItem} deleteItem={deleteItem} />
        ))}
      </List>
    </Paper>
  )

  // navigationBar 추가
  let navigationBar = (
    <AppBar position='static'>
      <Toolbar>
        <Grid justifyContent="space-between" container>
          <Grid item>
            <Typography variant='h6'>오늘의 할 일</Typography>
          </Grid>
          <Grid item>
            <Button color='inherit' raised="true" onClick={signout}>
              로그아웃
            </Button>
          </Grid>
        </Grid>
      </Toolbar>
    </AppBar>
  )

  // 로딩중이 아닐 때 렌더링할 부분
  let todoListPage = (
    <div>
      {navigationBar}
      <Container maxWidth="md">
        <AddTodo addItem={addItem} />
      <div className='TodoList'>{todoItems}</div>
      </Container>
    </div>
  )

  // 로딩중일 때 렌더링할 부분
  console.log("loading::", loading);
  let loadingPage = <h1> 로딩중... </h1>;
  let content = loadingPage;

  if (loading === false) {
    // 로딩중이 아니면 todoListPage를 선택
    content = todoListPage;
  }

  return (
    <div className="App">{content}</div>
  );
}

export default App;

/*
스프레드 연산자
// Array
var arr1 = [1, 2, 3, 4, 5]; 
var arr2 = [...arr1, 6, 7, 8, 9]; 

console.log(arr2); // [ 1, 2, 3, 4, 5, 6, 7, 8, 9 ]
*/