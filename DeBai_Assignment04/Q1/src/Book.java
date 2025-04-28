class Book {
    private String title;
    private int copies;
    private int price;  // Changed from double to int

    public Book(String title, int copies, int price) {
        this.title = title;
        this.copies = copies;
        this.price = price;
    }
    
    public Book(String title, int copies) {
        this.title = title;
        this.copies = copies;
        this.price = 0;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public String toString(){
        return "("+title+","+copies+","+price+")";
    }
}