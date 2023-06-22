package com.wellsfargo.counselor.entity;
import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long clientId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private long phone;
    @Column(nullable = false)
    private String email;
    @ManyToOne
    @JoinColumn(name="advisorId",nullable=false)
    private Advisor advisor;
   
	public Client(String firstName, String lastName, String address, long phone, String email, Advisor advisor) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.advisor = advisor;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	public long getClientId() {
		return clientId;
	}
	@OneToMany(
            mappedBy="client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
	private List<Portfolio> portfolio=new ArrayList<Portfolio>();

	

	public void setPortfolio(List<Portfolio> portfolio) {
		this.portfolio = portfolio;
	}
	
    
}

