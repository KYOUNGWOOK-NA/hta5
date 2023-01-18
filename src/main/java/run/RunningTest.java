package run;

import java.util.List;

import javax.persistence.[[A]];
import javax.persistence.[[B]];

import util.DBUtil;
import model.domain.entity.Dept;
import model.domain.entity.Emp;

public class RunningTest {
	public static void main(String[] args) {
		[[A]] em = DBUtil.get[[A]]();
		[[B]] tx = em.get[[B]]();
		tx.begin();
	
		[[C]] d1 = new Dept("Dept_A");
		[[C]] d2 = new Dept("Dept_B");
		
		Emp e1 = new Emp();
		e1.setEname("nineveh");
		e1.setJob("job11");
		e1.setMgr(10);
		e1.setHiredate("2023.01.11");
		e1.setSal(111);
		e1.setComm(11);
		e1.set[[C]](d1);

		Emp e2 = new Emp();
		e2.setEname("eadalyn");
		e2.setJob("job22");
		e2.setMgr(20);
		e2.setHiredate("2022.02.22");
		e2.setSal(222);
		e2.setComm(22);
		e2.set[[C]](d1);
		
		d1.getEmps().[[D]](e1);
		d1.getEmps().[[D]](e2);
		
		em.[[E]](d1);
		em.[[E]](d2);
		em.[[E]](e1);
		em.[[E]](e2);

		//Dept_A에 소속된 선수들 이름만 출력
		//select 검색 코드로 개발
		Dept searchDept = em.[[F]](Dept.class, 1l);
		List<Emp> all = searchDept.getEmps();
		for(Emp m : all) {
			System.out.println(m.getEname());
		}

		tx.commit();
		
		em.close();
	}
}

/*
  Q1. [[A]] ~ [[F]]에 들어갈 코드를 보기에서 골라 적절히 배치하시오.
  	* [[C]]의 경우 Model 패키지의 Dept, Emp 테이블을 참고하여 작성하세요.
    
    1. EntityTransaction
    2. persist
    3. Dept
    4. EntityManager
    5. find
    6. add
    
    
    
  Q2. JPA N+1 문제란 1:N 또는 N:1 관계를 가진 Entity를 조회할 때, 한 번만 조회하지 않고 N개 종류의 데이터 각각을 추가로 조회하게 되어서 총 N+1번 DB 조회를 하게 되는 문제입니다.
      이를 해결하기 위한 방법으로 옪지 않은 것은 무엇일까요? (단, 중복 데이터 관련 사항은 고려하지 않습니다. 가장 정답에 가까운 하나를 골라주세요.)

    A. Join Fetch
    B. EntityGraph
    C. BatchSize 지정 + 즉시 로딩
    D. fetchType.EAGER
  
  
  
  Q3. (1) Entity 생명주기 및 상태 채워넣기

    1) 비영속 : ___________한 상태

    2) 영속 : ___________한 상태
      f____

    3) 준영속 : ___________한 상태
      d____
      c____
      c____

    4) 삭제 : ___________한 상태


      (2) 해당 설명에 부합하는 키워드를 적으시오.
      
        a) Entity 외의 ___이 걸린 연관 Entity도 같이 SELECT 하여 모두 영속화된다, Lazy인 Entity를 참조하더라도 이미 영속성 컨텍스트에 포함되어 따로 쿼리가 실행되지 않고 N+1 문제가 해결된다.
        b) 연관 Entity에 ___을 걸어도 실제 쿼리에서 SELECT 하는 Entity는 오직 JPQL에서 조회하는 주체 Entity만 SELECT 해서 영속화한다.
	  a) ________
	  b) ________
  
*/
