package model.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
//import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString

//@Builder

@Entity
public class Emp {
	@Id
	@GeneratedValue(generator = "emp_empno_seq")
	@SequenceGenerator(name = "emp_empno_seq", allocationSize = 1)
	private Long empno;
	
	@NonNull
	@Column(length = 20, nullable = false)
	private String ename;
	
	private String job;
	private int mgr;
	private String hiredate;
	private double sal;
	private double comm;
	
	@ManyToOne
	@JoinColumn(name = "dept_dpetno")
	private Dept dept;

	
}
