package br.com.bessacorp.agendaapi.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bessacorp.agendaapi.model.Contato;
import br.com.bessacorp.agendaapi.repository.AgendaRepository;
import br.com.bessacorp.agendaapi.exception.ResourceNotFoundException;

@Service
public class AgendaService {
	
	@Autowired
	AgendaRepository agendaRepository;
	
	public Contato createContato(Contato c) {
		return agendaRepository.save(c);
	}
	
	public Collection<Contato> readContato(){
		return agendaRepository.findAll();
	}

	public Contato readContato(Integer id) {
		return agendaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contato", "id", id));
	}
	
	public Contato updateContato(Contato c) {
		return agendaRepository.save(c);
	}
	
	public void deleteContato(Contato c) {
		agendaRepository.delete(c);
	}

}
