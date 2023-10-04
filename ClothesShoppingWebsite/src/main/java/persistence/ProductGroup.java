package persistence;

public class ProductGroup {
	private Integer id;
	private String name;
	
	public ProductGroup() {
	}

	public ProductGroup(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "ProductGroup [id=" + id + ", name=" + name + "]";
	}
	
	
}
