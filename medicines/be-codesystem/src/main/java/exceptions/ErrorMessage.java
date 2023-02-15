package exceptions;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorMessage {

  private String message;	
  private int statusCode;
  private Date timestamp;
  private String description;

  public ErrorMessage(int statusCode, Date timestamp, String message, String description) {
    this.statusCode = statusCode;
    this.timestamp = timestamp;
    this.message = message;
    this.description = description;
  }
  
}