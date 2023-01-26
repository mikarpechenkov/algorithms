package С;

import java.util.Arrays;

//Бинарный поиск
public class BinarySearch {
    private static int binarySearchIndex(double[] array, double searchElement) {
        int centralIndex = 0;
        Arrays.sort(array); //Сортируем массив в порядке возрастания
        centralIndex = array.length / 2 + 1; //Храним индекс центрального элемента
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (endIndex - startIndex > 1) {
            centralIndex=(startIndex+endIndex+1)/2+1;
            /*Определяем, где искать элемент в правой или в левой части массива*/
            if (searchElement == array[centralIndex])
                return centralIndex;
            else if (searchElement > array[centralIndex])
                startIndex = centralIndex; //endIndex остается таким же, как и был
            else if (searchElement < array[centralIndex])
                endIndex = centralIndex - 1;
        }
        if ((endIndex - startIndex == 1 || endIndex - startIndex == 0) && array[endIndex] == searchElement)
            return endIndex;
        return -1;
    }

    public static void main(String[] args) {
        double[] array = new double[]{8, 9, 46, 75, 81, 84, 93, 94, 96, 127, 133, 147};
        double searchElement=1888.2;
        long startTime=System.nanoTime();
        int indexOfSearchElement=binarySearchIndex(array,searchElement);
        long endTime=System.nanoTime();
        if(indexOfSearchElement==-1)
            System.out.println("Элемент "+ searchElement+" отсутствует в массиве\n");
        else
            System.out.println("Элемент "+ searchElement+" расположен в массиве под индексом "+indexOfSearchElement);
        System.out.println("Затраченное время: "+(endTime-startTime)+"нс");
    }
}
