package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TaskWrite
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-11-15T10:10:17.509Z[GMT]")

public class TaskWrite   {
  @JsonProperty("text")
  private String text;

  @JsonProperty("done")
  private Boolean done;

  public TaskWrite text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Get text
   * @return text
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Size(min=2,max=255) 
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public TaskWrite done(Boolean done) {
    this.done = done;
    return this;
  }

  /**
   * Get done
   * @return done
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean getDone() {
    return done;
  }

  public void setDone(Boolean done) {
    this.done = done;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskWrite taskWrite = (TaskWrite) o;
    return Objects.equals(this.text, taskWrite.text) &&
        Objects.equals(this.done, taskWrite.done);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, done);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskWrite {\n");
    
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    done: ").append(toIndentedString(done)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

