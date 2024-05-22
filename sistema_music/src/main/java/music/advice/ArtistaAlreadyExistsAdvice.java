package music.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import music.exception.ArtistaAlreadyExistsException;
import music.model.ErroModel;

@ControllerAdvice
public class ArtistaAlreadyExistsAdvice {
	@ExceptionHandler(ArtistaAlreadyExistsException.class)
	public ResponseEntity<ErroModel> artistaAlreadyExistsHandler(ArtistaAlreadyExistsException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroModel(ex.getMessage()));
	}
}
