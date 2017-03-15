package zad3;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Book {

	private String author;
	private String title;
	private String price;
	private ImageIcon cover;
	
	public Book(String author, String title, String price, ImageIcon cover) {
		this.author = author.trim();
		this.title = title.trim();
		this.price = price.trim();
		this.cover = new ImageIcon(cover.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getPrice() {
		return price;
	}
	
	public ImageIcon getCover() {
		return cover;
	}
	
	public String[] getProperties() {
		return new String[] {this.author, this.title, this.price};
	}
}
