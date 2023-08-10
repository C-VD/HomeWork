public class Circle extends Figure {
    double r;

    public Circle(double r) {
        this.r = r;
    }

    double calcArea(){
        return Math.PI * Math.pow(r, 2);
    }

    public String toString() {
        return "Circle{" +
                "r=" + r +
                '}';
    }
}
