package bean;

public enum Ingredient {

    Broccoli ("Broccoli", 1.25),

    Cheddar_Cheese("Cheddar Cheese",3.25),
    Tomato ("Tomato", 0.75),
    Lettuce ("Lettuce", 0.50),
    Bread ("Bread", 0.15),
    Ground_Beef ("Ground_Beef", 5.00),
    Chili ("Chili", 2.00),
    Bean("Beans", 1.00),
    Onion("Onion", 0.50),
    Butter("Butter", 0.50),
    Cucumber("Cucumber", 0.75),
    Dressing("Dressing", 2.00),
    Squid ("Squid", 15.00),
    Flour("Flour", 3.00),
    Garlic("Garlic", 0.50),
    Lemons("Lemons", 0.40),
    Salmon("Salmon", 20.00),
    Rice ("Rice", 3.00),
    Egg ("Egg", 2.00),
    Chicken ("Chicken", 8.00),
    Prawns ("Prawns", 10.00),
    Herbs ("Herbs", 1.00),
    Mushroom ("Mushroom", 0.50),
    Sugar ("Sugar",0.30),
    Vanilla_Extract ("Vanilla Extract", 1.00),
    Raspberry ("Raspberry", 0.30),
    Masala_Paste ("Masala Paste",1.00),
    Conch ("Conch", 20.00),
    Bell_Pepper ("Bell Pepper", 0.50),
    Chips ("Chips", 1.00),
    Salt ("Salt", 0.25),
    Cream ("Cream", 1.75);

    private String name;
    private double price;

   Ingredient(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public static void main(String [] args) {
        Ingredient ingredient = Ingredient.Broccoli;
        System.out.println(ingredient.getName());
        System.out.println(ingredient.getPrice());
    }
}
