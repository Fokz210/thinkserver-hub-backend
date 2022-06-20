package server.think.hub.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import server.think.hub.data.ToDo;

public interface ToDoRepository extends MongoRepository<ToDo, String>{

}