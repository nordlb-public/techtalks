package org.openapitools.domain;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.openapitools.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class TasksStateImpl implements ITasksState {

  private final Map<Integer, Task> id2taskMap;

  @Autowired
  public TasksStateImpl() {
    this.id2taskMap = new ConcurrentHashMap<>();
  }

  @Override
  public synchronized Task createTask(String text, Boolean done) {
    Task task = new Task()
        .id(this.id2taskMap.size())
        .done(done)
        .text(text);
    this.id2taskMap.put(task.getId(), task);
    return task;
  }

  @Override
  public Task getTaskById(Integer id) {
    return this.id2taskMap.get(id);
  }

  @Override
  public List<Task> getTasks() {
    return List.copyOf(this.id2taskMap.values());
  }

  @Override
  public synchronized void deleteTaskById(Integer id) {
    this.id2taskMap.remove(id);
  }
}
