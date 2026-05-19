package org.serratec.TrabalhoIndividualAPI.Repository;

import org.serratec.TrabalhoIndividualAPI.Domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
