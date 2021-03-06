package beans;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class LoginFilter
 */

@WebFilter(filterName = "LoginFilter", urlPatterns={"atendente/*", "medico/*", "ministerio/*"})
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	/*public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession sessao = req.getSession();
		if (sessao == null || sessao.getAttribute("loginBean") == null || 
		     ((LoginBean) sessao.getAttribute("loginBean")).getUsuarioLogado() == null) {
		    RequestDispatcher dis = request.getRequestDispatcher("/login.xhtml");
	  	    dis.forward(request, response);
		} else {
		    chain.doFilter(request, response);
		}
	}*/
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession sessao = req.getSession();
		if (sessao == null || sessao.getAttribute("loginBean") == null || isUsuarioValido(sessao)){
		    RequestDispatcher dis = request.getRequestDispatcher("/login.xhtml");
	  	    dis.forward(request, response);
		} else {
		    chain.doFilter(request, response);
		}

	}

	public boolean isUsuarioValido(HttpSession sessao){
		boolean retorno = false;
		if(((LoginBean) sessao.getAttribute("loginBean")).getUsuarioLogado() == null){
			retorno = true;
		} 
		return retorno;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
