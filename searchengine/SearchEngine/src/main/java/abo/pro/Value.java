
package abo.pro;

    public class Value {

    Double st;
    Double wd;
    Double hh;

    public Value() {
    }

    public Value(Double st, Double wd, Double hh) {
        this.st = st;
        this.wd = wd;
        this.hh = hh;
    }

    public Double getT() {
        return st;
    }

    public Double getW() {
        return wd;
    }

    public Double getH() {
        return hh;
    }
    public void setT(Double st) {
            this.st = st;
        }

    public void setW(Double wd) {
            this.wd = wd;
        }
    public void setH(Double hh) {
        this.hh = hh;
    }

    public void print(String time) {
        System.out.println("The temperature, wind power and velocity for the exact measurement time : " + time + "-" + this.st + " " + this.wd + "-" + this.hh);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
