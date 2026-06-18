/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public abstract class Beverage {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Beverage() {
        this.id = "";
        this.name = "";
        this.price = 0.0;
        this.quantity = 0;
    }

    public Beverage(String id, String name, double price, int quantity) {
        setId(id);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }
    // get

    public String getId() {
        return id;
    }

    public String getName() {
        if(name == null || name.trim().isEmpty()){
            return "";
        }
        String[] words = name.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if(!w.isEmpty()){
                sb.append(Character.toUpperCase(w.charAt(0)));
                if(w.length() > 1){
                    sb.append(w.substring(1).toLowerCase());
                }
                sb.append(" ");
            }
        }
        return  sb.toString().trim();
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    // set

    public void setId(String id) {
        if( id != null && id.matches("^[a-zA-Z]{2}[0-9]{3}$")){
            this.id = id;
        }else{
            this.id = "TN000";
        }
    }

    public void setName(String name) {
        if( name != null && name.length() >= 5 && name.length() <= 50){
            this.name = name;
        }else{
            this.name = "new beverage";
        }
    }

    public void setPrice(double price) {
        if(price >= 1 && price <= 5000){
            this.price = price;
        }else{
            this.price = 1;
        }
    }

    public void setQuantity(int quantity) {
        if(price >= 1 && price <= 100){
            this.quantity = quantity;
        }else{
            this.quantity = 1;
        }
    }
    
    public abstract double subTotal();
    
    @Override
    public String toString() {
        return id + "," + getName() + "," 
                  + String.format(java.util.Locale.US, "%.3f", price) + "," 
                  + quantity + "," 
                  + String.format(java.util.Locale.US, "%.3f", subTotal());
    }
}
