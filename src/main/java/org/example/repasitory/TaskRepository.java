package org.example.repasitory;

import org.example.entity.Task;

import java.util.List;

public interface TaskRepository {
    Task saveTask(Long lessonId, Task task);
    Task updateTask(Long id, Task task);
    List<Task> getAllTaskByLessonId(Long lessonID);
    void deleteTask(Long id);

}
