package br.edu.sc.senac.demo.demoproject;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/client")

public class ClientService {

	ClientController clientController;

	private ClientService(ClientController clientController) {
		this.clientController = clientController;
	}

	@PostMapping("/default")
	public List<ClientDTO> addDefault() {
		clientController.insertClient(new ClientDTO("Everton", "14/12/1993", "everton@senac.com"));
		clientController.insertClient(new ClientDTO("João", "19/03/1972", "joao@senac.com"));
		clientController.insertClient(new ClientDTO("Maria", "04/07/1985", "maria@senac.com"));
		return clientController.getAllClients();
	}

	@GetMapping("/list")
	public List<ClientDTO> list() {
		return clientController.getAllClients();
	}

	// Refatorado 05/04/2020
	@PostMapping("/addpayload")
	public Long insertClient(@RequestBody ClientDTO client) {
		return clientController.insertClient(client);
	}

	// Refatorado 05/04/2020
	@GetMapping("{id}/details")
	public ResponseEntity<ClientDTO> clientDetails(@PathVariable String id) {
		ClientDTO verifiedClient = clientController.getClient(id);
		if (ClientDTO.NULL_VALUE.equals(verifiedClient)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ClientDTO>(verifiedClient, HttpStatus.OK);
	}

	// Refatorado 05/04/2020
	@DeleteMapping("/{id}")
	public ResponseEntity<ClientDTO> removeClient(@PathVariable String id) {
		ClientDTO verifiedClient = clientController.removeClient(id);
		if (ClientDTO.NULL_VALUE.equals(verifiedClient)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ClientDTO>(verifiedClient, HttpStatus.OK);
	}

	// Refatorado 05/04/2020
	@PutMapping("/{id}")
	public ResponseEntity<ClientDTO> updateClient(@PathVariable String id, @RequestBody ClientDTO updateClient) {
		ClientDTO verifiedClient = clientController.updateClient(id, updateClient);
		if (ClientDTO.NULL_VALUE.equals(verifiedClient)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ClientDTO>(verifiedClient, HttpStatus.OK);
	}

}

//	@RequestMapping("/add")
//	public Long cadastrar(@RequestParam("nome") String nome, @RequestParam("dataNascimento") String dataNascimento,
//			@RequestParam("email") String email) {
//		ClientDTO client = new ClientDTO(nome, dataNascimento, email);
//		long id = clients.size() - 1;
//		clients.add(client);
//		return id;
//	}
