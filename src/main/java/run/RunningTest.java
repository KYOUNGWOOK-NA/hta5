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
  Q. [[A]] ~ [[F]]에 들어갈 코드를 보기에서 골라 적절히 배치하시오.
  	* [[C]]의 경우 Model 패키지의 Dept, Emp 테이블을 참고하여 작성하세요.
    
    1. EntityTransaction
    2. persist
    3. Dept
    4. EntityManager
    5. find
    6. add
    
*/
