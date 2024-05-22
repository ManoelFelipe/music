package music.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import music.exception.AlbumAlreadyExistsException;
import music.model.ErroModel;

@ControllerAdvice
public class AlbumAlreadyExistsAdvice extends ResponseEntityExceptionHandler {
	@ExceptionHandler(AlbumAlreadyExistsException.class)
	public ResponseEntity<ErroModel> albumAlreadyExistsHandler(AlbumAlreadyExistsException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroModel(ex.getMessage()));
	}
}
