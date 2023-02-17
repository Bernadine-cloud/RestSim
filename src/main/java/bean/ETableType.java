package bean;

public enum ETableType {

    SMALL (2),

    MEDIUM(4),

    LARGE (6);

    private int maxMembers;

    ETableType(int maxMembers) {
        this.maxMembers = maxMembers;
    }

    private boolean canSeatParty(int numPartyMembers) {
        return numPartyMembers == this.maxMembers || numPartyMembers == this.maxMembers -1 ;
    }

    public static ETableType getTableTypeForParty (int numMembers) {
        for (ETableType tableType: ETableType.values()) {
            if (tableType.canSeatParty(numMembers)){
                return tableType;
            }
        }
        throw new IllegalArgumentException("There is no table that can seat a party of " + numMembers + "size") ;
    }

    public static void main (String [] args) {
        ETableType tableType= ETableType.getTableTypeForParty(4);
        System.out.println(tableType);
    }
}
