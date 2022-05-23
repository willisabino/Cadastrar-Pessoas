package br.com.cadastrarpessoa.service;

import java.util.ArrayList;
import java.util.Date;

import br.com.cadastrarpessoa.dao.PessoaDao;
import br.com.cadastrarpessoa.model.Pessoa;

public class PessoaService {
	
	public ArrayList<Pessoa> chamaListaPessoaService() {
		
		PessoaDao pessoaDao = new PessoaDao();
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

	public void inserirPessoas(String nome, String idade, String sexo) {
		
		PessoaDao pessoaDao = new PessoaDao();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setIdade(Integer.parseInt(idade));
		pessoa.setSexo(sexo);
		pessoa.setDataCadastro(new Date());
		
		pessoaDao.inserirCadastro(pessoa);
	}
	
	public Pessoa buscaPessoaPeloId(String paramId) {
		
		int id = Integer.parseInt(paramId);
		
		ArrayList<Pessoa> listaPessoa = new ArrayList<>();
		PessoaService pessoaService = new PessoaService();
		listaPessoa = pessoaService.chamaListaPessoaService();

		for (int x = 0; x < listaPessoa.size(); x++) {

			if (listaPessoa.get(x).getId() == id) {
				
				return listaPessoa.get(x);
			}
			
		}
		return null;
	}

	public void alterarCadastro(String id, String nome, String idade, String sexo) {
		
		Pessoa pessoa = new Pessoa();
		PessoaDao pesssoaDao = new PessoaDao();
		
		
		pessoa.setNome(nome);
		pessoa.setIdade(Integer.parseInt(idade));
		pessoa.setSexo(sexo);
		pessoa.setDataCadastro(new Date());
		pessoa.setId(Long.parseLong(id));
		
		pesssoaDao.editarCadastro(pessoa);
		
	}

	public void removeCadastro(String id) {
		
		PessoaDao pessoaDao = new PessoaDao();
		
		pessoaDao.deletarCadastro(Long.parseLong(id));
		
	}

}