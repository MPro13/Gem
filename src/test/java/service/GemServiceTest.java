package service;

import model.Gem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;
@RunWith(PowerMockRunner.class)
@PrepareForTest(Scanner.class)
public class GemServiceTest {

    private List <Gem> gemList1;
    @Before
    public void setUp() throws Exception {

        gemList1 = new ArrayList <>();
        gemList1.add(new Gem ("Ruby", 5, 200, 20));
        gemList1.add(new Gem ("Obsidian",24, 2500, 40 ));
        gemList1.add(new Gem ("Agate", 56, 150, 15));

    }

    @Test
    public void storeNecklace() {
    }

    @Test
    public void inputGem() {
//        Scanner mockScanner = mock(Scanner.class);

    }

    @Test
    public void findGem() {
  //      Scanner scanner = PowerMockito.mock(Scanner.class);

    }

    @Test
    public void deleteGem() {
//    //    Scanner scanner = PowerMockito.mock(Scanner.class);
//        List<Gem> expected = gemList1;
//        expected.remove(2);
//
//        List<Gem> actual = GemService.deleteGem(gemList1);
//        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteGemFromNecklace() {
    }
}