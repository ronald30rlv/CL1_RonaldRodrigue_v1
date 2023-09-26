package com.cibertec.edu.pe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.edu.pe.entity.Cliente;
import com.cibertec.edu.pe.repository.ClienteRepository;

@Service
public class ClienteImplementService implements IClienteServicec {
	@Autowired
	private ClienteRepository repository;
	@Override
	public List<Cliente> ListadoClientes() {		
		return repository.findAll();
	}

	@Override
	public Cliente registrarCliente(Cliente cliente) {		
		return repository.save(cliente);
	}

}
