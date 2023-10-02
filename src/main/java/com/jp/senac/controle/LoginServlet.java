package com.jp.senac.controle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		if(usuario.equals("admin") && senha.equals("admin")) {
			request.setAttribute("usuario", usuario);
			
			
			request.getRequestDispatcher("listarAlunos.jsp").forward(request, response); 
		}else {
			request.setAttribute("mensagem", "usuario ou senha invalidos");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
