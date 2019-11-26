package org.openapitools.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.openapitools.domain.ITasksState;
import org.openapitools.model.Task;
import org.openapitools.model.TaskWrite;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-15T10:10:17.509Z[GMT]")

@Controller
@RequestMapping("${openapi.task.base-path:/taskapi}")
public class TasksApiController implements TasksApi {

  private final NativeWebRequest request;
  private final ITasksState taskState;

  @org.springframework.beans.factory.annotation.Autowired
  public TasksApiController(NativeWebRequest request, ITasksState tasksState) {
    this.request = request;
    this.taskState = tasksState;
  }

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.ofNullable(request);
  }

  @Override
  public ResponseEntity<Task> createTask(TaskWrite taskWrite) {
    return ResponseEntity.ok(taskState.createTask(taskWrite.getText(), taskWrite.getDone()));
  }

  @Override
  public ResponseEntity<Void> deleteTask(Integer taskId) {
    if (taskState.getTaskById(taskId) != null) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }

  @Override
  public ResponseEntity<Task> getTaskById(Integer taskId) {
    Task task = taskState.getTaskById(taskId);
    return task == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(task);
  }

  @Override
  public ResponseEntity<List<Task>> getTasks() {
    return ResponseEntity.ok(taskState.getTasks());
  }

  @Override
  public ResponseEntity<Task> updateTask(Integer taskId, @Valid TaskWrite taskWrite) {
    Task task = taskState.getTaskById(taskId);
    return (task == null) ?
        ResponseEntity.notFound().build() :
        ResponseEntity.ok(task
            .done(taskWrite.getDone())
            .text(taskWrite.getText()));
  }

  @ApiOperation(value = "get a taskwrite", nickname = "getTaskWrite", notes = "", tags={ "tasks", })
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "expected response to a valid request") })
  @RequestMapping(value = "/tasks/taskWrite",
      method = RequestMethod.GET)
  public ResponseEntity<TaskWrite> getTaskWrite() {
    return ResponseEntity.ok(new TaskWrite().done(true).text("some text"));
  }
}
