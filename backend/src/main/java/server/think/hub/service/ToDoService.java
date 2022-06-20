package server.think.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.think.demo.repository.ToDoRepository;
import server.think.demo.data.ToDo;
import server.think.demo.exception.EntityNotFoundException;

import java.util.List;


@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    public ToDo findByID(String ID) {
        return toDoRepository.findById(ID).orElseThrow(EntityNotFoundException::new);
    }

    public ToDo save(ToDo toDo){
        return toDoRepository.save(toDo);
    }

    public void deleteById(String id){
        toDoRepository.deleteById(id);
    }
}
