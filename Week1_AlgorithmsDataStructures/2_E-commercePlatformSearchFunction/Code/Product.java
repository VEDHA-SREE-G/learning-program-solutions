import java.util.*;
public class Product{
    int productId;
    String  productName;
    String category;
    public Product(int productId,String productName,String category){
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
    public Product() {}
    public void linearSearch(List<Product> products, String keyProduct){
        int size = products.size();
        boolean found = false;
        for(int i=0; i<size; i++){
            if(keyProduct.equals(products.get(i).productName)){
                System.out.println("Item Found : id-"+ products.get(i).productId);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Item not Found");
        }
    }
    public void binarySearch(List<Product> products,String keyProduct){
        int size = products.size();
        int start = 0, end = size - 1, mid;
        boolean found = false;
        while(start <= end){
            mid = (start + end)/2;
            if(products.get(mid).productName.equals(keyProduct)){
                System.out.println("Item Found : id-"+ products.get(mid).productId);
                found = true;
                break;
            }
            else if(products.get(mid).productName.compareTo(keyProduct) < 0){
                start = mid + 1;
            }
            else end = mid - 1;
        }
        if(!found)  System.out.println("Item not Found");
    }
    public static void main(String args[]){
        System.out.println("Enter ProductDetails To Store: ");
        List<Product> products = new ArrayList<>();
        Scanner read = new Scanner(System.in);
        int index = 0;
        System.out.print("Enter ProductName or (exit): ");
        String productName = read.nextLine();
        String category;
        while(!productName.equals("exit")){
            System.out.print("Enter Category: ");
            category = read.nextLine();
            products.add(new Product(++index, productName, category));
            System.out.print("Enter ProductName or (exit): ");
            productName = read.nextLine();
        }
        Product obj = new Product();
        System.out.print("Enter Product To Search: ");
        String searchProduct = read.nextLine();
        System.out.println("Performing Linear Search");
        obj.linearSearch(products,searchProduct);
        System.out.println("Performing Binary Search");
        products.sort((p1,p2) -> p1.productName.compareTo(p2.productName));
        obj.binarySearch(products, searchProduct);
    }
}