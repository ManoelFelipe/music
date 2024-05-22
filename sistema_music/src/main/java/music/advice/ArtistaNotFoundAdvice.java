package music.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import music.exception.ArtistaNotFoundException;
import music.model.ErroModel;

@ControllerAdvice
public class ArtistaNotFoundAdvice {
	@ExceptionHandler(ArtistaNotFoundException.class)
	public ResponseEntity<ErroModel> artistaNotFoundHandler(ArtistaNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroModel(ex.getMessage()));
	}
}
