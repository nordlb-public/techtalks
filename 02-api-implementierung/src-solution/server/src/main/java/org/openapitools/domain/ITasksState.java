package org.openapitools.domain;

import java.util.List;
import org.openapitools.model.Task;

public interface ITasksState {
  Task createTask(String text, Boolean done);
  Task getTaskById(Integer id);
  List<Task> getTasks();
  void deleteTaskById(Integer id);
}
