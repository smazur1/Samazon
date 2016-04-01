package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SAMAZONUSER database table.
 * 
 */
@Entity
@NamedQuery(name="Samazonuser.findAll", query="SELECT s FROM Samazonuser s")
public class Samazonuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userid;

	private String username;

	private String userpassword;

	public Samazonuser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

}