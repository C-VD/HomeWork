import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        // Прочитать фигуры из файла
        ArrayList<Figure> figures = readFiguresFromFile();
        if (figures == null) {
            return;
        }
        // Отсортировать
        figures.sort((o1, o2) -> Double.compare(
                o1.calcArea(),
                o2.calcArea()
        ));

        // Вывести
        printFigures(figures);


    }

    private static void printFigures(ArrayList<Figure> figures) {
        System.out.println(figures.toString().replace("}, ", "}\n"));
    }

    static ArrayList<Figure> readFiguresFromFile(){
        File file = getFileFromUser();
        try(Scanner sc = new Scanner(file)){
            ArrayList<Figure> figures= new ArrayList<>();
            while(sc.hasNextLine()){
                figures.add(parseFigure(sc.nextLine()));
            }
            return figures;
        }
        catch (Exception e){
            System.out.println("Файл открыть не удалось");
            return null;
        }
 }
    static File getFileFromUser(){
        System.out.println("Имя файла: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        //return new File("src/Main.java");
        return new File(name);

    }

    static Figure parseFigure(String str){
        String[] arr = str.split(" ");
        if(arr.length == 4 && arr[0].equals("Triangle")) {
            double a = Double.valueOf(arr[1]);
            double b = Double.valueOf(arr[2]);
            double c = Double.valueOf(arr[3]);
            Triangle tri = new Triangle(a, b, c);
            return  tri;
        }
        if(arr.length == 2 && arr[0].equals("Circle")){
            double r = Double.valueOf(arr[1]);
            Circle crk = new Circle(r);
            return crk;
        }
        System.out.println("Неизвестная фигура.");
        return null;
    }
}
