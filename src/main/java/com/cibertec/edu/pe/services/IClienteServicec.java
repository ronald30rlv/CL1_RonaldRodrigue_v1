package com.cibertec.edu.pe.services;

import java.util.List;

import com.cibertec.edu.pe.entity.Cliente;

public interface IClienteServicec {
	public List<Cliente> ListadoClientes();
	public Cliente registrarCliente(Cliente cliente);
}
