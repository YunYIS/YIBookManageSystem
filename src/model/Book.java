package model;
/**
 * 书籍实体类
 * @author 张云天
 *
 */
public class Book {
	
	private int no;
	private String name;
	private String author;
	private String publicationDate;
	private String country;
	private int pages;
	private float price;
	private String summary;
	private String borrow; //借阅情况（默认值为"无", 若该书籍已被借阅，则为借阅该书的用户名）
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getBorrow() {
		return borrow;
	}
	public void setBorrow(String borrow) {
		this.borrow = borrow;
	}
	
	
}
