package com.stefanini.hackaton.service;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.parsers.JogadorParserDTO;
import com.stefanini.hackaton.persistence.JogadorDAO;
import com.stefanini.hackaton.rest.exceptions.NegocioException;

public class JogadorService {

	@Inject
	JogadorParserDTO parser;
	
	@Inject
	JogadorParserDTO jogadorParser;
	
	@Inject
	JogadorDAO jogadorDao;

	public List<JogadorDto> listar() {
		return parser.toDTO(jogadorDao.list());
	}


	public JogadorDto obter(Integer id) {
		return parser.toDTO(jogadorDao.findById(id));
	}

	public JogadorDto cadastrarJogador(Jogador jogador) throws NegocioException {

		
		if(jogador.getSenha().length() > 8) {
			throw new NegocioException("Sua senha não pode ser maior que 8 caracteres");
		}
		else if(jogador.getSenha().length() < 6) {
			throw new NegocioException("Sua senha não pode ser menor que 6 caracteres");
		}
		
		else if(jogadorDao.buscaNick(jogador.getNickname()).size() != 0 ) {
			throw new NegocioException("nickname "+ jogador.getNickname()+" indisponivel");
			}
		
		jogadorDao.insert(jogador);
	
		return parser.toDTO(jogador);
	}
	
	
	public JogadorDto verificarJogador(Jogador jogador) throws NegocioException {
		List<Jogador> listarJogador = jogadorDao.buscaNick(jogador.getNickname());
	
		if(jogadorDao.buscaNick(jogador.getNickname()).size() < 1) {
			throw new NegocioException("Ops! Seu nickname ou senha estão incorretos");
		}
		if (!jogador.getSenha().equals(listarJogador.get(0).getSenha()))  {
			throw new NegocioException("Ops! Seu nickname ou senha estão incorretos");
		}
		
		return parser.toDTO(jogador);
	}
	


	
}
