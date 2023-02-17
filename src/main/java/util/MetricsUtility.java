package util;

import bean.Ingredient;
import bean.MenuItem;
import bean.Party;

import java.util.*;

public class MetricsUtility {

    private List<Party> totalPartiesFromSim;
    public MetricsUtility (List<Party> totalPartiesFromSim) {
        this.totalPartiesFromSim = totalPartiesFromSim;
    }

    public int totalPartiesThatEnteredRestaurant(){
        return this.totalPartiesFromSim.size();
    }

    public int totalPartiesThatGotSeated(){
        return (int) this.totalPartiesFromSim.stream().filter(Party::gotSeated).count();
    }

    public double averageWaitTimeForPartiesThatGotSeated(){
        List<Integer>allWaitTimes = this.totalPartiesFromSim.stream()
                .filter(Party::gotSeated)
                .map(Party::getMinutesInQueue)
                .toList();

        return getMean(allWaitTimes);
    }

    public double averageWaitTimeForPartiesNotSeated(){
        List<Integer>allWaitTimes = this.totalPartiesFromSim.stream()
                .filter(x -> !x.gotSeated())
                .map(Party::getMinutesInQueue)
                .toList();

        return getMean(allWaitTimes);
    }

    public Map<Integer, Integer> getDistributionOfPartiesNeverSeated(){
        List<Party>neverSeatedParties = this.totalPartiesFromSim.stream()
                .filter(x -> !x.gotSeated())
                .toList();
        Map<Integer, Integer> distribution = new HashMap<>();
        for(Party party : neverSeatedParties) {
            addToMap(distribution, party.getMembers().size());
        }
        return distribution;
    }

    public double averageSitDownTimeOfPartiesWhoCompletedMeals() {
        List<Integer> sitDownTimes = this.totalPartiesFromSim.stream()
                .filter(Party::isDone)
                .map(Party::getTotalMinutesWhileSeated)
                .toList();

        return getMean(sitDownTimes);
    }

    public double averageTotalTimeOfFullJourney(){
        List<Integer> totalTimes = this.totalPartiesFromSim.stream()
                .filter(Party::isDone)
                .map(x ->x.getMinutesInQueue() + x.getTotalMinutesWhileSeated())
                .toList();

        return getMean(totalTimes);
    }

    public Map<String, Integer> numberOfMenuItemsOrdered(){
        Map<String, Integer> itemsThatWereOrdered = new HashMap<>();
        for (Party party : this.totalPartiesFromSim) {
            if (party.gotSeated()) {
               Optional<MenuItem> app = party.getOrder().getAppetizer();
                app.ifPresent(menuItem -> addToMap(itemsThatWereOrdered, menuItem.getItemName()));
                Set<MenuItem> entree = party.getOrder().getEntree();
                entree.forEach(menuItem -> addToMap(itemsThatWereOrdered,menuItem.getItemName()));
                Optional<MenuItem> dessert = party.getOrder().getDessert();
                dessert.ifPresent(menuItem -> addToMap(itemsThatWereOrdered, menuItem.getItemName()));
            }
        }
        return itemsThatWereOrdered;
    }

    public Map<String, Integer> numberOfIngredientsOrdered() {
        Map<String, Integer> ingredientsThatWereOrdered = new HashMap<>();
        for (Party party : this.totalPartiesFromSim) {
            if (party.gotSeated()) {
                Optional<MenuItem>app= party.getOrder().getAppetizer();
                app.ifPresent(menuItem -> addIngredientsToMap(ingredientsThatWereOrdered, menuItem));
                Set<MenuItem> entree = party.getOrder().getEntree();
                entree.forEach(menuItem -> addIngredientsToMap(ingredientsThatWereOrdered, menuItem));
                Optional<MenuItem>dessert= party.getOrder().getDessert();
                dessert.ifPresent(menuItem -> addIngredientsToMap(ingredientsThatWereOrdered, menuItem));
            }
        }
        return ingredientsThatWereOrdered;
    }

    private void addIngredientsToMap(Map<String, Integer> ingredientsThatWereOrdered, MenuItem menuItem) {
        Map<Ingredient, Integer> ingredients = menuItem.getIngredients();
        for (Map.Entry<Ingredient, Integer> e : ingredients.entrySet()) {
            String ingredientName = e.getKey().getName();
            int amountOfIngredient = e.getValue();
            for (int i =0; i< amountOfIngredient; i++) {
                addToMap(ingredientsThatWereOrdered, ingredientName);
            }
        }
    }

    private <T> void addToMap(Map<T, Integer> distribution, T itemToAdd) {
        if(!distribution.containsKey(itemToAdd)){
            distribution.put(itemToAdd,0);
        }
        int oldCount=  distribution.get(itemToAdd);
        distribution.put(itemToAdd, oldCount +1);
    }

    private static double getMean(List<Integer> list) {
        double sum = 0.0;
        for (int i: list) {
            sum += i;
        }
        return sum / list.size();
    }

}
