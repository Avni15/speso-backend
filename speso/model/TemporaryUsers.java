package appnivi.products.speso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "temporary_users")
public class TemporaryUsers extends BaseModel{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer Id;

	@Column(name = "otp", nullable = false)
	String otp;

	@Column(name = "name", nullable = false)
	String name;
	
	@Column(name = "email", nullable = false)
	String email;
	
	@Column(name = "password", nullable = false)
	String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
