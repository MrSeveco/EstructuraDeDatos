package PilasYColas;
import java.util.Scanner;
public class ExpresionesPostfix {
    public static void main(String[] arg){
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce la expresion postfija: ");
        String expresion = input.nextLine();
        int resultado = ExpresionesPostfix.evaluarExpresion(expresion);
        System.out.println("El resultado es: " + resultado);
    }

    class Nodo {
        int valor;
        Nodo siguiente;

        public Nodo(int valor) {
            this.valor = valor;
            siguiente = null;
        }
    }

    private Nodo tope;

    public ExpresionesPostfix() {
        tope = null;
    }

    public void push(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (tope == null) {
            tope = nuevoNodo;
        } else {
            nuevoNodo.siguiente = tope;
            tope = nuevoNodo;
        }
    }

    public int pop() {
        if (tope == null) {
            throw new RuntimeException("La pila está vacía");
        }
        int valor = tope.valor;
        tope = tope.siguiente;
        return valor;
    }

    public int peek() {
        if (tope == null) {
            throw new RuntimeException("La pila está vacía");
        } else {
            return tope.valor;
        }
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public static int evaluarExpresion(String expresion) {
        //Stack<Integer> pila = new Stack<Integer>();

        ExpresionesPostfix pila = new ExpresionesPostfix();


        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            if (Character.isDigit(caracter)) {
                pila.push(caracter - '0');
            } else if (caracter == '+') {
                int num2 = pila.pop();
                int num1 = pila.pop();
                pila.push(num1 + num2);
            } else if (caracter == '-') {
                int num2 = pila.pop();
                int num1 = pila.pop();
                pila.push(num1 - num2);
            } else if (caracter == '*') {
                int num2 = pila.pop();
                int num1 = pila.pop();
                pila.push(num1 * num2);
            } else if (caracter == '/') {
                int num2 = pila.pop();
                int num1 = pila.pop();
                pila.push(num1 / num2);
            }
        }
        return pila.pop();
    }

}
    