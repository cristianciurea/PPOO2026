package ase.course4.collections;

public class HumanBeing extends Identity implements Comparable<HumanBeing>, Cloneable {

	private String firstName, lastName;

	public HumanBeing()
	{
		super();
		firstName = "prenume";
		lastName = "nume";
	}
	
	public HumanBeing(String id, String firstName, String lastName) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int compareTo(HumanBeing n) {
		// TODO Auto-generated method stub
		int lastCmp = lastName.compareTo(n.lastName);
		if (lastCmp==0)
			lastCmp = firstName.compareTo(n.firstName);
		return lastCmp;
		//return(lastCmp==0 ? firstName.compareTo(n.firstName):lastCmp);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getId()+ " "+ this.firstName + " " + this.lastName;
	}

	@Override
	public void sayMyName(String name) {
		// TODO Auto-generated method stub
		System.out.println("Your name is: "+name);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		HumanBeing n = (HumanBeing)obj;
		return n.lastName.equals(lastName) && n.firstName.equals(firstName);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 31*firstName.hashCode() + lastName.hashCode();
	}
	
	/*@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Name n = new Name(this.getId(), this.firstName, this.lastName);
		return n;
	}*/
	
	@Override
	protected HumanBeing clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (HumanBeing)super.clone();
	}
}
