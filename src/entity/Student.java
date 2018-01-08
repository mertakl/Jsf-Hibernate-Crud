package entity;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import dao.DatabaseOperations;

@Entity
@Table(name = "student")
@ManagedBean(name = "student")
public class Student {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "Name")
	private String name;
	@Column(name = "Department")
	private String department;
	public static DatabaseOperations dbObj;

	public Student() {

	}

	public Student(int id, String name, String department) {

		this.id = id;

		this.name = name;

		this.department = department;

	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void saveStudentRecord() {

		System.out.println("Calling saveStudentRecord() Method To Save Student Record");

		dbObj = new DatabaseOperations();

		dbObj.addStudentInDb(this);

	}

	public void deleteStudentRecord() {

		System.out.println("Calling deleteStudentRecord() Method To Delete Student Record");

		dbObj = new DatabaseOperations();

		dbObj.deleteStudentInDb(id);

	}

	public void updateStudentDetails() {

		System.out.println("Calling updateStudentDetails() Method To Update Student Record");

		dbObj = new DatabaseOperations();

		dbObj.updateStudentRecord(this);

	}
	
}
