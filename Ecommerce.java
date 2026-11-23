import java.util.*;

public class Ecommerce {
    
    class Website {
        private String websiteName;
        private String seller; 
        private String product;

        //constructor
        public Website (String websiteName, String seller, String product) {
            this.websiteName = websiteName;
            this.seller = seller;
            this.product = product;
        }
    }
        public static void main(String args[]) {

        //system allow seller to register their brands
        class Seller {
             String brandName;
             boolean isVerified; //is that brand verified

             //constructor: New sellers start as not verified (false) until approved by admin
             public Seller(String brandName) {
                this.brandName = brandName;
                this.isVerified = false;
             }
        } 
             class Product {
                String productName;
                double price;
                int stockQuantity;
                

               //constructor
               public Product(String productName, double price, int stockQuantity) {
               this.productName = productName;
               this.price = price;
               this.stockQuantity = stockQuantity;
               

             }
            } 
              class Customer {
                String customerName;
                boolean hasOrderedBefore; //for 15% discount on their first order

                public Customer(String customerName) {
                 this.customerName = customerName;
                 this.hasOrderedBefore = false;
                 System.out.println(hasOrderedBefore);

                }
              }    
                 class Shoppingcart {
                    List<Product> items = new ArrayList<>();
                    

                    public void addProduct(Product product) {
                        items.add(product);
                        System.out.println(product.productName +"added to cart");
                    }                    
                }
                 class Order {
                    Customer customer;
                    Shoppingcart cart;
                    double finalTotal;

                    public Order(Customer customer, Shoppingcart cart) {
                        this.customer = customer;
                        this.cart = cart;
                        
                    }
                    public void processCheckout() {
                        double subtotal = 0.0;

                        //calculate total price of items in cart
                        for (Product p : cart.items) {
                            subtotal += p.price;
                        }
                        //check if it's their first order for the 15% discount
                        if(!customer.hasOrderedBefore) {
                            System.out.println("First-order discount applied 15% off");
                            finalTotal = subtotal * 0.85;
                            customer.hasOrderedBefore = true; //so thet don't get it next time 
                            System.out.println(customer.hasOrderedBefore);
                        } else {
                            finalTotal = subtotal; //15% off first order
                        }
                        //subtract purchased quantity from inventory stock management  
                        for(Product p: cart.items) {
                       p.stockQuantity -=1; //Subtract one for each item purchased
                        System.out.println("stock updated for" + p.productName);
                        } 
                         System.out.println("checkout complete. Total amount: $" + finalTotal);
                           
                        }
                         class Review {
                            Customer customer;
                            Product product;
                            String comment;
                            int rating; //1 to 5 stars

                            public Review(Customer customer, Product product, String comment, int rating) {
                                this.customer = customer;
                                this.product = product;
                                this.comment = comment;
                                this.rating = rating;
                                System.out.println(customer.customerName + " reviewed" + product.productName + "with" + rating + "stars:" + comment);
                            }
                         }
                 }
                  Product p1 = new Product("Laptop", 500.0, 10);
                                Customer c1 = new Customer("Ali");
                                Shoppingcart cart = new Shoppingcart();
                                cart.addProduct(p1);
                                Order order = new Order(c1, cart);
                                order.processCheckout();
                    }
                    }   
                         


                 
                    
                
              
               

        
    


    

