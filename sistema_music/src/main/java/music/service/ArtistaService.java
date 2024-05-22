package music.service;

import java.util.List;

import org.springframework.stereotype.Component;

import music.entity.ArtistaEntity;
import music.model.ArtistaModel;

@Component
public interface ArtistaService {
	ArtistaEntity newArtista(ArtistaModel newArtista);
	
	ArtistaEntity updateArtista(Long id, ArtistaModel newArtista);
	
	List<ArtistaEntity> listArtista();
	
	ArtistaEntity getArtista(Long id);
	
	void deleteArtista(Long id);
	
	ArtistaEntity validaArtista(Long id);
}
