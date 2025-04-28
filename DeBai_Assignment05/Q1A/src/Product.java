class Product {
    private String id;
    private String name;
    private int quantity;
    
    public Product(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
    
    public Product(String id, int quantity) {
        this.id = id;
        this.quantity = quantity;
        this.name = "";
    }
    
    public Product() {
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString(){
        return "("+id+","+name+","+quantity+")";
    }
}