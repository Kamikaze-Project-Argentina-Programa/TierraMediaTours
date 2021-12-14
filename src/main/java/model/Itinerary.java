package model;

public class Itinerary {
	private Integer id;
	private Integer username;
	private String stringUsername;
	private Integer attraction;
	private String stringAttraction;
	private Integer cost;
	private Double duration;
	private Boolean promotion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUsername() {
		return username;
	}

	public void setUsername(Integer username) {
		this.username = username;
	}

	public Integer getAttraction() {
		return attraction;
	}

	public void setAttraction(Integer attraction) {
		this.attraction = attraction;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Boolean getPromotion() {
		return promotion;
	}

	public void setPromotion(Boolean promotion) {
		this.promotion = promotion;
	}
	

	public String getStringUsername() {
		return stringUsername;
	}

	public void setStringUsername(String stringUsername) {
		this.stringUsername = stringUsername;
	}

	public String getStringAttraction() {
		return stringAttraction;
	}

	public void setStringAttraction(String stringAttraction) {
		this.stringAttraction = stringAttraction;
	}

	@Override
	public String toString() {
		return "Itinerary [id=" + id + ", username=" + username + ", attraction=" + attraction + ", cost=" + cost
				+ ", duration=" + duration + ", promotion=" + promotion + "]";
	}

	public Itinerary(Integer id, Integer username, Integer attraction, Integer cost, Double duration, Boolean promotion) {
		super();
		this.id = id;
		this.username = username;
		this.attraction = attraction;
		this.cost = cost;
		this.duration = duration;
		this.promotion = promotion;
	}
	public Itinerary(Integer id, Integer username, String stringUsername, Integer attraction, String stringAttraction, Integer cost, Double duration, Boolean promotion) {
		super();
		this.id = id;
		this.username = username;
		this.stringUsername = stringUsername;
		this.attraction = attraction;
		this.stringAttraction = stringAttraction;
		this.cost = cost;
		this.duration = duration;
		this.promotion = promotion;
	}

}
