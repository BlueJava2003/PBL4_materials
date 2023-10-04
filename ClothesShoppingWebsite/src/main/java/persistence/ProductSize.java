package persistence;

public class ProductSize {
	private Integer id;
	private String description;
	
	public ProductSize() {
	}

	public ProductSize(Integer id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductSize [id=" + id + ", description=" + description + "]";
	}
}
