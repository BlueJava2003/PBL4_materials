package persistence;

public class Product {
	private Integer id;
	private String name;
	private String color;
	private String image;
	private Double salesPrice;
	private Double purchasePrice;
	private Integer amount;
	private String description;
	private ProductGroup productGroup;
	private ProductSize productSize;
	
	public Product() {
	}

	public Product(Integer id, String name, String color, String image, Double salesPrice, Double purchasePrice,
			Integer amount, String description, ProductGroup productGroup, ProductSize productSize) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.image = image;
		this.salesPrice = salesPrice;
		this.purchasePrice = purchasePrice;
		this.amount = amount;
		this.description = description;
		this.productGroup = productGroup;
		this.productSize = productSize;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductGroup getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(ProductGroup productGroup) {
		this.productGroup = productGroup;
	}

	public ProductSize getProductSize() {
		return productSize;
	}

	public void setProductSize(ProductSize productSize) {
		this.productSize = productSize;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", color=" + color + ", image=" + image + ", salesPrice="
				+ salesPrice + ", purchasePrice=" + purchasePrice + ", amount=" + amount + ", description="
				+ description + ", productGroup=" + productGroup + ", productSize=" + productSize + "]";
	}
	
	
}
