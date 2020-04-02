package br.edu.sc.senac.demo.demoproject;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("{id}/details")
	public ResponseEntity<ClientDTO> details(@PathVariable String id) {

		if (id.substring(0, id.length()).matches("[0-9]*")) {
			int newId = Integer.parseInt(id);
			return new ResponseEntity<ClientDTO>(clientController.getClient(newId), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ClientDTO> remove(@PathVariable String id) {
		if (id.substring(0, id.length()).matches("[0-9]*")) {
			int newId = Integer.parseInt(id);
			return new ResponseEntity<ClientDTO>(clientController.removeClient(newId), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

//	@RequestMapping("/add")
//	public Long cadastrar(@RequestParam("nome") String nome, @RequestParam("dataNascimento") String dataNascimento,
//			@RequestParam("email") String email) {
//		ClientDTO client = new ClientDTO(nome, dataNascimento, email);
//		long id = clients.size() - 1;
//		clients.add(client);
//		return id;
//	}

//	@PostMapping("/addpayload")
//	public Long insertClient(@RequestBody ClientDTO client) {
//		return clientController.insertClient(client);
//	}
//
//	@PutMapping("/{id}")
//	public ResponseEntity<ClientDTO> updateClient(@PathVariable String id, @RequestBody ClientDTO updateClient) {
//		if (id.substring(0, id.length()).matches("[0-9]*")) {
//			int newId = Integer.parseInt(id);
//			ClientDTO oldClient = clientController.removeClient(newId);
//			if (newId > -1 && newId < clients.size()) {
//				clients.add(newId, updateClient);
//				return new ResponseEntity<ClientDTO>(oldClient, HttpStatus.OK);
//			}
//		}
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}

}
