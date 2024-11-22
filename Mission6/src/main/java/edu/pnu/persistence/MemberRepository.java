package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domaim.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
