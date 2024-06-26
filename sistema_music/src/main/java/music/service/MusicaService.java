package music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import music.entity.MusicaEntity;
import music.model.MusicaModel;

@Component
public interface MusicaService {
	MusicaEntity newMusica(MusicaModel newMusica);
	
	MusicaEntity updateMusica(Long id, MusicaModel newMusica);
	
	List<MusicaEntity> listMusica(Optional<String> idAlbum);
	
	MusicaEntity getMusica(Long id);
	
	void deleteMusica(Long id);
	
	MusicaEntity validaMusica(Long id);
}
