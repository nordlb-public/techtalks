package org.openapitools.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-15T10:10:17.509Z[GMT]")

@Controller
@RequestMapping("${openapi.task.base-path:/taskapi}")
public class TasksApiController implements TasksApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TasksApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
}
