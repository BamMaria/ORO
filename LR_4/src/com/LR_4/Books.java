public class Books {
    private int bookID;
    private String title;
    private int price;
    private int authorID;

    public Books() {
    }

    public Books(int bookID, String title, int price, int authorID) {
        this.bookID = bookID;
        this.title = title;
        this.price = price;
        this.authorID = authorID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setAuthorID(int author) {
        this.authorID = authorID;
    }

    public int getAuthorID() {
        return authorID;
    }

    @Override
    public String toString() {
        return "ID книги: " + bookID + ", название:  " + title + ", цена: " + price +" ";
    }

}