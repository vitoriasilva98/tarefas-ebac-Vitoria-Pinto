package br.com.ebac.animal_service.repositorios;

import br.com.ebac.animal_service.dto.FuncionarioDTO;
import br.com.ebac.animal_service.entidades.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada")
    List<Animal> findNotAdopted();

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL")
    List<Animal> findAdopted();

    @Query("SELECT new br.com.ebac.animal_service.dto.FuncionarioDTO(a.nomeRecebedor, COUNT(a.nomeRecebedor)) FROM Animal a " +
            "WHERE a.dataEntrada BETWEEN :startDate AND :endDate GROUP BY a.nomeRecebedor")
    List<FuncionarioDTO> countAnimalsResgatadosByFuncionarioAndDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}

