package fr.lernejo.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TodoListController {
    private final TodoRepository todoRepository;
    //ArrayList<Todo> todoArrayList = new ArrayList<>();

    public TodoListController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @PostMapping(value = "/api/todo")
    /*public void addTodoToTheList(@RequestParam("message") String message, @RequestParam("author") String author){
        this.todoArrayList.add(new Todo(message, author));
    }*/
    public @ResponseBody TodoEntity addTodoToTheBdd(@RequestBody Todo todo){
        return this.todoRepository.save(new TodoEntity(null, todo.message(), todo.author()));
    }

    @GetMapping(value = "/api/todo")
    /*public @ResponseBody ArrayList<Todo> getTodoList(){
        return this.todoArrayList;
    }*/
    public @ResponseBody Iterable<Todo> getTodoList(){
        Iterable<TodoEntity> todoEntityIterable = this.todoRepository.findAll();
        ArrayList<Todo> todoArrayList = new ArrayList<>();
        for (TodoEntity todo : todoEntityIterable) {
            todoArrayList.add(new Todo(todo.message, todo.author));
        }
        return todoArrayList;
    }
}
