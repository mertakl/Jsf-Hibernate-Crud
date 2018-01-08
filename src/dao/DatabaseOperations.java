package dao;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import entity.Student;
import utils.HibernateUtils;

@ManagedBean(name = "database")
public class DatabaseOperations {

	Session session = HibernateUtils.getSessionFactory().getCurrentSession();
	FacesContext context = FacesContext.getCurrentInstance();
	HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();

	public void addStudentInDb(Student studentObj) {

		try {

			session.beginTransaction();

			session.save(studentObj);

			System.out.println(
					"Student Record With Id: " + studentObj.getName() + " Is Successfully Created In Database");

		} catch (Exception exceptionObj) {

			exceptionObj.printStackTrace();

			try {
				// if fail
				response.sendRedirect("fail.xhtml");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} finally {

			session.getTransaction().commit();

			try {
				// if success
				response.sendRedirect("success.xhtml");
			} catch (IOException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}

	}

	public void deleteStudentInDb(int delStudentId) {

		try {

			session.beginTransaction();

			Student studId = (Student) session.load(Student.class, new Integer(delStudentId));

			session.delete(studId);

			System.out.println("Student Record With Id: " + delStudentId + " Is Successfully Deleted From Database");

			// XHTML Response Text

			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("deletedStudentId",
					delStudentId);

		} catch (Exception exceptionObj) {

			exceptionObj.printStackTrace();
			try {
				response.sendRedirect("fail.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} finally {

			session.getTransaction().commit();

			try {
				// if success
				response.sendRedirect("success.xhtml");
			} catch (IOException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}

	}

	public void updateStudentRecord(Student updateStudentObj) {

		try {

			session.beginTransaction();

			session.update(updateStudentObj);

			System.out.println(
					"Student Record With Id: " + updateStudentObj.getId() + " Is Successfully Updated In Database");

			
		} catch (Exception exceptionObj) {

			exceptionObj.printStackTrace();
			
			try {
				response.sendRedirect("fail.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} finally {

			session.getTransaction().commit();
			
			try {
				response.sendRedirect("success.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	

}
