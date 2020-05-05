package br.edu.sc.senac.demo.demoproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

@Controller
public class ClientController {

	private final ClientRepository clientRepository;

	ClientController(final ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	private static void updateEntityFromDTO(final ClientDTO clientDTO, final ClientEntity clientEntity) {
		clientEntity.setName(clientDTO.getName());
		clientEntity.setBirthDate(clientDTO.getDataNascimento());
		clientEntity.setEmail(clientDTO.getEmail());
	}

	private static ClientEntity toEntity(final ClientDTO clientDTO) {
		final String name = clientDTO.getName();
		final String birthDate = clientDTO.getDataNascimento();
		final String email = clientDTO.getEmail();
		return new ClientEntity(name, birthDate, email);
	}

	private static ClientDTO toDTO(final ClientEntity clientEntity) {
		final String name = clientEntity.getName();
		final String birthDate = clientEntity.getBirthDate();
		final String email = clientEntity.getEmail();
		final Long clientId = clientEntity.getClientId();
		return new ClientDTO(clientId, name, birthDate, email);
	}

	List<ClientDTO> getAllClients() {
		final List<ClientDTO> clients = new ArrayList<>();
		this.clientRepository.findAll().forEach(clientEntity -> clients.add(ClientController.toDTO(clientEntity)));
		return clients;
	}

	String insertClient(ClientDTO client) {
		ClientEntity clientEntity = ClientController.toEntity(client);
		this.clientRepository.save(clientEntity);
		return String.valueOf(clientEntity.getClientId());
	}

//	private static int validateID(String verifyID) {
//		if (verifyID.substring(0, verifyID.length()).matches("[0-9]*")) {
//			int validID = Integer.parseInt(verifyID);
//			return validID;
//		}
//		return -1;
//	}

//	private boolean isPresent(int id) {
//		return id > -1 && id < clients.size();
//	}

	ClientDTO getClient(final Long id) {
		final Optional<ClientEntity> optionalProduct = this.clientRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return ClientController.toDTO(optionalProduct.get());
		}

		// final Optional<ClientEntity> optionalClient=
		// this.clientRepository.findById(id);
//		if (optionalClient.isPresent()) {
//			return ClientController.toDTO(optionalClient.get());
//		}

		return ClientDTO.NULL_VALUE;

	}

	ClientDTO removeClient(Long id) {
		final Optional<ClientEntity> optionalClient = this.clientRepository.findById(id);
		if (optionalClient.isPresent()) {
			final ClientEntity clientEntity = optionalClient.get();
			this.clientRepository.delete(clientEntity);
			return ClientController.toDTO(clientEntity);
		}

		// int newId = validateID(id);
//		if (isPresent(newId)) {
//			ClientDTO oldClient = clients.remove(newId);
//			return oldClient;
//		}
		return ClientDTO.NULL_VALUE;
	}

	ClientDTO updateClient(Long id, ClientDTO newClient) {
		final Optional<ClientEntity> optionalClient = this.clientRepository.findById(id);
		if (optionalClient.isPresent()) {
			final ClientEntity clientEntity = optionalClient.get();
			final ClientDTO oldClientDTO = ClientController.toDTO(clientEntity);
			ClientController.updateEntityFromDTO(newClient, clientEntity);
			this.clientRepository.save(clientEntity);
			return oldClientDTO;
		}

		// int newId = validateID(id);
//		if (isPresent(newId)) {
//			ClientDTO oldClient = clients.remove(newId);
//			clients.add(newId, newClient);
//			return oldClient;
//		}
		return ClientDTO.NULL_VALUE;
	}

}
