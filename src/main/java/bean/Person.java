package bean;

import util.Utility;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public MenuItem pickMainCourse(Menu menu) {
        return Utility.pickItemFromMap(menu.getEntrees());
    }
}
