package frazione1;
/**
 *
 * @author leokk
 */

public class Frazione {
    int num, den;
    
    public Frazione(int num, int den) {
        this.num = num;
        this.den = den;
    }
    
    public int getNum() {
        return this.num;
    }
    
    public int getDen() {
        return this.den;
    }
    
    public Frazione minTerm(){
        //numeratore / mcd
        int num = this.num / MyMath.mcd(this.num, this.den);
        
        //denominatore / mcd
        int den = this.den / MyMath.mcd(this.num, this.den);
        
        //costruzione di una frazione
        return new Frazione(num, den);
    }
    
    @Override
    public String toString() {
        return num + "/" + den;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.num;
        hash = 73 * hash + this.den;
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Frazione other = (Frazione) obj;
        if ((this.num * other.getDen()) != (this.den * other.getNum())) {
            return false;
        }
        return (this.num * other.getDen()) == this.den * other.getNum();
    }
}