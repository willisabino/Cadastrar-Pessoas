package br.com.cadastrarpessoa.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastrarpessoa.model.Pessoa;
import br.com.cadastrarpessoa.service.PessoaService;


@WebServlet("/removePessoaServlet")
public class RemovePessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id =  request.getParameter("id");
		
		PessoaService pessoaService = new PessoaService();
		
		pessoaService.removeCadastro(id);
		
		response.sendRedirect("pessoaservlet");
		
	}

}
