public class Product {
    private String prodID;
    private String prodName;
    private int quantity;
    private double price;

    public Product(){}
    public Product(String prodID, String prodName, int quantity, double price){
        this.prodID = prodID;
        this.prodName = prodName;
        if(quantity > 0){
            this.quantity = quantity;
        }else{
            this.quantity = 0;
        }
        if(price > 0.0) {
            this.price = price;
        }else{
            this.price = 0.0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override
    public String toString(){
        return "Product ID: " + prodID + "\nProduct Name: " + prodName +"\nQuantity: " + quantity + "\nPrice: " + price;
    }

    public String getProdID() {
        return prodID;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
