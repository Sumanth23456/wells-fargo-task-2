package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "Portfolio")
public class Portfolio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long portfolioId;

	@ManyToOne
	@JoinColumn(name = "clientId",nullable=false)
	private Client client;
	@Column(nullable = false)
	private LocalDate creationDate;

	public Long getPortfolioId() {
		return portfolioId;
	}

	public Portfolio() {
		
	}
	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}
	
	

	
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}




	public Portfolio(Client client, LocalDate creationDate) {
		super();
		this.client = client;
		this.creationDate = creationDate;
	}




	@OneToMany(
            mappedBy="portfolio",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
	private List<Security> security=new ArrayList<Security>();

	public void setSecurity(List<Security> security) {
		this.security = security;
	}
   
}

