package generators;

import bean.Party;
import bean.Person;
import util.Constants;
import util.Utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PartyGenerator {

    private PartyGenerator(){
        //restrict instantiation
    }

    private static List<String> names;

    public static Optional<Party> generateParty() {
        if (!Utility.weightedCoinFlip(Constants.PROBABILITY_PARTY_ENTERS_RESTAURANT)) {
            return Optional.empty();
        }

        int numMembers = Utility.pickItemFromMap(Constants.PROBABILITY_DISTRIBUTION_OF_PARTY_SIZE);
        return Optional.of(generatePartyOfSize(numMembers));
    }

    private static Party generatePartyOfSize(int size) {
        List<Person>members = new ArrayList<>();
        for (int i = 0; i<size; i++){
            String name = generateRandomName();
            members.add(new Person(name));
        }
        return new Party(members);
    }
    private static List<String> getNames() {
        if (names == null) {
            try {
                names = Files.readAllLines(new File("/Users/bernadinelouis/IdeaProjects/RestSim/src/main/resources/names.txt").toPath());
            } catch (IOException e) {
                System.out.println("There was an issue reading the names file");
                throw new RuntimeException(e);
            }
        }

        return names;
    }

    private static String generateRandomName() {
        return Utility.pickRandomElementFromList(getNames());
    }
}
