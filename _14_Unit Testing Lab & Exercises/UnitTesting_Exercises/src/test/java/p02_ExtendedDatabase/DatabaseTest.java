package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class DatabaseTest {
    private Database database;
    private static final Person[] PEOPLE = {new Person(1, "Boris"), new Person(2, "Petar"), new Person(3, "Ivan")};

    @Before
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorHasCreateValidObject() {
        Person[] elements = database.getElements();

        Assert.assertArrayEquals("Arrays are not the same!", elements, PEOPLE);
        Assert.assertEquals("Count of elements is incorrect!", elements.length, PEOPLE.length);
        for (int index = 0; index < elements.length; index++) {
            Assert.assertEquals("Arrays are not the same!", elements[index], PEOPLE[index]);

        }
    }

    //elements > 16
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenMoreThanSixteenElements() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        new Database(people);
    }

    // element < 1
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenLessThanOneElement() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        new Database(people);
    }

    //test add
    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {

        Person person = new Person(4, "Desi");
        database.add(person);

        Person[] people = database.getElements();
        Assert.assertEquals("Invalid add operation!", people.length, PEOPLE.length + 1);
        Assert.assertEquals(Integer.valueOf(people[people.length - 1].getId()), Integer.valueOf(4));
        Assert.assertEquals(people[people.length - 1].getUsername(), "Desi");
    }


    //add null test
    @Test(expected = OperationNotSupportedException.class)

    public void testAddShouldThrowNullParam() throws OperationNotSupportedException {
        database.add(null);
    }

    // remove test
    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        database.remove();

        Person[] people = database.getElements();
        Assert.assertEquals(people.length, PEOPLE.length - 1);
        Assert.assertEquals(Integer.valueOf(people[people.length - 1].getId()), Integer.valueOf(2));
        Assert.assertEquals(people[people.length - 1].getUsername(), "Petar");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowEmptyDatabase() throws OperationNotSupportedException {

     database = new Database();
        database.remove();
    }
    @Test
    public void findByUserName() throws OperationNotSupportedException {
        Person person = database.findByUsername("Petar");
        Assert.assertEquals(2,person.getId());
        Assert.assertEquals("Petar",person.getUsername());
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUserNameThrowEmptyDataBase() throws OperationNotSupportedException{
        database = new Database();

        database.findByUsername("Petar");
    }
    @Test(expected = OperationNotSupportedException.class)
    public void findByUserNameMoreThanOnePerson() throws OperationNotSupportedException {
        database.add(new Person(4,"Miroslav"));
        database.findByUsername("Miroslav");
    }@Test (expected = OperationNotSupportedException.class)
    public void testFindByUserNameInvalidName() throws OperationNotSupportedException {
        database.findByUsername("Pesho");
    }
    @Test
    public void testFindById() throws OperationNotSupportedException {
        Person person = database.findById(1);
        Assert.assertEquals(1,person.getId());
        Assert.assertEquals(person.getUsername(), "Boris");
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdMoreThanOneId() throws OperationNotSupportedException {
        database.add(new Person(2,"Pesho"));
        database.findById(2);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdEmptyData () throws OperationNotSupportedException {
        database = new Database();
        database.findById(2);
    }



}
