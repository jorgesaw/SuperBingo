package ar.com.jorgesaw.dto;

public class UsuarioLog {

	private Long idUsuarioLog;
	private String username;
	private String password;
	private TipoUsuario userTipo;
	
	public UsuarioLog() { }
	
	public UsuarioLog(String username, String password) {
		this.username = username;
		this.password = password;
	}
	/**
	 * @return the idUsuarioLog
	 */
	protected Long getIdUsuarioLog() {
		return idUsuarioLog;
	}
	/**
	 * @param idUsuarioLog the idUsuarioLog to set
	 */
	protected void setIdUsuarioLog(Long idUsuarioLog) {
		this.idUsuarioLog = idUsuarioLog;
	}
	/**
	 * @return the username
	 */
	protected String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	protected void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	protected String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	protected void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the userTipo
	 */
	protected TipoUsuario getUserTipo() {
		return userTipo;
	}
	/**
	 * @param userTipo the userTipo to set
	 */
	protected void setUserTipo(TipoUsuario userTipo) {
		this.userTipo = userTipo;
	}
	
	public String toString() {
		final StringBuilder cadena = new StringBuilder();
		cadena.append(username); cadena .append(" - ");
		cadena.append(userTipo.getDescTipoUsuario());
		return cadena.toString();
	}

}
