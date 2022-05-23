package br.com.cadastrarpessoa.service;

import java.util.ArrayList;
import java.util.Date;

import br.com.cadastrarpessoa.dao.PessoaDao;
import br.com.cadastrarpessoa.model.Pessoa;

public class PessoaService {
	
	public ArrayList<Pessoa> chamaListaPessoaService() {
		
		PessoaDao pessoaDao = new PessoaDao();
		ArrayList<PessoaDao> listaPessoaDao = new ArrayList<>();
		ArrayList<Pessoa> listaPessoa = new ArrayList<>();
		
		
		for(Pessoa p : pessoaDao.chamaListaPessoas()) {
			
			long id = p.getId();
			String nome = p.getNome();
			int idade = p.getIdade();
			String sexo = p.getSexo();
			Date data = new Date();
			
			listaPessoa.add(new Pessoa(id, nome, idade, sexo, data));
		}	
		
		return listaPessoa;
	}
}
