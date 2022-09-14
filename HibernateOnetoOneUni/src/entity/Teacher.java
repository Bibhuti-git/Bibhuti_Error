package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name = "teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;
	@Column(name = "F_name")
	private String F_nmae;
	@Column(name = "L_name")
	private String L_name;
	@Column(name = "email")
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="teacher_detail_id")

	private TeacherDetails teacherDetails;

	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher( String f_nmae, String l_name, String email) {
	
		F_nmae = f_nmae;
		L_name = l_name;
		this.email = email;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getF_nmae() {
		return F_nmae;
	}

	public void setF_nmae(String f_nmae) {
		F_nmae = f_nmae;
	}

	public String getL_name() {
		return L_name;
	}

	public void setL_name(String l_name) {
		L_name = l_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Teacher [Id=" + Id + ", F_nmae=" + F_nmae + ", L_name=" + L_name + ", email=" + email + "]";
	}

	public void setTeacherDetails(TeacherDetails tempTeacherDetails) {
		// TODO Auto-generated method stub
		
	}

	
	}

}
