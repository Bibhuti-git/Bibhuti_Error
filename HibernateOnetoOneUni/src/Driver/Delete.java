package Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Teacher;
import entity.TeacherDetails;

public class Delete {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hobernate.cfg.xml").addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			int theTeacherId = 1;

			// start transaction
			session.beginTransaction();
			Teacher tempTeacher = session.get(Teacher.class, theTeacherId);
			if (tempTeacher != null) {
				System.out.println("teacher" + tempTeacher);

				// note: it will also delete the TeacherDetails data
				// as we have provided the CascadeType.All
				session.delete(tempTeacher);
			}
			// commit transaction
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
