package poly.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import poly.model.Record;

@Entity
@Table(name="Staffs")
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Boolean gender;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd") //MM/dd/yyyy
	private Date birthday;
	private String photo;
	private String email;
	private String phone;
	private Integer salary;
	private String notes;
	
	@ManyToOne
	@JoinColumn(name = "departid")
	private Depart depart;
	
	@OneToMany(mappedBy = "staff", fetch = FetchType.EAGER)
	private Collection<Record> record;


	@Override
	public String toString() {
		return name;
	}


	public String getName() {
		return name;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Boolean getGender() {
		return gender;
	}


	public void setGender(Boolean gender) {
		this.gender = gender;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}





	public Integer getSalary() {
		return salary;
	}


	public void setSalary(Integer salary) {
		this.salary = salary;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public Depart getDepart() {
		return depart;
	}


	public void setDepart(Depart depart) {
		this.depart = depart;
	}


	public Collection<Record> getRecord() {
		return record;
	}


	public void setRecord(Collection<Record> record) {
		this.record = record;
	}
	
	
	
}
