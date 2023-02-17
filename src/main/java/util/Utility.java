package util;

import bean.MenuItem;

import java.util.*;

public class Utility {

    private Utility() {
        //restrict instance
    }

    public static Set<MenuItem> getItemsSentBack(Set<MenuItem>entree) {
        Set<MenuItem> entreeSentBack = new HashSet<>();
        for (MenuItem entrees : entree) {
            boolean isSentBack = weightedCoinFlip(entrees.getChanceOfBeingSentBack());
            if (isSentBack) {
                entreeSentBack.add(entrees);
            }
        }
        return entreeSentBack;
    }
    public static int getMaxTimeToCook(Set<MenuItem> entree) {
        OptionalInt maxTimeToCook = entree.stream().mapToInt(MenuItem::getTimeToMake).max();
        return maxTimeToCook.orElse(0);
    }

    public static int getMaxTimeToEat (Set<MenuItem> entree) {
        OptionalInt maxTimeToEat = entree.stream().mapToInt(MenuItem::getTimeToEat).max();
        return maxTimeToEat.orElse(0);
    }

    public static int getTotalTimeToMakeDish(MenuItem dish){
        int timeToCook = dish.getTimeToMake();
        double chanceOfBeingSentBack = dish.getChanceOfBeingSentBack();
        boolean isSentBack = weightedCoinFlip(chanceOfBeingSentBack);
        if (isSentBack) {
            timeToCook +=dish.getTimeToMake();
        }
        return timeToCook;
    }

    public static boolean weightedCoinFlip(double weight){
        double random = Math.random();
        return random < weight;
    }

    public static <T> T pickItemFromMap(Map<T,Double> optionsWithProbability) {
        double totalSum= optionsWithProbability.values().stream().mapToDouble(x -> x).sum();
        if (Double.compare(totalSum, 1) != 0) {
            throw new IllegalArgumentException("Probabilities must add to 1");
        }
        List<T> tempList =getListOfWeightedElements(optionsWithProbability);
        return pickRandomElementFromList(tempList);
    }

    private static <T> List <T> getListOfWeightedElements(Map<T, Double> optionsWithProbability) {
        List <T> tempList = new ArrayList<>();
        for (Map.Entry<T, Double> entry : optionsWithProbability.entrySet()) {
            double probability = entry.getValue();
            int numCount = (int) (probability * 100);
            for (int i = 0; i < numCount; i++) {
            tempList.add(entry.getKey());
            }
        }
        return tempList;

    }
    public static <T> T pickRandomElementFromList(List<T> list){
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
