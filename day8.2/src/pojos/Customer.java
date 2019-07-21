package pojos;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="my_customers")
public class Customer {
	private Integer id;
	private double regAmount;
	private String email,name,password;
	private Date regDate;
	private String role;
	public Customer() {
		System.out.println("in cnstr of "+getClass().getName());
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

@Column(name="deposit_amt")
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="reg_date")
	@Temporal(TemporalType.DATE) //java.util.Date / Calendar / GregorianCalendar
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", regAmount=" + regAmount + ", email=" + email + ", name=" + name + ", password="
				+ password + ", regDate=" + regDate + ", role=" + role + "]";
	}
	

}
