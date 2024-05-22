package music.servicelmpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import music.entity.AlbumEntity;
import music.entity.MusicaEntity;
import music.exception.MusicaAlreadyExistsException;
import music.exception.MusicaNotFoundException;
import music.model.MusicaModel;
import music.repository.MusicaRepository;
import music.service.AlbumService;
import music.service.MusicaService;

@Service
public class MusicaServiceImpl implements MusicaService {
	@Autowired
	private MusicaRepository musicaRepository;
	
	@Autowired
	private AlbumService albumService;
	
	@Override
	public MusicaEntity newMusica(MusicaModel newMusica) {
		validaAlbum(newMusica.getIdAlbum());
		validaMusica(newMusica.getIdAlbum(), newMusica.getNome());
		AlbumEntity album = albumService.getAlbum(newMusica.getIdAlbum());
		MusicaEntity musica = new MusicaEntity(newMusica.getNome(), newMusica.getDuracao(), album);
		return musicaRepository.save(musica);
	}

	@Override
	public MusicaEntity updateMusica(Long id, MusicaModel newMusica) {
		validaAlbum(newMusica.getIdAlbum());
		MusicaEntity musica = validaMusica(id);
		musica.setNome(newMusica.getNome());
		musica.setDuracao(newMusica.getDuracao());
		return musicaRepository.save(musica);
	}

	@Override
	public List<MusicaEntity> listMusica(Optional<String> idAlbum) {
		if (idAlbum.isEmpty())
			return musicaRepository.findAll();
		else
			return musicaRepository.findByIdAlbum(Long.parseLong(idAlbum.get()));
	}

	@Override
	public MusicaEntity getMusica(Long id) {
		return validaMusica(id);
	}

	@Override
	public void deleteMusica(Long id) {
		musicaRepository.delete(validaMusica(id));
	}

	@Override
	public MusicaEntity validaMusica(Long id) {
		return musicaRepository.findById(id).orElseThrow(() -> new MusicaNotFoundException(id));
	}
	
	private void validaMusica(Long idAlbum, String nome) {
		if (musicaRepository.findByIdAlbumAndNome(idAlbum, nome).isPresent())
			throw new MusicaAlreadyExistsException(nome);
	}
	
	private void validaAlbum(Long idAlbum) {
		albumService.validaAlbum(idAlbum);
	}
}
