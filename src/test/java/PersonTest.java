import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person grandmother = new Person("Annie", "Jacobsen", 65, "female");
    Person child1 = new Person("Lisa", "Bakker", 45, "female");
    Person partner1 = new Person("Sjaak", "Bakker", 48, "male");
    Person grandChild1 = new Person("Els", "Bakker", 13, "female");
    Person grandChild2 = new Person("Bart", "Bakker", 16, "male");
    Person child2 = new Person("Henk", "Jansen", 50, "male");
    Person grandChild3 = new Person("Pim", "Jansen", 18, "male");
    Pet dog = new Pet("corgi", 3, "Dino");
    Pet cat = new Pet("british shorthair", 10, "Barrie");

    @Test
    public void parentsShouldBeAdded() {
        grandChild1.addParents(child1, partner1);

        assertTrue((grandChild1.getMother() == child1 && grandChild1.getFather() == partner1));
    }

    @Test
    public void childShouldBeAdded() {
        child1.addChild(grandChild1);

        assertTrue(child1.getChildren().contains(grandChild1));
    }

    @Test
    public void petShouldBeAdded() {
        grandChild1.addPet(dog);

        assertTrue(grandChild1.getPets().contains(dog));
    }

    @Test
    public void siblingShouldBeAdded() {
        child1.addSibling(child2);

        assertTrue(child1.getSiblings().contains(child2));
    }

    @Test
    public void getGrandChildrenShouldShowAllGrandChildren() {
        grandmother.addChild(child1);
        grandmother.addChild(child2);
        child1.addChild(grandChild1);
        child1.addChild(grandChild2);
        child2.addChild(grandChild3);

        List<Person> grandChildren = Person.getGrandChildren(grandmother);

        assertTrue(
                grandChildren.contains(grandChild1) &&
                        grandChildren.contains(grandChild2) &&
                        grandChildren.contains(grandChild3) &&
                        grandChildren.size() == 3);
    }

    @Test
    public void getPetsOfGrandChildrenShouldShowAllPetsOfGrandChildren() {
        grandmother.addChild(child1);
        grandmother.addChild(child2);
        child1.addChild(grandChild1);
        child1.addChild(grandChild2);
        child2.addChild(grandChild3);

        grandChild1.addPet(dog);
        grandChild3.addPet(cat);

        List<Pet> allPets = Person.getPetsOfGrandChildren(grandmother);

        assertTrue(allPets.contains(dog) && allPets.contains(cat));
    }

    @Test
    public void getNiecesShouldShowAllNieces() {
        child1.addChild(grandChild1);
        child1.addChild(grandChild2);
        child2.addChild(grandChild3);
        child2.addSibling(child1);

        List<Person> allNieces = Person.getNieces(child2);

        assertTrue(allNieces.contains(grandChild1));
    }
}