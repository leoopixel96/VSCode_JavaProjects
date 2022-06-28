package frazione2;

/**
 *
 * @author leokk
 */

// controllare soluzione

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

    public Frazione sum(Frazione f){
        int d = den * f.den;
        int n = num * f.den + den * f.num;

        Frazione result = new Frazione (n, d);
        return result.minTerm();
    }

    public Frazione sub(Frazione f){
        
    }

    public Frazione mul(Frazione f){
        // prodotto numeratori
        int n = num * f.num;

        //prodotto denominatori
        int d = den * f.den;

        // restituzione frazione
        return new Frazione(n, d);
    }

    public Frazione div(Frazione f){
        
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