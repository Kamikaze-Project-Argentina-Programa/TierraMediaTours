package model;

import java.util.ArrayList;
import java.util.List;

public class Itinerary {
	private Integer id;
	private User user;
	private Integer userId;
	private List<Attraction> attractions = new ArrayList<Attraction>();
	private Integer cost;
	private Double duration;
	private Boolean promotion;

	public Itinerary(Integer id, User user,Integer cost, Double duration,
			Boolean promotion) {
		super();
		this.id = id;
		this.user = user;
		this.cost = cost;
		this.duration = duration;
		this.promotion = promotion;
	}
	
	public Itinerary(Integer id, Integer userId,Integer cost, Double duration,
			Boolean promotion) {
		super();
		this.id = id;
		this.userId = userId;
		this.cost = cost;
		this.duration = duration;
		this.promotion = promotion;
	}

	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Attraction> getAttractions() {
		return attractions;
	}

	public void setAttractions(List<Attraction> attractions) {
		this.attractions = attractions;
	}

	@Override
	public String toString() {
		return "Itinerary [id=" + id + ", user=" + user + ", attractions=" + attractions + ", cost=" + cost
				+ ", duration=" + duration + ", promotion=" + promotion + "]";
	}


}
