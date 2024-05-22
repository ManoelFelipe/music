package music.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import music.exception.AlbumNotFoundException;
import music.model.ErroModel;

@ControllerAdvice
public class AlbumNotFoundAdvice {
	@ExceptionHandler(AlbumNotFoundException.class)
	public ResponseEntity<ErroModel> albumNotFoundHandler(AlbumNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroModel(ex.getMessage()));
	}
}
