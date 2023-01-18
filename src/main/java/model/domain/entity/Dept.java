package model.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
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

@Entity
public class Dept {
	@Id
	@GeneratedValue(generator = "dept_deptno_seq")
	@SequenceGenerator(name = "dept_deptno_seq", allocationSize = 1)
	private Long deptno;
	
	@NonNull
	@Column(nullable = false, length = 20)
	private String dname;
	
	@OneToMany(mappedBy = "dept")
	private List<Emp> emps = new ArrayList<Emp>();	
}