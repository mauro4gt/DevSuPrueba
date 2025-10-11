package com.devsu.hackerearth.backend.client.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsu.hackerearth.backend.client.model.dto.ClientDto;
import com.devsu.hackerearth.backend.client.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // ------------------- ENDPOINTS CRUD -------------------

    // GET /api/clients
    @GetMapping
    public ResponseEntity<List<ClientDto>> getAll() {
        List<ClientDto> clients = clientService.getAll();
        return ResponseEntity.ok(clients);
    }

    // GET /api/clients/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> get(@PathVariable Long id) {
        ClientDto client = clientService.getById(id);
        return ResponseEntity.ok(client);
    }

    // POST /api/clients
    @PostMapping
    public ResponseEntity<ClientDto> create(@RequestBody ClientDto clientDto) {
        ClientDto createdClient = clientService.create(clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }

    // PUT /api/clients/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        clientDto.setId(id); // aseguramos coherencia con la URL
        ClientDto updatedClient = clientService.update(clientDto);
        return ResponseEntity.ok(updatedClient);
    }

    // PATCH /api/clients/{id}
    // PATCH /api/clients/{id}
    // The partialUpdate endpoint has been removed due to missing PartialClientDto class.
    // DELETE /api/clients/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
