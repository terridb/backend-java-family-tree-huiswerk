import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void parentsShouldBeAdded() {
        Person mother = new Person("Lisa", "Bakker", 45, "female");
        Person father = new Person("Sjaak", "Bakker", 48, "male");
        Person p = new Person("Els", "Bakker", 13, "female");

        p.addParents(mother, father);

        assertTrue((p.getMother() == mother && p.getFather() == father));
    }

    @Test
    public void childShouldBeAdded() {
        Person p = new Person("Lisa", "Bakker", 45, "female");
        Person c = new Person("Els", "Bakker", 13, "female");

        p.addChild(c);

        assertTrue(p.getChildren().contains(c));
    }

    @Test
    public void petShouldBeAdded() {
        Pet dog = new Pet("corgi", 3, "Dino");
        Person p = new Person("Lisa", "Bakker", 45, "female");

        p.addPet(dog);

        assertTrue(p.getPets().contains(dog));
    }

    @Test
    public void siblingShouldBeAdded() {
        Person p = new Person("Lisa", "Bakker", 45, "female");
        Person s = new Person("Bart", "Bakker", 16, "male");

        p.addSibling(s);

        assertTrue(p.getSiblings().contains(s));
    }

    @Test
    public void getGrandChildrenShouldShowAllGrandChildren() {
        Person grandmother = new Person("Annie", "Jacobsen", 65, "female");
        Person mother = new Person("Lisa", "Bakker", 45, "female");
        Person sister = new Person("Els", "Bakker", 13, "female");
        Person brother = new Person("Bart", "Bakker", 16, "male");
        Person uncle = new Person("Henk", "Jansen", 50, "male");
        Person nephew = new Person("Pim", "Jansen", 18, "male");
        grandmother.addChild(mother);
        grandmother.addChild(uncle);
        mother.addChild(sister);
        mother.addChild(brother);
        uncle.addChild(nephew);

        List<Person> grandChildren = Person.getGrandChildren(grandmother);

        assertTrue(
                grandChildren.contains(sister) &&
                        grandChildren.contains(brother) &&
                        grandChildren.contains(nephew) &&
                        grandChildren.size() == 3);
    }
}