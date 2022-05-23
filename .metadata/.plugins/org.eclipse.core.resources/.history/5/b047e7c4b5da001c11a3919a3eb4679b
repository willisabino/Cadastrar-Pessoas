package br.com.cadastrarpessoa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.cadastrarpessoa.factory.ConnectionFactory;
import br.com.cadastrarpessoa.model.Pessoa;

public class PessoaDao {

	public void inserirCadastro(Pessoa pessoa) {
		
		String sql = "INSERT INTO tb_ficha(nome, idade, sexo, dataCadastro, tb_sexo) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, pessoa.getNome());
			pstm.setInt(2, pessoa.getIdade());
			pstm.setString(3, pessoa.getSexo());
			pstm.setDate(4, new Date(pessoa.getDataCadastro().getTime()));
			pstm.setString(5, pessoa.getSexo());
			
			pstm.execute();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			try{
				if(pstm!=null){
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


	public ArrayList<Pessoa> chamaListaPessoas(){
		
		String sql = "SELECT * FROM tb_ficha JOIN tb_sexo ON tb_ficha.tb_sexo = tb_sexo.id ORDER BY tb_ficha.id";
		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery(); 
			
			while(rset.next()) {
				
				Pessoa pessoa = new Pessoa();
				
				pessoa.setId(rset.getInt("id"));
				pessoa.setNome(rset.getString("nome"));
				pessoa.setIdade(rset.getInt("idade"));
				pessoa.setSexo(rset.getString("tb_sexo.sexo"));
				pessoa.setDataCadastro(rset.getDate("dataCadastro"));
				pessoas.add(pessoa);
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			try {
				if(rset != null) {
					rset.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace(); 
			}
		}
		
		return pessoas;
	}


	public void editarCadastro(Pessoa pessoa) {
		
		String sql = "UPDATE tb_ficha SET nome = ?, idade = ?, sexo = ?, dataCadastro = ? "+
		"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, pessoa.getNome());
			pstm.setInt(2, pessoa.getIdade());
			pstm.setString(3, pessoa.getSexo());
			pstm.setDate(4, new Date(pessoa.getDataCadastro().getTime()));
			
			pstm.setLong(5, pessoa.getId());
			
			pstm.execute();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	
	public void deletarCadastro(long id) {
		
		String sql = "DELETE FROM tb_ficha WHERE id = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setLong(1, id);
			
			pstm.execute();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				
				if(pstm != null) {
					
					pstm.close();
					
				}
				if(conn != null) {
					conn.close();
				}
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
		}
	}

	
	public ArrayList<Pessoa> buscaPeloId(long id){
		
		String sql = "SELECT * FROM tb_ficha JOIN tb_sexo ON tb_ficha.tb_sexo = tb_sexo.id WHERE tb_ficha.id = ?";
		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setLong(1, id);
			
			rset = pstm.executeQuery(); 
			
			//pstm.execute();
			System.out.println("Fora do laço");
			while(rset.next()) {
				
				Pessoa pessoa = new Pessoa();
				
				pessoa.setId(rset.getLong("id"));
				pessoa.setNome(rset.getString("nome"));
				pessoa.setIdade(rset.getInt("idade"));
				pessoa.setSexo(rset.getString("tb_sexo.sexo"));
				pessoa.setDataCadastro(rset.getDate("dataCadastro"));
				pessoas.add(pessoa);
				System.out.println(pessoas);
				System.out.println("Dentro do laço");
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			try {
				if(rset != null) {
					rset.close();
				}
				
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace(); 
			}
		}
		
		return pessoas;
	}
}