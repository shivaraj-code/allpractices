package exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalControllerExceptionHandler{

		 @ExceptionHandler(java.sql.SQLSyntaxErrorException.class)
		  public ResponseEntity<ErrorMessage> sqlGrammarException(java.sql.SQLSyntaxErrorException ex,
				                                                       WebRequest request) {
		    ErrorMessage message = new ErrorMessage(
		        502,
		        new Date(),
		        ex.getMessage(),
		        request.getDescription(false));
		   // System.out.println("in sql exception");
		    return new ResponseEntity<>(message, new HttpHeaders(), 501);
		  }
	  
	  @ExceptionHandler(Exception.class)
	  public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        HttpStatus.INTERNAL_SERVER_ERROR.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	}