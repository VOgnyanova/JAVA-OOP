package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DummyTest {
    private static final int DUMMY_START_HEALTH = 100;
    private static final int DEAD_DUMMY_HEALTH = 0;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int ATTACK_POINTS = 20;
    private Dummy dummy;
    private Dummy deadDummy;


    @Before
    public void setUp() {
        dummy = new Dummy(DUMMY_START_HEALTH, DUMMY_EXPERIENCE);
        deadDummy = new Dummy(DEAD_DUMMY_HEALTH, DUMMY_EXPERIENCE);

    }

    @Test
    public void testAttackedDummyLosesHealth() {
        //Arrange
        //Act
        dummy.takeAttack(ATTACK_POINTS);
        //Assert
        Assert.assertEquals(DUMMY_START_HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackDeadDummyThrowException() {
        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void TestDeadDummyGivesXP() {
        int exp = deadDummy.giveExperience();
        Assert.assertEquals(DUMMY_EXPERIENCE, exp);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyDoesntGiveXP() {
        dummy.giveExperience();
    }
}