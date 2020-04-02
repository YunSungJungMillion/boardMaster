package com.board.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Entity
@Table(name = "thread")
@Data
public class Thread implements Serializable   {
	
	private static final long serialVersionUID =1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name ="Title" , nullable = false)
	@Length(max = 25)
	private String Title;
	
	@Column(name = "Date", nullable = false )
	@CreationTimestamp
	private LocalDateTime Date; 
	
	@Column(nullable = false )
	@Length(max =250 )
	private String contents;
}
