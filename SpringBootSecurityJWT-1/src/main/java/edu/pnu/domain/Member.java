package edu.pnu.domain;

import javax.management.relation.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
	@Id
	private String username;
	private String Password;
	@Enumerated(EnumType.STRING)
	private Role role;
	private boolean enabled;
}
