package model;



public class AttractionTypes {

	private Integer id;
	private String type;
	private Boolean isActive;


	public AttractionTypes(Integer id, String type, Boolean isActive) {
		super();
		this.id = id;
		this.type = type;
		this.isActive = isActive;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "AttractionTypes [id=" + id + ", type=" + type + ", isActive=" + isActive + "]";
	}

}
