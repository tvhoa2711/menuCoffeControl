/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class Coffee extends Beverage {
    private int expire;
    private String type;

    public Coffee() {
        super();
        this.type = "";
        this.expire = 0;
    }

    public Coffee( String id, String name, double price, int quantity, String type, int expire){
        super(id, name, price, quantity);
        setType(type);
        setExpire(expire);
    }
    //get

    public int getExpire() {
        return expire;
    }

    public String getType() {
        if(type == null || type.isEmpty()){
            return "";
        }
        return Character.toUpperCase(type.charAt(0)) + type.substring(1).toLowerCase();
    }
    // set

    public void setExpire(int expire) {
        if(expire >= 1 && expire <= 180){
            this.expire = expire;
        }else{
            this.expire = 180;
        }
    }

    public void setType(String type) {
        if(type != null &&
           (type.equalsIgnoreCase("special") ||
            type.equalsIgnoreCase("high") ||
            type.equalsIgnoreCase("medium") ||
            type.equalsIgnoreCase("low"))){
            this.type = type.toLowerCase();
        }else{
            this.type = "medium";
        }
    }
    
    @Override
    public double subTotal() {
        double rate = 1.0;
        String typeLower = type != null ? type.toLowerCase() :  "";
        String idUpper = getId() != null ? getId().toUpperCase() : "";
        
        if(typeLower.equals("specical") || idUpper.startsWith("DB")){
            rate = 1.2;
        }else if (typeLower.equals("high") || idUpper.startsWith("HC")){
            rate = 1.1;
        }else if (typeLower.equals("medium") && expire <= 30){
            rate = 0.5;
        }
        
        return getPrice() * getQuantity() * rate;
    }
    
    @Override
    public String toString() {
        return getId() + "," + getName() 
                       + "," + getType() + "," 
                       + expire + "," 
                       + String.format(java.util.Locale.US, "%.3f", getPrice()) + "," 
                       + getQuantity() + "," 
                       + String.format(java.util.Locale.US, "%.3f", subTotal());
    }

}
