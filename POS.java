// Scenario: A customer bought products from a convenience store

// Customer -- DONE
// Product -- DONE
// Cashier -- DONE
// Basket or Cart -- DONE
// Transaction / Order-
// Receipt-DONE 
//

import java.util.ArrayList;

public class POS{
  public static void main(String[] args) {
    Food cracklings = new Food("123", "Cracklings", "oishi", 20.5, "07/19/2026", "Shrimp, Corn Starch");
    Food cheeseRing = new Food("124", "Cheese Ring", "oishi", 25.0, "07/19/2026", "Corn Starch");
    Accessory PhoneCase = new Accessory("125","Silicon case","Hands",150.0,"Samsung S23 ultra case","Men");
    Beverage Royal = new Beverage("126","RC Royal","RC",20.0,"500ml");
    Cashier cashier1 = new Cashier("Juliana", "21-0032");
    Cosmetic FacialCream = new Cosmetic("126","Micel Air","Nivea",250.0,"Face","Facial Cream","Cream");

    Basket myBasket = new Basket();

    myBasket.addItem(cracklings, 3);
    myBasket.addItem(cheeseRing, 5);
    myBasket.addItem(PhoneCase,1);
    myBasket.addItem(Royal,2);
    myBasket.addItem(FacialCream,3);
    myBasket.removeItem(Royal,2);

    Customer juan = new Customer("123", ValidID.SENIOR);

    Order myOrder = new Order(myBasket, juan,cashier1);
    PaymentMethod cash= new
    PaymentMethod(1000.0,myOrder);
    cash.Pay();

    Receipt receipt=new Receipt(myOrder, cashier1,cash);
    receipt.printreceipt();

  }
}

class Product {
  private String barcode;
  private String name;
  private String brand;
  private double price;

  Product(String barcode, String name, String brand, double price) {
    this.barcode = barcode;
    this.name = name;
    this.brand = brand;
    this.price = price;
  }

  String getBarcode() {
    return barcode;
  }

  String getName() {
    return name;
  }

  String getBrand() {
    return brand;
  }

  double getPrice() {
    return price;
  }
}

class Food extends Product {
  private String expirationDate;
  private String ingredients;

  Food(String barcode, String name, String brand, double price, String expirationDate, String ingredients) {
    super(barcode, name, brand, price);
    this.expirationDate = expirationDate;
    this.ingredients = ingredients;
  }

  String getExpirationDate() {
    return expirationDate;
  }

  String getIngredients() {
    return ingredients;
  }
}

class Accessory extends Product{
  private String Description;
  private String TargetGender;
  Accessory(String barcode, String name, String brand, double price,String Description,String TargetGender){
    super(barcode, name, brand, price);
    this.Description=Description;
    this.TargetGender=TargetGender;
  }
  String getDescription(){
    return Description;
  }
  String getTargetGender(){
    return TargetGender;
  }
}

class Beverage extends Product{
  private String Volume;
  Beverage(String barcode, String name, String brand, double price,String Volume){
    super(barcode, name, brand, price);
    this.Volume=Volume;
  }
  String getVolume(){
    return Volume;
  }
}

class Cosmetic extends Product{
  private String ApplicationArea;
  private String CosmeticType;
  private String Formulation;
  Cosmetic(String barcode, String name, String brand, double price,String ApplicationArea,String CosmeticType, String Formulation){
    super(barcode, name, brand, price);
    this.ApplicationArea=ApplicationArea;
    this.CosmeticType=CosmeticType;
    this.Formulation= Formulation;
  }
  String getApplicationArea(){
    return ApplicationArea;
  }
  String getCosmeticType(){
    return CosmeticType;
  }
  String getFormulation(){
    return Formulation;
  }
}

class BasketItem {
  private Product product;
  private int qty;

  BasketItem(Product product, int qty) {
    this.product = product;
    this.qty = qty;
  }

  Product getProduct() {
    return product;
  }

  int getQuantity() {
    return qty;
  }

  double getTotal() {
    return qty * product.getPrice();
  }
}

class Basket {
  private ArrayList<BasketItem> items;

  Basket() {
    this.items = new ArrayList<>();
  }

  void addItem(Product product, int qty) {
    this.items.add(new BasketItem(product, qty));
  }
  void removeItem(Product product,int qty){
    for (BasketItem item: items){
      if (item.getProduct().equals(product)){
        items.remove(item);

      }
    }
  }

