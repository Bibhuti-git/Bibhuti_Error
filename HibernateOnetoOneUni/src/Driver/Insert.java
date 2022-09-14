package Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Teacher;
import entity.TeacherDetails;

public class Insert {
	// create session factory
	SessionFactory factory = new Configuration().configure("hobernate.cfg.xml").addAnnotatedClass(Teacher.class)
			.addAnnotatedClass(TeacherDetails.class).buildSessionFactory();

	// create session
	Session session= factory.getCurrentSession();
	try
	{
		// create the objects
		Teacher tempTeacher = new Teacher("Hasrhith", "Chodhry", "harsith@gl.com");
		TeacherDetails tempTeacherDetails = new TeacherDetails("chicago", "painting");
		// associate the objects
		tempTeacher.setTeacherDetails(tempTeacherDetails);
		// start transaction
		session.beginTransaction();

		// save the teacher
		session.save(tempTeacher);

		// commit transaction
		session.getTransaction().commit();

	}finally
	{
		factory.close();
	}
}}
