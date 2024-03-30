package ssvv.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.Before;
/**
 * Unit test for simple App.
 */
public class AppTest
{

    Integer testNumber;

    @Before
    public void initData() {
        testNumber= 1;
    }

    @Test
    public void testNumber(){
        initData();
        Assert.assertEquals(1,testNumber.intValue());
    }

}
