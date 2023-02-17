package bean;

import util.Utility;

import java.util.HashSet;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;

public class Order {
    private Optional<MenuItem> appetizer;
    private Set<MenuItem> entree;
    private Optional <MenuItem> dessert;

    public Order() {
        this.appetizer = Optional.empty();
        this.dessert= Optional.empty();
    }

    public void setAppetizer(MenuItem appetizer){
        this.appetizer = Optional.ofNullable(appetizer);
    }

    public void addEntree(MenuItem entree){
        if(this.entree== null) {
            this.entree  = new HashSet<>();
        }

        this.entree.add(entree);
    }

    public void setDessert(MenuItem dessert) {
        this.dessert = Optional.of(dessert);
    }

    public Optional<MenuItem> getAppetizer() {
        return appetizer;
    }

    public Set<MenuItem> getEntree() {
        return entree;
    }

    public Optional<MenuItem> getDessert() {
        return dessert;
    }

    public int totalTimeToCompleteOrder(){
        int totalTime=0;
                if(this.appetizer.isPresent()) {
                    totalTime += Utility.getTotalTimeToMakeDish(this.appetizer.get());
                    totalTime += this.appetizer.get().getTimeToEat();
                }
               totalTime+= Utility.getMaxTimeToCook(this.entree);
                Set<MenuItem> itemsSentBack = Utility.getItemsSentBack(this.entree);
                totalTime += Utility.getMaxTimeToCook(itemsSentBack);
                totalTime += Utility.getMaxTimeToEat(this.entree);
                if (this.dessert.isPresent()) {
                    totalTime += Utility.getTotalTimeToMakeDish(this.dessert.get());
                    totalTime += this.dessert.get().getTimeToEat();
                }

                return totalTime;
    }

}
