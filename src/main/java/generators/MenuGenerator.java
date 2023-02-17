package generators;

import bean.Menu;
import bean.MenuItem;
import bean.Ingredient;
import java.util.HashMap;
import java.util.Map;

public class MenuGenerator {

    private MenuGenerator() {
//restrict instantiation
    }

    public static Menu generateMenu(){
        Menu menu= new Menu (
                generateAppetizers(),
                generateEntree(),
                generateDesserts()
        );

        return menu;
    }

    private static Map<MenuItem, Double> generateAppetizers(){
        Map<MenuItem, Double> appetizers = new HashMap<>();
        appetizers.put(generateBroccoliCheddarSoup(), 0.15);
        appetizers.put(generateNachos(), 0.35);
        appetizers.put(generateSalad(),0.25);
        appetizers.put(generateCalamari(),0.25);

        return appetizers;
    }

    private static Map<MenuItem, Double> generateEntree(){
        Map<MenuItem, Double> entree = new HashMap<>();
        entree.put(generateBurger(), 0.30);
        entree.put(generateChickenTikka(), 0.30);
        entree.put(generateBahamianConchFritters(),0.20);
        entree.put(generateSalmon(),0.10);
        entree.put(generatePrawnDinner(),0.10);

        return entree;
    }

    private static Map<MenuItem, Double> generateDesserts(){
        Map<MenuItem, Double> desserts = new HashMap<>();
        desserts.put(generateCheesecake(),0.50);
        desserts.put(generateJohnnyCake(),0.50);

        return desserts;
    }

    private static MenuItem generateBurger(){
        return new MenuItem("Burger")
                .withTimeToMake(20)
                .withTimeToEat(10)
                .withChanceOfBeingSentBack(0.01)
                .addIngredient(Ingredient.Bread, 2)
                .addIngredient(Ingredient.Ground_Beef, 1)
                .addIngredient(Ingredient.Cheddar_Cheese, 1)
                .addIngredient(Ingredient.Lettuce, 1)
                .addIngredient(Ingredient.Tomato, 1)
                .addIngredient(Ingredient.Salt, 1);
    }


    private static MenuItem generateBroccoliCheddarSoup() {
        return new MenuItem("Broccoli Cheddar Soup")
                .withTimeToMake(10)
                .withTimeToEat(15)
                .withChanceOfBeingSentBack(0.03)
                .addIngredient(Ingredient.Broccoli, 3)
                .addIngredient(Ingredient.Cheddar_Cheese, 5)
                .addIngredient(Ingredient.Cream, 2)
                .addIngredient(Ingredient.Salt, 1);

    }

    private static MenuItem generateNachos(){
        return new MenuItem("Nachos")
                .withTimeToMake(10)
                .withTimeToEat(15)
                .withChanceOfBeingSentBack(0.01)
                .addIngredient(Ingredient.Chips, 1)
                .addIngredient(Ingredient.Bean, 1)
                .addIngredient(Ingredient.Cheddar_Cheese, 1)
                .addIngredient(Ingredient.Chicken, 1)
                .addIngredient(Ingredient.Chili, 1);
    }

    private static MenuItem generateSalad(){
        return new MenuItem("Salad")
                .withTimeToMake(10)
                .withTimeToEat(15)
                .withChanceOfBeingSentBack(0.01)
                .addIngredient(Ingredient.Tomato, 1)
                .addIngredient(Ingredient.Lettuce, 2)
                .addIngredient(Ingredient.Dressing, 1)
                .addIngredient(Ingredient.Cucumber, 1)
                .addIngredient(Ingredient.Onion, 1);
    }

    private static MenuItem generateCalamari(){
        return new MenuItem("Calamari")
                .withTimeToMake(20)
                .withTimeToEat(10)
                .withChanceOfBeingSentBack(0.05)
                .addIngredient(Ingredient.Squid, 3)
                .addIngredient(Ingredient.Salt, 1)
                .addIngredient(Ingredient.Flour, 1)
                .addIngredient(Ingredient.Lemons, 2)
                .addIngredient(Ingredient.Cream, 1);
    }

    private static MenuItem generateChickenTikka(){
        return new MenuItem("Chicken Tikka")
                .withTimeToMake(40)
                .withTimeToEat(25)
                .withChanceOfBeingSentBack(0.01)
                .addIngredient(Ingredient.Chicken, 3)
                .addIngredient(Ingredient.Herbs, 2)
                .addIngredient(Ingredient.Salt, 1)
                .addIngredient(Ingredient.Garlic, 2)
                .addIngredient(Ingredient.Cream, 2)
                .addIngredient(Ingredient.Rice,2)
                .addIngredient(Ingredient.Masala_Paste,2);
    }

    private static MenuItem generateBahamianConchFritters(){
        return new MenuItem("Bahamian Conch Fritters")
                .withTimeToMake(25)
                .withTimeToEat(10)
                .withChanceOfBeingSentBack(0.02)
                .addIngredient(Ingredient.Conch, 5)
                .addIngredient(Ingredient.Herbs, 2)
                .addIngredient(Ingredient.Salt, 1)
                .addIngredient(Ingredient.Bell_Pepper, 2)
                .addIngredient(Ingredient.Onion, 1)
                .addIngredient(Ingredient.Flour,1);
    }

    private static MenuItem generateSalmon(){
        return new MenuItem("Salmon")
                .withTimeToMake(10)
                .withTimeToEat(15)
                .withChanceOfBeingSentBack(0.02)
                .addIngredient(Ingredient.Salmon, 2)
                .addIngredient(Ingredient.Herbs, 2)
                .addIngredient(Ingredient.Salt, 1)
                .addIngredient(Ingredient.Rice, 2)
                .addIngredient(Ingredient.Onion, 1)
                .addIngredient(Ingredient.Lemons,2);
    }

    private static MenuItem generatePrawnDinner(){
        return new MenuItem("Prawn Dinner")
                .withTimeToMake(10)
                .withTimeToEat(10)
                .withChanceOfBeingSentBack(0.02)
                .addIngredient(Ingredient.Prawns, 2)
                .addIngredient(Ingredient.Herbs, 2)
                .addIngredient(Ingredient.Salt, 1)
                .addIngredient(Ingredient.Rice, 2)
                .addIngredient(Ingredient.Onion, 1)
                .addIngredient(Ingredient.Mushroom,2);
    }

    private static MenuItem generateCheesecake(){
        return new MenuItem("Cheesecake")
                .withTimeToMake(45)
                .withTimeToEat(15)
                .withChanceOfBeingSentBack(0.01)
                .addIngredient(Ingredient.Sugar, 2)
                .addIngredient(Ingredient.Vanilla_Extract, 2)
                .addIngredient(Ingredient.Butter, 1)
                .addIngredient(Ingredient.Raspberry, 3)
                .addIngredient(Ingredient.Egg, 3);
    }

    private static MenuItem generateJohnnyCake(){
        return new MenuItem("Johnny Cake")
                .withTimeToMake(30)
                .withTimeToEat(15)
                .withChanceOfBeingSentBack(0.02)
                .addIngredient(Ingredient.Cream, 2)
                .addIngredient(Ingredient.Salt, 2)
                .addIngredient(Ingredient.Egg, 1)
                .addIngredient(Ingredient.Flour, 2)
                .addIngredient(Ingredient.Sugar, 2)
                .addIngredient(Ingredient.Butter,2);
    }

}


