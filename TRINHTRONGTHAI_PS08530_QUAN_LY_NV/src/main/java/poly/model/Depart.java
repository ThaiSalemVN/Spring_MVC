package poly.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="Departs")
public class Depart {
	@Id
	private String id;
	private String name;

	
	@Override
	public String toString() {
		return this.name;
	}

	@OneToMany(mappedBy = "depart", fetch = FetchType.EAGER)
	private Collection<Staff> staff;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Staff> getStaff() {
		return staff;
	}

	public void setStaff(Collection<Staff> staff) {
		this.staff = staff;
	}

	
	
	
	
}
