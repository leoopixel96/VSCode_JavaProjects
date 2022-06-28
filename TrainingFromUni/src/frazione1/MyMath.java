/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package frazione1;

/**
 *
 * @author leokk
 */
public class MyMath {
    
    public static int mcd(int a, int b){
        int resto;
        if (b > a){ // swap a,b
            int tmp = a;
            a = b;
            b = tmp;
        }
        do {
            resto = a % b;
            a = b;
            b = resto;
        } while (resto != 0);
        return a;
    }
}
