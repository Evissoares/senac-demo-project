package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")

public class ClientService {
	private List<ClientDTO> clients = new ArrayList<>();

	@PostMapping("/default")
	public List<ClientDTO> addDefault() {
		ClientDTO client = new ClientDTO("Everton", "14/12/1993", "everton@senac.com");
		clients.add(client);
		client = new ClientDTO("João", "19/03/1972", "joao@senac.com");
		clients.add(client);
		client = new ClientDTO("Maria", "04/07/1985", "maria@senac.com");
		clients.add(client);
		return clients;
	}

	@GetMapping("/list")
	public List<ClientDTO> list() {
		return clients;
	}

	@GetMapping("{id}/details")
	public ResponseEntity<ClientDTO> details(@PathVariable String id) {

		if (id.substring(0, id.length()).matches("[0-9]*")) {
			int newId = Integer.parseInt(id);
			if (newId > -1 && newId < clients.size()) {
				return new ResponseEntity<ClientDTO>(clients.get(newId), HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ClientDTO> remove(@PathVariable String id) {

		if (id.substring(0, id.length()).matches("[0-9]*")) {
			int newId = Integer.parseInt(id);
			if (newId > -1 && newId < clients.size()) {
				return new ResponseEntity<ClientDTO>(clients.remove(newId), HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping("/add")
	public Long cadastrar(@RequestParam("nome") String nome, @RequestParam("dataNascimento") String dataNascimento,
			@RequestParam("email") String email) {
		ClientDTO client = new ClientDTO(nome, dataNascimento, email);
		long id = clients.size() - 1;
		clients.add(client);
		return id;
	}

	@PostMapping("/addpayload")
	public Long addClient(@RequestBody ClientDTO client) {
		clients.add(client);
		Long id = Long.valueOf(clients.size() - 1);
		return id;
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClientDTO> updateClient(@PathVariable String id, @RequestBody ClientDTO updateClient) {
		if (id.substring(0, id.length()).matches("[0-9]*")) {
			int newId = Integer.parseInt(id);
			ClientDTO oldClient = clients.remove(newId);
			if (newId > -1 && newId < clients.size()) {
				clients.add(newId, updateClient);
				return new ResponseEntity<ClientDTO>(oldClient, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
