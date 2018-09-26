package br.com.bessacorp.agendaapi.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bessacorp.agendaapi.model.Contato;
import br.com.bessacorp.agendaapi.service.AgendaService;

@RestController
public class AgendaController {
	
	@Autowired
	private AgendaService agendaService;
	
	//ENDPOINTS
	
	// ROOT
	@GetMapping(value="/", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Contato>> get_contatos() {

		System.out.println("Buscou Todos Contatos");
		return new ResponseEntity<>(agendaService.readContato(), HttpStatus.FOUND);
	}
	
	// ROOT/id
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contato> get_contato(@PathVariable Integer id) {
		
		System.out.println("Buscou Contato ID: " + id);
		return new ResponseEntity<>(agendaService.readContato(id), HttpStatus.FOUND);
		
	}
	
	@PutMapping(value="/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contato> put_contato(@RequestBody Contato c, @PathVariable Integer id) {
		
		System.out.println("Atualizou Contato ID: " + id);
		c.setId(id);
		return new ResponseEntity<>(agendaService.updateContato(c), HttpStatus.OK);
		
	}
	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Contato> delete_contato(@PathVariable Integer id) {
		
		System.out.println("Deletou Contato ID: " + id);
		Contato c = agendaService.readContato(id);
		
		if(c != null) {
			agendaService.deleteContato(c);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	// ROOT/novo_contato
	@PostMapping(value="/novo_contato",	consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contato> post_contato(@RequestBody Contato c) {
		System.out.println("Criou novo contato");
		return new ResponseEntity<>(agendaService.createContato(c), HttpStatus.CREATED);
	}

}
