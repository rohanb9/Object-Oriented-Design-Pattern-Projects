
public abstract class Mammal implements Animal {
	private int id;
	private String name;
	private int age;
	private String type;
	private String subType;
	private String notes;
	private String medicalCondition;
	private boolean readyForAdoption = false;
			
	public Mammal(int id, String name, int age, String type, String subType, String notes, String medicalCondition,
			boolean readyForAdoption) {
		//super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.type = type;
		this.subType = subType;
		this.notes = notes;
		this.medicalCondition = medicalCondition;
		this.readyForAdoption = readyForAdoption;
	}
	
	@Override
	public String toString() {
		return " Name= " + name + "\n Age= " + age + "\n Type= " + type + "\n Breed= " + subType
				+ "\n Notes= " + notes + "\n Medical Condition= " + medicalCondition + "\n Ready For Adoption= "
				+ readyForAdoption ;
	}
	
	public int getId() {
		return id;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getMedicalCondition() {
		return medicalCondition;
	}
	public void setMedicalCondition(String medicalCondition) {
		this.medicalCondition = medicalCondition;
	}
	public boolean isReadyForAdoption() {
		return readyForAdoption;
	}
	public void setReadyForAdoption(boolean readyForAdoption) {
		this.readyForAdoption = readyForAdoption;
	}
	
	
	
}
