package org.serratec.TrabalhoIndividualAPI.Repository;

import org.serratec.TrabalhoIndividualAPI.Domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
