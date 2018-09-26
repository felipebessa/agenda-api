package br.com.bessacorp.agendaapi.model;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "contatos")
public class Contato {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;

	private String alias;
	
	private String phone_number;
		
	private String email;
		
	//private String birthday;
	
	@NotNull
    @Column(name = "posted_at", updatable = false)
	@CreationTimestamp
    private LocalDateTime postedAt = LocalDateTime.now();

    @NotNull
    @Column(name = "last_updated_at")
    @UpdateTimestamp
    private LocalDateTime lastUpdatedAt = LocalDateTime.now();
	
	public Contato () {
		
	}
	
	public Contato(String name, Integer id) {
		this.name = name;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDateTime getPostedAt() {
		return postedAt;
	}
	
	public LocalDateTime getLastUpdatedAt() {
		return lastUpdatedAt;
	}
	
}
