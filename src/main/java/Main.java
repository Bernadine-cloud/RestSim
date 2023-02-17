import bean.ETableType;
import bean.Party;
import bean.Restaurant;
import bean.Table;
import generators.MenuGenerator;
import generators.PartyGenerator;
import generators.TableGenerator;
import util.Constants;
import util.MetricsUtility;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class Main{

        private static List<Party> allPartiesInSim = new ArrayList<>();
        public static void printStats() {
            MetricsUtility metricsUtility = new MetricsUtility(allPartiesInSim);
            System.out.println("Here are All statistics through the shift");
            newSection();
            System.out.println("Total Parties that Entered the Restaurant:  " + metricsUtility.totalPartiesThatEnteredRestaurant());
            newSection();
            System.out.println("Total Parties that got Seated" + metricsUtility.averageWaitTimeForPartiesThatGotSeated());
            newSection();
            System.out.println("Distribution of Parties That Did Not Get Seated ");
            printMap(metricsUtility.getDistributionOfPartiesNeverSeated());
            newSection();
            System.out.println("Average Sit Down Time of Parties Who Go Seated: "+ metricsUtility.averageSitDownTimeOfPartiesWhoCompletedMeals());
            newSection();
            System.out.println("Average Total Time of Full Journey (Parties Who Completed Meals): " + metricsUtility.averageTotalTimeOfFullJourney());
            newSection();
            System.out.println("Total Menu Items Ordered");
            printMap(metricsUtility.numberOfMenuItemsOrdered());
            newSection();
            printMap(metricsUtility.numberOfIngredientsOrdered());

        }

    private static <T> void printMap(Map<T, Integer> partiesNotSeated) {
        partiesNotSeated.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static void newSection() {
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {
            Restaurant restaurant = new Restaurant(
                    TableGenerator.generateTables(),
                    MenuGenerator.generateMenu()
            );

            for (int i = 0; i < Constants.MINUTES_TO_RUN_SIM; i++) {
                restaurant.incrementTimeWaitedInQueue();
                Optional<Party> newParty = PartyGenerator.generateParty();
                if (newParty.isPresent()) {
                    allPartiesInSim.add(newParty.get());
                    restaurant.addPartyToQueue(newParty.get());
                }
                List<Table> occupiedTables = restaurant.getOccupiedTables();
                for (Table table: occupiedTables) {
                    table.getPartySeated().decrementTimeLeftToCompletion();
                    if (table.getPartySeated().isDone()) {
                        table.unseatParty();
                    }
                }
                List<Table> unOccupiedTables = restaurant.getUnOccupiedTables();
                for (Table table : unOccupiedTables) {
                    ETableType tableType = table.getTableType();
                    Optional<Party> nextParty = restaurant.getNextParty(tableType);
                    if(nextParty.isPresent()) {
                        table.seatParty(nextParty.get());
                        nextParty.get().generateOrder(restaurant.getMenu());
                    }
                }
            }

            printStats();
        }
    }

