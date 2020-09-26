package com.epam.izh.rd.online.service;





import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.StrictMath.sqrt;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     * <p>
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        int c;
        if (value1 > value2) {
            c = 1;
        } else if (value2 > value1) {
            c = -1;
        } else c = 0;
        return c;
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        return (value1 > value2) ? value1 : value2;
    }


    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int max;
        max = values[0];
        for (int i = 0; i<values.length;i++){
            if (max<values[i]){
                max = values[i];
            }
        }
        return max;
}
    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int summa = 0;
        for (int i = 0; i<values.length;i++){
            summa+=values[i];
        }
        return summa;

    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        List<Integer> chetn = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if (values[i]%2 == 0) {
                chetn.add(values[i]);
            }
        }
        int [] arr = new int[chetn.size()];
        for (int j = 0;j<chetn.size();j++){
            arr[j] = chetn.get(j);
        }

      return arr;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        int chet =1;
        while (initialVal>0){
            chet = chet*initialVal;
            initialVal--;
        }
        return chet;
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     *
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     *
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {

        int [] fibo = new int [100];
        fibo[0] = 0;
        fibo[1] = 1;
        if (number == 1){
            return 1;
        }
        if (number > 1) {
            for (int h = 2;h<=number;h++){
                fibo[h]= fibo[h-1]+fibo[h-2];
            }
            return fibo[number];
        }

        return 0;
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {

        for (int i = 0;i<values.length;i++){
                int min= values[i];
                int min_i = i;
                for (int j = i+1;j<values.length;j++){
                    if (values[j]< min){
                        min = values[j];
                        min_i = j;
                    }
                }
                if (i != min_i){
                    int tmp = values[i];
                    values[i] =  values[min_i];
                    values [min_i] = tmp;
            }
        }

        return values;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     *
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
      if (number<2){
          return false;
      }
      double s = sqrt(number);
      for (int i = 2 ; i <= s; i++){
          if (number % i ==0){
              return false;
          }
      }
        return true;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     *
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        int ggg;
        int d = values.length;

        int [] arr = Arrays.copyOf(values,d);
            for (int i = 0;i<d/2;i++){
                ggg = values[d-i-1];
                arr[d-i-1]= values[i];
                arr[i] = ggg;
            }
            return  arr;
}
}