  ArrayList<BasketItem> getItems(){
    return items;
  }
}

enum ValidID {
  SENIOR,
  PWD,
}

class Customer {
  String id;
  ValidID type;

  Customer() {
  }

  Customer(String id, ValidID type) {
    this.id = id;
    this.type = type;
  }

  boolean isSenior() {
    return id != null && type == ValidID.SENIOR;
  }
}


class Order {
  private Cashier cashier;
  private Basket basket;
  private Customer customer;

  private double subTotal=0.0;
  private double taxVal = 0.0;
  private double discountAmount = 0.0;
  private double totalAmountDue = 0.0;
  

  Order(Basket basket, Customer customer, Cashier cashier) {
    this.basket = basket;
    this.customer = customer;
    this.cashier= cashier;

    for (BasketItem items : basket.getItems()) {
      subTotal += items.getTotal();
    }
    
    

    double discount = 0.0;

    if (customer.isSenior()) {
      discount = 0.10;
    }
    
    if (subTotal>=500.0 && subTotal<=999.0){
      discount+= 0.05;
    }
    else if (subTotal >= 1000. && subTotal<=1499.0){
      discount += 0.10;
    }
    else if(subTotal >=1500.0){
      discount+= 0.15;
    }
  
    taxVal = subTotal * 0.12;
    double withTax = subTotal + taxVal;
    discountAmount = withTax * discount;
    totalAmountDue = withTax - discountAmount;
  }

  double getSubTotal() {
    return subTotal;
  }

  double getTax() {
    return taxVal;
  }

  double getTotalAmountDue() {
    return totalAmountDue;
  }

  double getDiscount() {
    return discountAmount;
  }
  ArrayList<BasketItem> getBasket(){
    return basket.getItems();
  }
}

class Cashier{
  private String CashierName;
  private String CashierID;
  
  Cashier(String CashierName, String CashierID){
    this.CashierName= CashierName;
    this.CashierID= CashierID;
  }
  
  String getCashierName(){
    return CashierName;
  }
  String getCashierID(){
    return CashierID;
  }
  
}

class Receipt{
  private String ReceiptNumber;
  private Order order;
  private Cashier cashier;
  private PaymentMethod Amount;
  
  Receipt(Order order,Cashier
  cashier,PaymentMethod Amount){
    this.order=order;
    this.cashier=cashier;
    this.Amount=Amount;
  }
  Order getOrder(){
    return order;
  }
  String getReceiptNumber(){
    return ReceiptNumber;
  }
   Cashier getcashier(){
     return cashier;
   }
  void printreceipt(){
    System.out.println("-----------------------DevMart-----------------------");
    System.out.printf("Cashier: %s  (%s)\n",cashier.getCashierName(),cashier.getCashierID());
    System.out.println("_____________________________________________________\nPRODUCT                   PRICE QUANTI.    TOTALPRICE");
    for (BasketItem item: order.getBasket()){
      System.out.printf(
          "%-20s %10.2f * %d  %15.2f\n",
          item.getProduct().getName(),
          item.getProduct().getPrice(),
          item.getQuantity(),
          item.getTotal());
    }
    System.out.println();
    System.out.printf("Sub Total: %.2f\n", order.getSubTotal());
    System.out.printf("Tax (12%%): %.2f\n", order.getTax());
    System.out.printf("Applied Discount: %.2f\n", order.getDiscount());
    System.out.printf("Cash Received:%.2f\n",Amount.getAmount());
    System.out.printf("Change:%.2f\n",Amount.getChange());
    System.out.println("_____________________________________________________");
    System.out.printf("Total Amount Due: %35.2f\n", order.getTotalAmountDue());
    System.out.println("_____________________________________________________");
    
    
    
  }
  
}

class PaymentMethod{
  private double Amount;
  private Order order;
  private double change;
  PaymentMethod(double Amount, Order order){
    this.Amount=Amount;
    this.order=order;
  }
  double getAmount(){
    return Amount;
  }
  
  void Pay(){
    double change=Amount-order.getTotalAmountDue();
    if (change < 0.0){
      System.out.println("Not enought money");
    }
    
  }
  double getChange(){
    return Amount-order.getTotalAmountDue();
  }
}

// Product
// -> Food - DONE
// -> Accessory -DONE
// -> Beverage- DONE
// -> Cosmetics - DONE
// -> Hygiene
// -> Digital