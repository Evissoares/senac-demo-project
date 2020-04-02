package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
public class ClientController {

	final List<ClientDTO> clients = new ArrayList<>();

	List<ClientDTO> getAllClients() {
		return clients;
	}

	Long insertClient(final ClientDTO client) {
		this.clients.add(client);
		Long id = Long.valueOf(clients.size() - 1);
		return id;
	}

	ClientDTO getClient(int id) {
		if (id > -1 && id < clients.size()) {
			return clients.get(id);
		}
		return ClientDTO.NULL_VALUE;
	}

	ClientDTO removeClient(int id) {
		if (id > -1 && id < clients.size()) {
			return clients.remove(id);
		}
		return ClientDTO.NULL_VALUE;
	}

}
