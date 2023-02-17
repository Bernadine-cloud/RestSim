package bean;

import java.util.*;
import java.util.stream.Collectors;

public class Restaurant {

    private Map<ETableType, Queue<Party>> partiesInQueue;
    private List<Table> tables;
    private Menu menu;

    public Restaurant(List<Table> tables, Menu menu) {
        this.partiesInQueue = new HashMap<>();
        this.tables = tables;
        this.menu = menu;
    }

    public void addPartyToQueue(Party party) {
        ETableType tableType = ETableType.getTableTypeForParty(party.getMembers().size());
        if (!this.partiesInQueue.containsKey(tableType)) {
            this.partiesInQueue.put(tableType, new ArrayDeque<>());
        }
        this.partiesInQueue.get(tableType).add(party);
    }
     public void incrementTimeWaitedInQueue() {
        for (Queue<Party> queue : partiesInQueue.values()) {
            for (Party party : queue) {
                party.markStillInQueue();
            }
        }
     }

     public List<Table> getUnOccupiedTables(){
        return this.tables.stream().filter(x -> !x.isOccupied()).collect(Collectors.toList());
     }

     public List<Table> getOccupiedTables(){
        return this.tables.stream().filter(Table::isOccupied).collect(Collectors.toList());
     }

     public Optional<Party> getNextParty(ETableType tableType){
        return Optional.ofNullable(this.partiesInQueue.getOrDefault(tableType, new ArrayDeque<>()).poll());
     }


    public List<Table> getTables() {
        return tables;
    }

    public Menu getMenu() {
        return menu;
    }
}
