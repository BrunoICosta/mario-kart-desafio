package com.stefanini.hackaton.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.rest.exceptions.NegocioException;
import com.stefanini.hackaton.service.JogadorService;


@Path("/jogador")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JogadorApi {
	
	@Inject
	private JogadorService jogadorService;
	
	
	
	@GET
	@Path("/{id}")
	public Response obter(@PathParam("id") Integer id) {
		return Response.ok(jogadorService.obter(id)).build();
	}
	
	@POST 
	public Response cadastrarJogador(Jogador jogador) throws NegocioException {
		
		return Response.ok(jogadorService.cadastrarJogador(jogador)).build();
	}
	@Path("/autenticar")
	@POST 
	public Response verificarJogador(Jogador jogador) throws NegocioException{
		return Response.ok(jogadorService.verificarJogador(jogador)).build();
	}
	
}
