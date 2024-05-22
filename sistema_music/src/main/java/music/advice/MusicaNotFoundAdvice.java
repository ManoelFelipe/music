package music.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import music.exception.MusicaNotFoundException;
import music.model.ErroModel;

@ControllerAdvice
public class MusicaNotFoundAdvice {
	@ExceptionHandler(MusicaNotFoundException.class)
	public ResponseEntity<ErroModel> musicaNotFoundHandler(MusicaNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroModel(ex.getMessage()));
	}
}
