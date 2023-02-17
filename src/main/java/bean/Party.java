package bean;
import util.Constants;
import util.Utility;

import java.util.List;
public class Party {

    private List <Person> members;
    private Order order;

    private int minutesInQueue;
    private int totalMinutesWhileSeated;
    private int timeLeftBeforeGettingUp = Integer.MAX_VALUE;

    public Party(List<Person> members) {
        this.members = members;
    }

    public void markStillInQueue(){
        this.minutesInQueue++;
    }

    public void decrementTimeLeftToCompletion(){
        this.timeLeftBeforeGettingUp--;
    }

    public boolean isDone(){
        return this.timeLeftBeforeGettingUp==0;
    }

    public List<Person> getMembers() {
        return members;
    }

    public int getMinutesInQueue() {
        return minutesInQueue;
    }

    public int getTotalMinutesWhileSeated() {
        return totalMinutesWhileSeated;
    }

    public int getTimeLeftBeforeGettingUp() {
        return timeLeftBeforeGettingUp;
    }

    public boolean gotSeated() {
        return order != null;
    }

    public Order getOrder() {
        return order;
    }

    private boolean doesPartyOrderApps() {
        return Utility.weightedCoinFlip(Constants.PROBABILITY_PARTY_ORDERS_APPS);
    }

    private boolean doesPartyOrderDessert(){
        return Utility.weightedCoinFlip(Constants.PROBABILITY_PARTY_ORDERS_DESSERT);
    }

    public Order generateOrder(Menu menu) {
        this.order = new Order ();
        if (this.doesPartyOrderApps()) {
            this.order.setAppetizer(Utility.pickItemFromMap(menu.getAppetizers()));
        }

        for (Person person : this.members){
            this.order.addEntree(person.pickMainCourse(menu));
        }

        if (this.doesPartyOrderDessert()) {
            this.order.setDessert(Utility.pickItemFromMap(menu.getDesserts()));
        }
        this.totalMinutesWhileSeated = this.order.totalTimeToCompleteOrder();
        this.timeLeftBeforeGettingUp = this.totalMinutesWhileSeated;
        return order;
    }


}
