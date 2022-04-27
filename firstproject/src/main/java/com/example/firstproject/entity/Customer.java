package com.example.firstproject.entity;

import java.util.Date;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;

import lombok.*;

@Entity
@Data
@ToString
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
    @Column
	private String name;
	
    @Column
	private Long age;
	
    @Column
	private String location;
	
	@CreationTimestamp
	@Column(name="created_at", nullable=false, updatable=false)
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt;
	
}