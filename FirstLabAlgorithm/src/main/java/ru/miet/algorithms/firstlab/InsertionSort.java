package ru.miet.algorithms.firstlab;

import java.util.Random;

//Простая вставка
public class InsertionSort {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("СОРТИРОВКА ПРОСТОЙ ВСТАВКОЙ\n");

        for (int k = 1000; k != 10000; k += 1000) {
            int[] array = new int[k]; //Создание массива размером n, он проинициализирован нулями
            long sumTime=0;
            for (int z=0; z!=100;z++) {
                for (int i = 0; i != array.length; i++)
                    array[i] = random.nextInt(999) + 1; //Заполнение массива случайными числами

                long startTime = System.nanoTime();
                for (int i = 1; i != array.length; i++) { //Сама сортировка
                    int tmp = array[i];
                    int j = i - 1;
                    while (j >= 0 && array[j] > tmp) {
                        array[j + 1] = array[j];
                        j--;
                    }
                    array[j + 1] = tmp;
                }
                long endTime = System.nanoTime();
                sumTime+=(endTime-startTime);
            }
            System.out.println("\nЗатраченное время: " + (sumTime/100) + "нс (сортировка "+k+" элементов)"); //Вывод затраченного времени
        }
    }
}