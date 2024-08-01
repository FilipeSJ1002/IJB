package unifacef.edu.IJB.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unifacef.edu.IJB.model.entity.PessoaEntity;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
    // Esta interface vai herdar todos os metodos de CRUD
    // relacionado a FilmeEntity
    // CRUD: Create, Retrieve, Update, Delete
}
