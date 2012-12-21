/**
 * 
 */
package net.gosmarter.webcrawler;

/**
 * @author Leo
 *
 */
public class Item {

	private int id;
	private String name;
	private String link;
	private double price;
	private String imageUrl;
	private int liked;
	private int modelId;	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * @return the liked
	 */
	public int getLiked() {
		return liked;
	}
	/**
	 * @param liked the liked to set
	 */
	public void setLiked(int liked) {
		this.liked = liked;
	}
	/**
	 * @return the modelId
	 */
	public int getModelId() {
		return modelId;
	}
	/**
	 * @param modelId the modelId to set
	 */
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
}
