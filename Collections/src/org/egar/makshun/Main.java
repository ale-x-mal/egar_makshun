package org.egar.makshun;

import java.util.*;

/**
 * Main class.
 *
 * @author Makshun Aleksey
 */
public class Main {
    /**
     * Метод Main.
     *
     * @param args аргументы
     */
    public static void main(String[] args) {

        List<Egar> egarList1 = new ArrayList<>(100_000);
        List<Egar> egarList2 = new ArrayList<>(100_000);

        //колличество одинаковых элементов от 0 до 100_000
        int equallyElem = 1_000;

        // заносим в ссписки одинаковые элементы
        Egar egar;
        for (int i = 0; i < equallyElem; i++) {
            egar = randomEgar();
            egarList1.add(egar);
            egarList2.add(egar);
        }

        // заносим в ссписки рандомные элементы
        for (int i = equallyElem; i < 100_000; i++) {
            egarList1.add(randomEgar());
            egarList2.add(randomEgar());
        }

        // перемешиваем списки
        Collections.shuffle(egarList1);
        Collections.shuffle(egarList2);

        // считаем дубли в списках и затраченое время
        long start = System.currentTimeMillis();

        List<Egar> duplicateList = new ArrayList<>(findDuplicates(egarList1, egarList2));

        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;

        // выводим результаты
        System.out.println("Время метода findDuplicates:\n" + timeConsumedMillis + " ms");
        System.out.println("Дубликатов:\n" + duplicateList.size());

    }

    /**
     * Метод поиска дубликатов в двух коллекциях.
     *
     * @param arr1 1 коллекция
     * @param arr2 2 коллекция
     * @return new ArrayList<>(set1)
     */
    private static List<Egar> findDuplicates(Collection<Egar> arr1, Collection<Egar> arr2) {

        Set<Egar> set1 = new HashSet<>(arr1);
        Set<Egar> set2 = new HashSet<>(arr2);

        long start = System.currentTimeMillis();

        // находим пересечение коллекций
        set1.retainAll(set2);

        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;

        System.out.println("Время retainAll:\n" + timeConsumedMillis + " ms");

        return new ArrayList<>(set1);
    }

    /**
     * Метод возвращает рандомный объект класса Egar.
     *
     * @return egar
     */
    private static Egar randomEgar() {

        Egar egar = new Egar();

        egar.setName(randomSymbols("abcdefghijklmnopqrstuvwxyz", 6));
        egar.setPhone("+375" + randomSymbols("0123456789", 9));
        egar.setSize(Integer.parseInt(randomSymbols("234", 2)));

        return egar;
    }

    /**
     * Метод возврвщает рандомную строку из передаваемых символов и длинны.
     *
     * @param str    строка символов
     * @param length длинна строки
     * @return sb.toString()
     */
    private static String randomSymbols(String str, int length) {

        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

}
