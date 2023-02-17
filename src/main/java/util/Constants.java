package util;

import bean.ETableType;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    private Constants() {
        //restrict instantiation
    }

    public static final int MINUTES_TO_RUN_SIM = 120;

    public static final double PROBABILITY_PARTY_ORDERS_APPS = 0.3;
    public static final double PROBABILITY_PARTY_ORDERS_DESSERT= 0.4;

    public static final double PROBABILITY_PARTY_ENTERS_RESTAURANT =0.25;

    public static final Map<Integer, Double> PROBABILITY_DISTRIBUTION_OF_PARTY_SIZE = Map.of(
            1, 0.05,
            2, 0.25,
            3, 0.10,
            4, 0.30,
            5, 0.10,
            6, 0.20
    );

    public static Map<ETableType, Integer> TABLE_TYPE_DISTRIBUTION = Map.of(
            ETableType.SMALL, 12,
            ETableType.MEDIUM, 10,
            ETableType.LARGE, 8
    );

}
