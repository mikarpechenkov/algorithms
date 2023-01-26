package ru.miet.algorithm.secondlab;

//Вывод n-ого элемента последовательности a_n=n!/2^n (рекурсивно)
public class RecursiveSequenceElement {
    private static double calculateElement(int elementNumber) {
        double element = 0.0;
        if (elementNumber < 0)
            throw new ArithmeticException("Невозможно посчитать отрицательный элемент последовательности");
        else if (elementNumber == 0)
            element = 1;
        else
            element = elementNumber * calculateElement(elementNumber - 1) / 2;
        System.out.println("Элемент под номером " + elementNumber + " равен " + element);
        return element;
    }

    public static void main(String[] args) {
        int elementNumber = 5;
        try {
            calculateElement(elementNumber);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}