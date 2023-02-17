package generators;

import bean.ETableType;
import bean.Table;
import util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TableGenerator {

    private TableGenerator(){
        // restrict instantiation
    }

    public static List<Table> generateTables() {
        List<Table> tables = new ArrayList<>();
        for (Map.Entry<ETableType, Integer> entry : Constants.TABLE_TYPE_DISTRIBUTION.entrySet()) {
            tables.addAll(generateNumTablesOfType(entry.getKey(), entry.getValue()));
        }
        return tables;
    }

    private static List<Table> generateNumTablesOfType (ETableType tableType, int numTables) {
        List<Table> tables = new ArrayList<>();
        for (int i =0; i < numTables; i++) {
            tables.add(new Table(tableType));
        }
        return tables;
    }
}
