package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;


import edu.pnu.domaim.Logdomain;

public interface LogRepository extends JpaRepository<Logdomain, Integer> {
	
}
