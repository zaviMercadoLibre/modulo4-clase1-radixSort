import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RadixSort {
    public static String[] converter(int[] arr) {
        String[] array = new String[arr.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(arr[i]);
        }

        return array;

    }

    public static int maxValue(String[] arr) {
        int max = arr[0].length();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() > max) {
                max = arr[i].length();
            }
        }
        return max;
    }

    public static String[] fillWithCero(String[] arr, int n) {       //                                  {"1","2","123"} , 3
        for (int i = 0; i < arr.length; i++) {
            while (arr[i].length() < n) {
                arr[i] = "0" + arr[i];

            }
        }
        return arr;
    }

    public static String[] order(String[] array, int maxLengt) {
        HashMap<Integer, ArrayList<String>> list = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        //creacion de las 10 listas y guardado en el hashMap
        for (int a = 0; a < 10; a++) {
            list.put(a, new ArrayList<>());
        }
        //inicia el proceso de ordenamiento que se repetira maxLengt veces
        for (int j = 0; j < maxLengt; j++) {
            //se toma el ultimo numero y se lo guarda en su lista correspondiente
            for (int i = 0; i < array.length; i++) {

                int lastNumber = 0;
                lastNumber = Character.getNumericValue(array[i].charAt(array[i].length() - (j + 1)));

                list.get(lastNumber).add(array[i]);
            }
            //se guardan los valores de las listas l0-l9 en un arrayList
            for (int k = 0; k < array.length; k++) {
                ArrayList<String> auxList;
                auxList = list.get(k);
                if (auxList != null) {
                    for (int a = 0; a < auxList.size(); a++) {
                        arr.add(auxList.get(a));
                    }
                }

            }
            //se guardan los numeros del arrayList en un array
            for (int b = 0; b < arr.size(); b++) {
                array[b] = arr.get(b);
            }
            //se vacian los arrayList que estan guardados en el hashMap
            for (int z = 0; z < 10; z++) {
                list.get(z).clear();
            }
            //se vacia el arrayList que guarda los numeros ordenados
            arr.clear();
        }

        return array;

    }

    public static String[] radixSort(int[] arr) {
        String[] convertedArray = converter(arr);
        int maxLength = maxValue(convertedArray);
        String[] fillArray = fillWithCero(convertedArray, maxLength);
        String[] list = order(fillArray, maxLength);
        return list;
    }


    public static void main(String[] args) {
        int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        String[] array = radixSort(arr);


        System.out.println("viendo el array");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}

