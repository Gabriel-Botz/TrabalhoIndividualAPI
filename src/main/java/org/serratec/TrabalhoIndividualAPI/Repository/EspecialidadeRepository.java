package org.serratec.TrabalhoIndividualAPI.Repository;

import org.serratec.TrabalhoIndividualAPI.Domain.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
}
