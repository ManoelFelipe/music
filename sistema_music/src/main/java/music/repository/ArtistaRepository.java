package music.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import music.entity.ArtistaEntity;

public interface ArtistaRepository extends JpaRepository<ArtistaEntity, Long> {
	Optional<ArtistaEntity> findByNome(String nome);
}
