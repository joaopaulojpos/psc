package utilTestes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fiat")
public class LeandroTesteServ extends HttpServlet{
	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //String nome = request.getParameter("nome"); 	 
		 PrintWriter out = response.getWriter();
		 
		 String nome = request.getParameter("nome");
		 String endereco = request.getParameter("endereco");
		 String email = request.getParameter("email");
		 String dataEmTexto = request.getParameter("dataNascimento");
		 Calendar dataNascimento = null;	
		 System.out.println(nome + "\n" + endereco + "\n" + email + "\n" + dataEmTexto);
	 } 

}
