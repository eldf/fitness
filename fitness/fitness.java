package fitness;

public class fitness {
	
	private Double distance;
	private Double calories;
	private String start_time;
	private String last_updated;
	private String activity_category;
	
	
	public fitness() {
		super();
		// TODO Auto-generated constructor stub
	}
	public fitness(Double distance, Double calories, String start_time, String last_updated, String activity_category) {
		super();
		this.distance = distance;
		this.calories = calories;
		this.start_time = start_time;
		this.last_updated = last_updated;
		this.activity_category = activity_category;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Double getCalories() {
		return calories;
	}
	public void setCalories(Double calories) {
		this.calories = calories;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}
	public String getActivity_category() {
		return activity_category;
	}
	public void setActivity_category(String activity_category) {
		this.activity_category = activity_category;
	}
	
	
	
  	

}
