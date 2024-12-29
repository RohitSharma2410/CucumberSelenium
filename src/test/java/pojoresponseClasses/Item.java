package pojoresponseClasses;

public class Item {
	private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public products[] getProducts() {
		return products;
	}

	public void setProducts(products[] products) {
		this.products = products;
	}

	private int skip;
	private int limit;
	private products[] products;

	class products {
		private product[] product;

		public product[] getProduct() {
			return product;
		}

		public void setProduct(product[] product) {
			this.product = product;
		}

		class product {
			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
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

			public float getId() {
				return id;
			}

			public void setId(float id) {
				this.id = id;
			}

			public float getPrice() {
				return price;
			}

			public void setPrice(float price) {
				this.price = price;
			}

			public float getDiscountPercentage() {
				return discountPercentage;
			}

			public void setDiscountPercentage(float discountPercentage) {
				this.discountPercentage = discountPercentage;
			}

			public float getStock() {
				return stock;
			}

			public void setStock(float stock) {
				this.stock = stock;
			}

			public float getRating() {
				return rating;
			}

			public void setRating(float rating) {
				this.rating = rating;
			}

			public float getWeight() {
				return weight;
			}

			public void setWeight(float weight) {
				this.weight = weight;
			}

			public String getBrand() {
				return brand;
			}

			public void setBrand(String brand) {
				this.brand = brand;
			}

			public String getSku() {
				return sku;
			}

			public void setSku(String sku) {
				this.sku = sku;
			}

			public String getWarrantyInformation() {
				return warrantyInformation;
			}

			public void setWarrantyInformation(String warrantyInformation) {
				this.warrantyInformation = warrantyInformation;
			}

			public String getShippingInformation() {
				return shippingInformation;
			}

			public void setShippingInformation(String shippingInformation) {
				this.shippingInformation = shippingInformation;
			}

			public String getAvailabilityStatus() {
				return availabilityStatus;
			}

			public void setAvailabilityStatus(String availabilityStatus) {
				this.availabilityStatus = availabilityStatus;
			}

			public String getReturnPolicy() {
				return returnPolicy;
			}

			public void setReturnPolicy(String returnPolicy) {
				this.returnPolicy = returnPolicy;
			}

			public int getMinumumOrderQuantity() {
				return minumumOrderQuantity;
			}

			public void setMinumumOrderQuantity(int minumumOrderQuantity) {
				this.minumumOrderQuantity = minumumOrderQuantity;
			}

			public String getThumbnail() {
				return thumbnail;
			}

			public void setThumbnail(String thumbnail) {
				this.thumbnail = thumbnail;
			}

			public dimensions getDimension() {
				return dimension;
			}

			public void setDimension(dimensions dimension) {
				this.dimension = dimension;
			}

			public String[] getImages() {
				return images;
			}

			public void setImages(String[] images) {
				this.images = images;
			}

			public meta[] getMeta() {
				return meta;
			}

			public void setMeta(meta[] meta) {
				this.meta = meta;
			}

			private String title;
			private String category;
			private String description;
			private float id;
			private float price;
			private float discountPercentage;
			private float stock;
			private float rating;
			private float weight;
			private String brand;
			private String sku;
			private String warrantyInformation;
			private String shippingInformation;
			private String availabilityStatus;
			private String returnPolicy;
			private int minumumOrderQuantity;
			private String thumbnail;

			public String[] getTags() {
				return tags;
			}

			public void setTags(String[] tags) {
				this.tags = tags;
			}

			public reviews[] getReview() {
				return review;
			}

			public void setReview(reviews[] review) {
				this.review = review;
			}

			private String[] tags;
			private dimensions dimension;
			private reviews[] review;
			private String[] images;
			private meta[] meta;

			class dimensions {
				public float getWidth() {
					return width;
				}

				public void setWidth(float width) {
					this.width = width;
				}

				public float getHeight() {
					return height;
				}

				public void setHeight(float height) {
					this.height = height;
				}

				public float getDepth() {
					return depth;
				}

				public void setDepth(float depth) {
					this.depth = depth;
				}

				private float width;
				private float height;
				private float depth;

			}

			class reviews {
				public String getReviewerName() {
					return reviewerName;
				}

				public void setReviewerName(String reviewerName) {
					this.reviewerName = reviewerName;
				}

				public String getRevewierEmail() {
					return revewierEmail;
				}

				public void setRevewierEmail(String revewierEmail) {
					this.revewierEmail = revewierEmail;
				}

				public String getDate() {
					return date;
				}

				public void setDate(String date) {
					this.date = date;
				}

				public String getComment() {
					return comment;
				}

				public void setComment(String comment) {
					this.comment = comment;
				}

				public int getRating() {
					return rating;
				}

				public void setRating(int rating) {
					this.rating = rating;
				}

				private String reviewerName;
				private String revewierEmail;
				private String date;
				private String comment;
				private int rating;
			}

			class meta {
				public String getCreatedAt() {
					return createdAt;
				}

				public void setCreatedAt(String createdAt) {
					this.createdAt = createdAt;
				}

				public String getUpdatedAt() {
					return updatedAt;
				}

				public void setUpdatedAt(String updatedAt) {
					this.updatedAt = updatedAt;
				}

				public String getBarcode() {
					return barcode;
				}

				public void setBarcode(String barcode) {
					this.barcode = barcode;
				}

				public String getQrCode() {
					return qrCode;
				}

				public void setQrCode(String qrCode) {
					this.qrCode = qrCode;
				}

				private String createdAt;
				private String updatedAt;
				private String barcode;
				private String qrCode;

			}
		}
	}

}
