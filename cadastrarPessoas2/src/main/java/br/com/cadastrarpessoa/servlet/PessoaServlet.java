package br.com.cadastrarpessoa.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastrarpessoa.model.Pessoa;
import br.com.cadastrarpessoa.service.PessoaService;

/**
 * Servlet implementation class PessoaServlet
 */
@WebServlet("/pessoaservlet")
public class PessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PessoaService pessoaService = new PessoaService();
		ArrayList<Pessoa> listaPessoa = new ArrayList<>();
		
		listaPessoa = pessoaService.chamaListaPessoaService();
		
		request.setAttribute("listaPessoa", listaPessoa);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		String id =  request.getParameter("id");
		String nome =  request.getParameter("nome");
		String idade =  request.getParameter("idade");
		String sexo =  request.getParameter("sexo");
		String acao =  request.getParameter("acao");
		
		PessoaService pessoaService = new PessoaService();

		if(acao.equals("Inserir")) {
			
			pessoaService.inserirPessoas(nome, idade, sexo);
			
			response.sendRedirect("pessoaservlet");
			
		}else if(acao.equals("Alterar")) {
			
			pessoaService.alterarCadastro(id, nome, idade, sexo);
			
			response.sendRedirect("pessoaservlet");
			
		}else if(acao.equals("Limpar")) {
			
			response.sendRedirect("pessoaservlet");
			
		}

	}
}
