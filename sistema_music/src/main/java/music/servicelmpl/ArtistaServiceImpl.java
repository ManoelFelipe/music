package music.servicelmpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import music.entity.ArtistaEntity;
import music.exception.ArtistaAlreadyExistsException;
import music.exception.ArtistaNotFoundException;
import music.model.ArtistaModel;
import music.repository.ArtistaRepository;
import music.service.ArtistaService;

@Service
public class ArtistaServiceImpl implements ArtistaService {
	@Autowired
	private ArtistaRepository artistaRepository;

	@Override
	public ArtistaEntity newArtista(ArtistaModel newArtista) {
		validaArtista(newArtista.getNome());
		ArtistaEntity artista = new ArtistaEntity(newArtista.getNome());
		return artistaRepository.save(artista);
	}

	@Override
	public ArtistaEntity updateArtista(Long id, ArtistaModel newArtista) {
		validaArtista(newArtista.getNome());
		ArtistaEntity artista = validaArtista(id);
		artista.setNome(newArtista.getNome());
		return artistaRepository.save(artista);
	}

	@Override
	public List<ArtistaEntity> listArtista() {
		return artistaRepository.findAll();
	}

	@Override
	public ArtistaEntity getArtista(Long id) {
		return validaArtista(id);
	}

	@Override
	public void deleteArtista(Long id) {
		artistaRepository.delete(validaArtista(id));
	}
	
	public ArtistaEntity validaArtista(Long id) {
		return artistaRepository.findById(id).orElseThrow(() -> new ArtistaNotFoundException(id));
	}
	
	private void validaArtista(String nome) {
		if (artistaRepository.findByNome(nome).isPresent())
			throw new ArtistaAlreadyExistsException(nome);
	}
}
