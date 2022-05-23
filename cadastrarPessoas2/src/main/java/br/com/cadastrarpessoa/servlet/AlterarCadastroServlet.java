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


@WebServlet("/alterarCadastro")
public class AlterarCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id =  request.getParameter("id");
		
		ArrayList<Pessoa> cadastro = new ArrayList<>();
		PessoaService pessoaService = new PessoaService();
		ArrayList<Pessoa> listaPessoa = new ArrayList<>();
		
		
		cadastro = pessoaService.buscaPessoaPeloId(id);
		System.out.println("Servlet " + cadastro);
		
		listaPessoa = pessoaService.chamaListaPessoaService();
		
		request.setAttribute("cadastro", cadastro);
		request.setAttribute("listaPessoa", listaPessoa);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
