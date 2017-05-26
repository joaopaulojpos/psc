package utilTestes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exemploServlet")
public class ExemploServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		  	 		 	
		 
		 String nome = request.getParameter("nome");
		 String endereco = request.getParameter("endereco");
		 String email = request.getParameter("email");
		 String dataEmTexto = request.getParameter("dataNascimento");
		 	
		 System.out.println(nome + "\n" + endereco + "\n" + email + "\n" + dataEmTexto);
	 } 

}
