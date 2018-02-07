package com.login.jsf.beans;

/**
 * @author V.Vishnu Priya on 07/02/2018.
 * This class uses session for each user logged through the getUserId method thereby associating a session id to a particular user id.
 */
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionBean {

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	/**
	 * This method gets the username based on the httpsession.
	 * @return username
	 */
	public static String getUserName() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session.getAttribute("username").toString();
	}

	/**
	 * This method gets the userid based on the httpsession.
	 * @return userid
	 */
	public static String getUserId() {
		HttpSession session = getSession();
		if (session != null)
			return (String) session.getAttribute("userid");
		else
			return null;
	}
}