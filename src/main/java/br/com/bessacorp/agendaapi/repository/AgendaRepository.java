package br.com.bessacorp.agendaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bessacorp.agendaapi.model.Contato;

@Repository
public interface AgendaRepository extends JpaRepository<Contato, Integer> {

}
