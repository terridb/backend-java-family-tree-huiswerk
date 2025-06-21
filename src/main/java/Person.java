import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private String middleName;
    private String lastName;
    private String sex;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> siblings = new ArrayList<>();;
    private List<Person> children = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();;

    public Person(String name, String lastName, int age, String sex) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name, String middleName, String lastName, int age, String sex) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addParents(Person mother, Person father) {
        setMother(mother);
        setFather(father);
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void addSibling(Person sibling) {
        siblings.add(sibling);
    }

    public static List<Person> getGrandChildren(Person person) {
        List<Person> grandChildren = new ArrayList<>();

        for (Person child : person.getChildren()) {
            grandChildren.addAll(child.getChildren());
        }

        return grandChildren;
    }

    public static List<Pet> getPetsOfGrandChildren(Person person) {
        List<Person> grandChildren = getGrandChildren(person);
        List <Pet> allPets = new ArrayList<>();

        for (Person grandChild : grandChildren) {
            allPets.addAll(grandChild.getPets());
        }

        return allPets;
    }
    public static List<Person> getNieces(Person person) {
        List<Person> siblings = person.getSiblings();
        List<Person> siblingsChildren = new ArrayList<>();

        for (Person sibling : siblings) {
            siblingsChildren.addAll(sibling.getChildren());
        }

        return siblingsChildren
                .stream()
                .filter(c -> Objects.equals(c.getSex(), "female"))
                .toList();
    }
}
