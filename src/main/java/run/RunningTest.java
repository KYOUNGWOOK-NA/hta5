package run;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import util.DBUtil;
import model.domain.entity.Dept;
import model.domain.entity.Emp;

public class RunningTest {
	public static void main(String[] args) {
		EntityManager em = DBUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
/*		
		Dept d1 = new Dept("Dept_A");
		Dept d2 = new Dept("Dept_B");
		
		Emp e1 = new Emp();
		e1.setEname("nineveh");
		e1.setJob("job11");
		e1.setMgr(10);
		e1.setHiredate("2023.01.11");
		e1.setSal(111);
		e1.setComm(11);
		e1.setDept(d1);

		Emp e2 = new Emp();
		e2.setEname("eadalyn");
		e2.setJob("job22");
		e2.setMgr(20);
		e2.setHiredate("2022.02.22");
		e2.setSal(222);
		e2.setComm(22);
		e2.setDept(d1);
		
		d1.getEmps().add(e1);
		d1.getEmps().add(e2);
		
		em.persist(d1);
		em.persist(d2);
		em.persist(e1);
		em.persist(e2);
*/
		//TeamA에 소속된 선수들 이름만 출력
		//select 검색 코드로 개발
		Dept searchDept = em.find(Dept.class, 1l);
		List<Emp> all = searchDept.getEmps();
		for(Emp m : all) {
			System.out.println(m.getEname());
		}

		tx.commit();
		
		em.close();
	}
}
