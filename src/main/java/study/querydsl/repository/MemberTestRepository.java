package study.querydsl.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import static study.querydsl.entity.QMember.*;

import study.querydsl.entity.Member;
import study.querydsl.repository.support.Querydsl4RepositorySupport;

@Repository
public class MemberTestRepository extends Querydsl4RepositorySupport{

	public MemberTestRepository() {
		super(Member.class);
	}
	
	public List<Member> basicSelect() {
		return select(member)
				.from(member)
				.fetch();
	}
	
	public List<Member> basicSelectFrom() {
		return selectFrom(member)
				.fetch();
	}
}
