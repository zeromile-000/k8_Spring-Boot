package com.rubypaper.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	private String title;
	@Column(updatable = false)
	private String writer;
	private String content;
	@Temporal(TemporalType.DATE)
	@Column(insertable=false, updatable=false, columnDefinition="date default (curdate())")
	@Builder.Default
	private Date createDate = new Date();
	@Column(insertable=false, updatable=true, columnDefinition="bigint default 0")
	@Builder.Default
	private Long cnt = 0L;
}
