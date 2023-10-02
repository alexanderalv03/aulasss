package com.jp.senac.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jp.senac.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class ConfirmarCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recuperando a sessao
		
		HttpSession session = request.getSession();
		
		// Recuperando os valores informados
		
		
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		String genero = request.getParameter("genero");
		String semestre = request.getParameter("semestre");
		
		// Recuperando a lista da sessão, caso nao exista cria 
		
		List<Aluno> listaAlunos = (List<Aluno>) session.getAttribute("listaAlunos");
		
		if(listaAlunos== null) {
			
			listaAlunos = new ArrayList<>(); // Criando a lista
			
		}
		
		// Guardar no objeto aluno
		
		Aluno aluno = new Aluno(nome, idade, semestre, genero);
		
		// Adicionando aluno na lista (insert)
		
		listaAlunos.add(aluno);
		
		session.setAttribute("listaAlunos", listaAlunos);
		
		request.setAttribute("aluno", aluno);
		
		// Encaminhar a requisiçao para o jsp
		
		request.getRequestDispatcher("detalharAlunos.jsp").forward(request, response);
		
		
		

	}

}
