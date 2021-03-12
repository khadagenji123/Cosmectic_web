package model;

public class Image {
	private int id;
	private String link;
	private String description;
	private String title;
	private float cost;
	private float sale;
	private float old_prime;
	private String category;
	
	
	public Image(int id, String link, String title, float cost, float sale, float old_prime,String category) {
		super();
		this.id = id;
		this.link = link;
		this.title = title;
		this.cost = cost;
		this.sale = sale;
		this.old_prime = old_prime;
		this.category = category;
	}
	

	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}


	public float getSale() {
		return sale;
	}


	public void setSale(float sale) {
		this.sale = sale;
	}


	public float getOld_prime() {
		return old_prime;
	}


	public void setOld_prime(float old_prime) {
		this.old_prime = old_prime;
	}
	
	
	public Image(int id, String link, String title) {
		this.id = id;
		this.link = link;
		this.title = title;
	}
	
	
	public Image(int id, String link, String title, String description) {
		this.id = id;
		this.link = link;
		this.title = title;
		this.description = description;
	}

	public Image(int id, String link, String title, float cost, float sale, float old_prime) {
		super();
		this.id = id;
		this.link = link;
		this.title = title;
		this.cost = cost;
		this.sale = sale;
		this.old_prime = old_prime;
	}


	public Image(int id, String link, String title, String description,float cost, float sale,
			float old_prime) {
		this.id = id;
		this.link = link;
		this.title = title;
		this.description = description;
		this.cost = cost;
		this.sale = sale;
		this.old_prime = old_prime;
	}
	
	


	public Image(String link, String title, String description, float cost, float sale, float old_prime) {
		this.link = link;
		this.description = description;
		this.title = title;
		this.cost = cost;
		this.sale = sale;
		this.old_prime = old_prime;
	}
	
	public Image(String title) {	
		this.title = title;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String gettitle() {
		return title;
	}
	public void settitle(String title) {
		this.title = title;
	}
	
}
