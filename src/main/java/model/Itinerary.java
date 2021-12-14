package model;

public class Itinerary {
	private Integer id;
	private String username;
	private String attraction;
	private Integer cost;
	private Double duration;
	private Boolean promotion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAttraction() {
		return attraction;
	}

	public void setAttraction(String attraction) {
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

	@Override
	public String toString() {
		return "Itinerary [id=" + id + ", username=" + username + ", attraction=" + attraction + ", cost=" + cost
				+ ", duration=" + duration + ", promotion=" + promotion + "]";
	}

	public Itinerary(Integer id, String username, String attraction, Integer cost, Double duration, Boolean promotion) {
		super();
		this.id = id;
		this.username = username;
		this.attraction = attraction;
		this.cost = cost;
		this.duration = duration;
		this.promotion = promotion;
	}

}
