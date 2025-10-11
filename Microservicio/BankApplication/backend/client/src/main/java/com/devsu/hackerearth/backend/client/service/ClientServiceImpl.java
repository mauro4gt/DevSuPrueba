package com.devsu.hackerearth.backend.client.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.devsu.hackerearth.backend.client.model.Client;
import com.devsu.hackerearth.backend.client.model.dto.ClientDto;
import com.devsu.hackerearth.backend.client.model.dto.PartialClientDto;
import com.devsu.hackerearth.backend.client.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDto> getAll() {
        return clientRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto getById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + id));
        return mapToDto(client);
    }

    @Override
    public ClientDto create(ClientDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setDni(clientDto.getDni());
        client.setGender(clientDto.getGender());
        client.setAge(clientDto.getAge());
        client.setAddress(clientDto.getAddress());
        client.setPhone(clientDto.getPhone());
        client.setIsActive(clientDto.isActive());
        Client saved = clientRepository.save(client);
        return mapToDto(saved);
    }

    @Override
    public ClientDto update(ClientDto clientDto) {
        Client client = clientRepository.findById(clientDto.getId())
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + clientDto.getId()));
        client.setName(clientDto.getName());
        client.setDni(clientDto.getDni());
        client.setGender(clientDto.getGender());
        client.setAge(clientDto.getAge());
        client.setAddress(clientDto.getAddress());
        client.setPhone(clientDto.getPhone());
        client.setIsActive(clientDto.isActive());
        Client updated = clientRepository.save(client);
        return mapToDto(updated);
    }

    @Override
    public ClientDto partialUpdate(Long id, PartialClientDto partialClientDto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found with ID: " + id));

        if (partialClientDto.getName() != null) client.setName(partialClientDto.getName());
        if (partialClientDto.getDni() != null) client.setDni(partialClientDto.getDni());
        if (partialClientDto.getGender() != null) client.setGender(partialClientDto.getGender());
        if (partialClientDto.getAge() != null) client.setAge(partialClientDto.getAge());
        if (partialClientDto.getAddress() != null) client.setAddress(partialClientDto.getAddress());
        if (partialClientDto.getPhone() != null) client.setPhone(partialClientDto.getPhone());
        if (partialClientDto.getIsActive() != null) client.setIsActive(partialClientDto.getIsActive());

        Client updated = clientRepository.save(client);
        return mapToDto(updated);
    }

    @Override
    public void deleteById(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client not found with ID: " + id);
        }
        clientRepository.deleteById(id);
    }

    private ClientDto mapToDto(Client client) {
        return new ClientDto(
                client.getId(),
                client.getDni(),
                client.getName(),
                null, // password
                client.getGender(),
                client.getAge(),
                client.getAddress(),
                client.getPhone(),
                client.getIsActive()
        );
    }
}
