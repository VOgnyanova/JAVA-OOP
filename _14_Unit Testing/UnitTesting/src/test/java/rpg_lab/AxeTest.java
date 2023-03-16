package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;




public class AxeTest {
    private static final int START_DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;
    private static final int AXE_ATTACK_POINTS =10;
    private static final int AXE_DURABILITY= 10;
    private static final int AXE_WITHOUT_DURABILITY= 0;

    private Dummy dummy;

    @Before
    public void setUp(){
        dummy = new Dummy(START_DUMMY_HEALTH,DUMMY_XP);
    }
    @Test
    public void testAxeLosesDurabilityAfterAttack(){
        //Arrange
        Axe axe = new Axe(AXE_ATTACK_POINTS,AXE_DURABILITY);
        //Act
        axe.attack(dummy);
        //Assert
        Assert.assertEquals(AXE_ATTACK_POINTS - Axe.DURABILITY_LOSS,axe.getDurabilityPoints());
    }
    @Test(expected =IllegalStateException.class)
    public void testAttackWithBrokenAxeShouldThrowException(){
        Axe axe = new Axe(AXE_ATTACK_POINTS,AXE_WITHOUT_DURABILITY);
        axe.attack(dummy);
    }

}