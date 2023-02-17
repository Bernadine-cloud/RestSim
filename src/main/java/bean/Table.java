package bean;


public class Table {
    private ETableType tableType;
    private Party partySeated;

    public Table(ETableType tableType) {
        this.tableType = tableType;
    }

    public void seatParty (Party party){
        this.partySeated= party;
    }
    public void unseatParty(){
        this.partySeated = null;
    }

    public boolean isOccupied() {
        return this.partySeated !=null;
    }

    public ETableType getTableType() {
        return tableType;
    }

    public Party getPartySeated() {
        return partySeated;
    }
}
