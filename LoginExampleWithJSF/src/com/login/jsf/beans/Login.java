package com.login.jsf.beans;

/**
 * @author V.Vishnu Priya on 07/02/2018.
 * This class is used as a java bean for username,password and validation error message.
 */
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import com.login.jsf.dao.LoginDAO;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;	
	private String pwd;
	private String msg;
	private String user;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * This method is used to validate the login functionality & will be when the login button is submitted from xhtml.
	 * @return login or admin string
	 * @throws ClassNotFoundException - Exception thrown when the database connectivity is not established.
	 */
	public String validateUsernamePassword() throws ClassNotFoundException {
		boolean valid = LoginDAO.validate(user, pwd);
		if (valid) {
			HttpSession session = SessionBean.getSession();
			session.setAttribute("username", user);
			return "admin";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "login";
		}
	}

	/**
	 * This method logs out the even during the invalidate HTTPSession.
	 * @return login
	 */
	public String logout() {
		HttpSession session = SessionBean.getSession();
		session.invalidate();
		return "login";
	}
}