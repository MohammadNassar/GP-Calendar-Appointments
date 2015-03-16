/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CalendarAppointments;

/**
 *
 * @author hp
 */
public class Vector3 {
    
    private final double a;
    private final double b;
    private final double c;

    public Vector3(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
    
    public Vector3 multiplyVectorByScalar(double x) {
        
        return new Vector3(this.a * x, this.b * x, this.c * x);
    }
    
    public Vector3 divideVectorByScalar(double x) {
        
        return new Vector3(this.a * x, this.b * x, this.c * x);
    }
}
