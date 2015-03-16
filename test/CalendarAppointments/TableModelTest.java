/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CalendarAppointments;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hp
 */
public class TableModelTest {
    
    public TableModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setFilter method, of class TableModel.
     */
    @Test
    public void testSetFilter() {
        System.out.println("setFilter");
        String[] filterArray = null;
        TableModel instance = new TableModel();
        instance.setFilter(filterArray);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnsNames method, of class TableModel.
     */
    @Test
    public void testGetColumnsNames() {
        System.out.println("getColumnsNames");
        TableModel instance = new TableModel();
        String[] expResult = null;
        String[] result = instance.getColumnsNames();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnName method, of class TableModel.
     */
    @Test
    public void testGetColumnName() {
        System.out.println("getColumnName");
        int column = 0;
        TableModel instance = new TableModel();
        String expResult = "";
        String result = instance.getColumnName(column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTableData method, of class TableModel.
     */
    @Test
    public void testGetTableData() {
        System.out.println("getTableData");
        TableModel instance = new TableModel();
        Object[][] expResult = null;
        Object[][] result = instance.getTableData();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRowCount method, of class TableModel.
     */
    @Test
    public void testGetRowCount() {
        System.out.println("getRowCount");
        TableModel instance = new TableModel();
        int expResult = 0;
        int result = instance.getRowCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnCount method, of class TableModel.
     */
    @Test
    public void testGetColumnCount() {
        System.out.println("getColumnCount");
        TableModel instance = new TableModel();
        int expResult = 0;
        int result = instance.getColumnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class TableModel.
     */
    @Test
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int row = 0;
        int column = 0;
        TableModel instance = new TableModel();
        Object expResult = null;
        Object result = instance.getValueAt(row, column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnClass method, of class TableModel.
     */
    @Test
    public void testGetColumnClass() {
        System.out.println("getColumnClass");
        int c = 0;
        TableModel instance = new TableModel();
        Class expResult = null;
        Class result = instance.getColumnClass(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
