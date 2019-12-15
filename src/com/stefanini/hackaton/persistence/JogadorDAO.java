package com.stefanini.hackaton.persistence;

import java.util.List;
import javax.persistence.Query;

import com.stefanini.hackaton.entities.Jogador;

public class JogadorDAO extends GenericDAO<Integer, Jogador> {

	public List<Jogador> buscaNick(String nickName){
	Query buscar = getEntityManager().createQuery("SELECT e FROM Jogador e WHERE e.nickname = :nickname");
	buscar.setParameter("nickname", nickName);
	return buscar.getResultList();
	}
}