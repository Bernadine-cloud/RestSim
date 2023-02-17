package bean;

import java.util.List;
import java.util.Map;


public class Menu {
    private Map<MenuItem, Double> appetizers;
    private Map<MenuItem, Double> entrees;
    private Map<MenuItem, Double> desserts;

    public Menu(Map<MenuItem, Double> appetizers, Map<MenuItem, Double> entrees, Map<MenuItem, Double> desserts) {
        this.appetizers = appetizers;
        this.entrees = entrees;
        this.desserts = desserts;
    }

    public Map<MenuItem, Double> getAppetizers() {
    return appetizers;
    }

    public Map<MenuItem, Double> getEntrees() {
        return entrees;
    }

    public Map<MenuItem, Double> getDesserts() {
        return desserts;
    }
}

