package org.serratec.TrabalhoIndividualAPI.Repository;

import org.serratec.TrabalhoIndividualAPI.Domain.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
}
