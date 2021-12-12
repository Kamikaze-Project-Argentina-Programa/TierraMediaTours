package model;

import java.util.HashMap;
import java.util.Map;

public class Promotion {

	private Integer id;
	private String name;
	private Integer cost;
	private String attraction1;
	private Integer capacity1;
	private String attraction2;
	private Integer capacity2;
	private String attraction3;
	private Integer capacity3;
	private String image;
	private Boolean isActive;
	private Double duration;
	private Map<String, String> errors;

	public Promotion(Integer id, String name, Integer cost, String attraction1, Integer capacity1, 
			String attraction2, Integer capacity2, String attraction3, Integer capacity3,
			String image, Boolean isActive, Double duration) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.attraction1 = attraction1;
		this.capacity1 = capacity1;
		this.attraction2 = attraction2;
		this.capacity2 = capacity2;
		this.attraction3 = attraction3;
		this.capacity3 = capacity3;
		this.image = image;
		this.isActive = isActive;
		this.duration = duration;
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}

	public void validate() {
		errors = new HashMap<String, String>();

		if (cost <= 0) {
			errors.put("cost", "Debe ser positivo");
		}
		if (duration <= 0) {
			errors.put("duration", "Debe ser positivo");
		}
		if (capacity1 <= 0) {
			errors.put("capacity", "Debe ser positivo");
		}
		if (capacity2 <= 0) {
			errors.put("capacity", "Debe ser positivo");
		}
		if (capacity3 <= 0) {
			errors.put("capacity", "Debe ser positivo");
		}
	}

	public String getAttraction1() {
		return attraction1;
	}

	public void setAttraction1(String attraction1) {
		this.attraction1 = attraction1;
	}

	public String getAttraction2() {
		return attraction2;
	}

	public void setAttraction2(String attraction2) {
		this.attraction2 = attraction2;
	}

	public String getAttraction3() {
		return attraction3;
	}

	public void setAttraction3(String attraction3) {
		this.attraction3 = attraction3;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}


	public Integer getCapacity1() {
		return capacity1;
	}

	public void setCapacity1(Integer capacity1) {
		this.capacity1 = capacity1;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean tienePromotion() {
		return !this.attraction3.equals("N");
	}
	
	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Promotion [id=" + id + ", name=" + name + ", cost=" + cost + ", attraction1=" + attraction1
				+ ", attraction2=" + attraction2 + ", attraction3=" + attraction3 + ", image=" + image + ", duration=" + duration +"]";
	}

	public boolean canHost(int i) {
		return capacity1 >= i;
	}

	public void host(int i) {
		this.capacity1 -= i;
		this.capacity2 -= i;
		this.capacity3 -= i;
	}

}