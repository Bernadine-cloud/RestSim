package bean;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class MenuItem {

    private String itemName;
    private int timeToMake;
    private int timeToEat;
    private double chanceOfBeingSentBack;
    private Map<Ingredient, Integer> ingredients;

    public MenuItem(String itemName, int timeToMake, int timeToEat, double chanceOfBeingSentBack, Map<Ingredient, Integer> ingredients) {
        this.itemName = itemName;
        this.timeToMake = timeToMake;
        this.timeToEat = timeToEat;
        this.chanceOfBeingSentBack = chanceOfBeingSentBack;
        this.ingredients = ingredients;
    }

    public MenuItem(String itemName){
        this.itemName =itemName;
        this.ingredients = new HashMap<>();
    }
    public MenuItem withTimeToMake(int timeToMake){
        this.timeToMake= timeToMake;
        return this;
    }

    public MenuItem withTimeToEat(int timeToEat){
        this.timeToEat = timeToEat;
        return this;
    }

    public MenuItem withChanceOfBeingSentBack (double chanceOfBeingSentBack){
        this.chanceOfBeingSentBack = chanceOfBeingSentBack;
        return this;
    }

    public MenuItem addIngredient(Ingredient ingredient, int quantity ){
        this.ingredients.put(ingredient, quantity);
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public int getTimeToMake() {
        return timeToMake;
    }

    public int getTimeToEat() {
        return timeToEat;
    }

    public double getChanceOfBeingSentBack() {
        return chanceOfBeingSentBack;
    }

    public Map<Ingredient, Integer> getIngredients() {
        return ingredients;
    }

    public static void main(String[] args) {
        Map<Ingredient, Integer> ingredients = new HashMap<>();
        ingredients.put(Ingredient.Broccoli, 3);

        ingredients.put(Ingredient.Cheddar_Cheese, 5);

        ingredients.put(Ingredient.Salt, 1);

        ingredients.put(Ingredient.Cream, 2);

        MenuItem broccoliCheddarSoup = new MenuItem(
                "Broccoli Cheddar Soup",
                15,
                20,
                0.03,
                ingredients
        );

        AtomicReference<Double> totalPrice = new AtomicReference<>((double) 0);
        broccoliCheddarSoup.getIngredients().forEach((ingredient, quantity)-> {
        totalPrice.updateAndGet(v -> new Double((double) (v + ingredient.getPrice() * quantity )));
    });

        System.out.println(totalPrice.get());
}
}

