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
public class DaysOffTableModelTest {
    
    public DaysOffTableModelTest() {
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
     * Test of setFilter method, of class DaysOffTableModel.
     */
    @Test
    public void testSetFilter() {
        System.out.println("setFilter");
        String[] filterArray = null;
        DaysOffTableModel instance = new DaysOffTableModel();
        instance.setFilter(filterArray);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnsNames method, of class DaysOffTableModel.
     */
    @Test
    public void testGetColumnsNames() {
        System.out.println("getColumnsNames");
        DaysOffTableModel instance = new DaysOffTableModel();
        String[] expResult = null;
        String[] result = instance.getColumnsNames();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnName method, of class DaysOffTableModel.
     */
    @Test
    public void testGetColumnName() {
        System.out.println("getColumnName");
        int column = 0;
        DaysOffTableModel instance = new DaysOffTableModel();
        String expResult = "";
        String result = instance.getColumnName(column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTableData method, of class DaysOffTableModel.
     */
    @Test
    public void testGetTableData() {
        System.out.println("getTableData");
        DaysOffTableModel instance = new DaysOffTableModel();
        Object[][] expResult = null;
        Object[][] result = instance.getTableData();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRowCount method, of class DaysOffTableModel.
     */
    @Test
    public void testGetRowCount() {
        System.out.println("getRowCount");
        DaysOffTableModel instance = new DaysOffTableModel();
        int expResult = 0;
        int result = instance.getRowCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnCount method, of class DaysOffTableModel.
     */
    @Test
    public void testGetColumnCount() {
        System.out.println("getColumnCount");
        DaysOffTableModel instance = new DaysOffTableModel();
        int expResult = 0;
        int result = instance.getColumnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValueAt method, of class DaysOffTableModel.
     */
    @Test
    public void testGetValueAt() {
        System.out.println("getValueAt");
        int row = 0;
        int column = 0;
        DaysOffTableModel instance = new DaysOffTableModel();
        Object expResult = null;
        Object result = instance.getValueAt(row, column);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValueAt method, of class DaysOffTableModel.
     */
    @Test
    public void testSetValueAt() {
        System.out.println("setValueAt");
        Object value = null;
        int row = 0;
        int col = 0;
        DaysOffTableModel instance = new DaysOffTableModel();
        instance.setValueAt(value, row, col);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnClass method, of class DaysOffTableModel.
     */
    @Test
    public void testGetColumnClass() {
        System.out.println("getColumnClass");
        int c = 0;
        DaysOffTableModel instance = new DaysOffTableModel();
        Class expResult = null;
        Class result = instance.getColumnClass(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCellEditable method, of class DaysOffTableModel.
     */
    @Test
    public void testIsCellEditable() {
        System.out.println("isCellEditable");
        int row = 0;
        int col = 0;
        DaysOffTableModel instance = new DaysOffTableModel();
        boolean expResult = false;
        boolean result = instance.isCellEditable(row, col);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
