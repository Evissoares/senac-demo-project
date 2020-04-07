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

	private static int validateID(String verifyID) {
		if (verifyID.substring(0, verifyID.length()).matches("[0-9]*")) {
			int validID = Integer.parseInt(verifyID);
			return validID;
		}
		return -1;
	}

	private boolean isPresent(int id) {
		return id > -1 && id < clients.size();
	}

	ClientDTO getClient(String id) {
		int newId = validateID(id);
		if (isPresent(newId)) {
			return clients.get(newId);
		}
		return ClientDTO.NULL_VALUE;
	}

	ClientDTO removeClient(String id) {
		int newId = validateID(id);
		if (isPresent(newId)) {
			ClientDTO oldClient = clients.remove(newId);
			return oldClient;
		}
		return ClientDTO.NULL_VALUE;
	}

	ClientDTO updateClient(String id, ClientDTO newClient) {
		int newId = validateID(id);
		if (isPresent(newId)) {
			ClientDTO oldClient = clients.remove(newId);
			clients.add(newId, newClient);
			return oldClient;
		}
		return ClientDTO.NULL_VALUE;
	}

}
