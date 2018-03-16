
public abstract class Dog extends Mammal {
	
	private String dogFeature;
	
	public Dog(int id, String name, int age, String type, String subType, String notes, String medicalCondition,
			boolean readyForAdoption) {
		super(id, name, age, type, subType, notes, medicalCondition, readyForAdoption);
		this.setDogFeature("");
	}

	public String getDogFeature() {
		return dogFeature;
	}

	public void setDogFeature(String dogFeature) {
		this.dogFeature = dogFeature;
	}

}
