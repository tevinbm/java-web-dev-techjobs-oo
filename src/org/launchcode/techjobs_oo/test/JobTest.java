package org.launchcode.techjobs_oo.test;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    public Job job1, job2, job3, job4;

    @Before
    public void SetJobObj(){
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){
//        Job job1 = new Job();
//        Job job2 = new Job();

        assertEquals( 1, job2.getId() - job1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){

        assertTrue(job3 instanceof Job);
        assertEquals( "Product tester", job3.getName());
        assertEquals("ACME",job3.getEmployer().getValue());
        assertEquals("Desert",job3.getLocation().getValue());
        assertEquals("Quality Control",job3.getPositionType().getValue());
        assertEquals("Persistence",job3.getCoreCompetency().getValue());
        assertEquals(0, job3.getId());
    }

    @Test
    public void testJobsForEquality(){
//        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertFalse(job4.equals(job3));
    }

    @Test
    public void testNewLine(){
        char firstChar = job3.toString().charAt(0);
        char lastChar = job3.toString().charAt(job3.toString().length()-1);
        assertTrue(firstChar == lastChar);
    }

    @Test
    public void testToString(){
        String output =
                "\nID: " + job3.getId() +
                " name: '" + job3.getName() + "\n" +
                " employer: " + job3.getEmployer().getValue() + "\n" +
                " location: " + job3.getLocation().getValue() + "\n" +
                " positionType: " + job3.getPositionType().getValue() + "\n" +
                " coreCompetency: " + job3.getCoreCompetency().getValue() + "\n";
        assertEquals(output, job3.toString());
    }

    @Test
    public void testEmptyField(){
        job3.getEmployer().setValue("");
        job3.getPositionType().setValue("");
        String output =
                        "\nID: " + job3.getId() +
                        " name: '" + job3.getName() + "\n" +
                        " employer: Data Not available\n" +
                        " location: " + job3.getLocation().getValue() + "\n" +
                        " positionType: Data Not available\n"+
                        " coreCompetency: " + job3.getCoreCompetency().getValue() + "\n";
        assertEquals(output, job3.toString());
    }
}
