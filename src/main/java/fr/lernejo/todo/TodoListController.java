package fr.lernejo.todo;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
    public class TodoListController {
        private ArrayList <Todo> TodoArrayList= new ArrayList<>();




    @PostMapping(value = "/api/todo")
    public void AddList(@RequestBody Todo todo){
        this.TodoArrayList.add(todo);
    }




    @GetMapping(value = "/api/todo")
    public ArrayList <Todo> getList(){
        return TodoArrayList;
    }



}
