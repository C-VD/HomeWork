public class Triangle extends Figure {
    double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double calcArea(){
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a ) * (p - b) * (p - c));
    }

    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}