public class ProductCommerce implements iProduct{
    Product products[];

    public ProductCommerce(){
        products = new Product[iProduct.max];
    }

    @Override
    public boolean addProduct(String id, String name, int qty, double price) {
        int length = products.length;

        if(length > iProduct.max){
            return false;
        }

        for(int i=0; i<length; i++){
            if(products[i].getProdID().equals(id)){
                return false;
            }
            products[i] = new Product(id, name, qty, price);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProduct(Product p) {
        String ID = p.getProdID();
        for(int i = 0; i < products.length; i++){

            if(ID.equals(products[i].getProdID())){

                products[i]=products[i+1];
                return true;
            }
        }
        return false;
    }

    @Override
    public int buyProduct(String id, int quantity) {
        for(int i=0; i<products.length; i++){
            if(id.equals(products[i].getProdID())){

                int qty = products[i].getQuantity();
                if(qty >= quantity){
                    qty -= quantity;
                    products[i].setQuantity(qty);
                    return 1;
                } else{
                    return 0;
                }
            }
        }
        return -1;
    }

    @Override
    public Product search(String id) {
        for(int i = 0; i<products.length; i++){
            if(id.equals(products[i].getProdID())){
                return products[i];
            }
        }
        return null;
    }

    @Override
    public void bulkOrder(Product[] p) {
        for(int i=0; i<products.length; i++){
            if(p[i].getProdID().equals(products[i].getProdID())){
                buyProduct(p[i].getProdID(), p[i].getQuantity());
            }
        }
    }
}
