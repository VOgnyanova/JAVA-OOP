package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class ListIteratorTest {
    private ListIterator listIterator;
    private static final String[] DATA = {"Desi","Miroslav","Boris","Petar"};
    @Before
    public void setUp() throws OperationNotSupportedException{
        listIterator = new ListIterator(DATA);
    }
    @Test(expected = OperationNotSupportedException.class)
        public void testConstructorNullParam() throws OperationNotSupportedException{
        new ListIterator(null);

    }
    @Test
    public void testMove(){
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());

    }
    @Test
    public void testPrintCorrectly(){
        int index = 0;
        while (listIterator.hasNext()){
            Assert.assertEquals(listIterator.print(),DATA[index]);
            index++;
            listIterator.move();
        }
    }

}