package org.egar.makshun;

/**
 * Класс с заданиями.
 *
 * @author Makshun Aleksey
 */
class Tasks {

    /**
     * 1. Написать программу, которая выводит в консоль
     * числовые представления, символов Unicode: ‘D’, ‘R’, ‘f’.
     */
    void task1() {
        char d = 'D';
        char r = 'R';
        char f = 'f';

        System.out.println("1. Написать программу, которая выводит в консоль числовые\n" +
                "представления, символов Unicode: ‘D’, ‘R’, ‘f’.\n");
        System.out.println(d + " = " + (int) d);
        System.out.println(r + " = " + (int) r);
        System.out.println(f + " = " + (int) f);
    }

    /**
     * 2. Написать программу, в которой будут созданы переменные указанных
     * типов и осуществлены соответствующие преобразования:
     * int  byte
     * short  byte
     * char  int
     * float  long
     * long  int
     * double  int
     * Результаты преобразований выводить в консоль.
     */
    void task2() {
        int i = 45223;
        short s = 112;
        char c = 'G';
        float f = 1213.3243F;
        long l = 215464447;
        double d = 23562.423;

        System.out.println("2. Написать программу, в которой будут созданы переменные указанных\n" +
                "типов и осуществлены соответствующие преобразования:\n" +
                "int \uF0E0 byte\n" +
                "short \uF0E0 byte\n" +
                "char \uF0E0 int\n" +
                "float \uF0E0 long\n" +
                "long \uF0E0 int\n" +
                "double \uF0E0 int\n" +
                "Результаты преобразований выводить в консоль.\n");
        System.out.println("int \uF0E0 byte:        " + i + " \uF0E0 " + (byte) i);
        System.out.println("short \uF0E0 byte:      " + s + " \uF0E0 " + (byte) s);
        System.out.println("char \uF0E0 int:        " + c + " \uF0E0 " + (int) c);
        System.out.println("float \uF0E0 long:      " + f + " \uF0E0 " + (long) f);
        System.out.println("long \uF0E0 int:        " + l + " \uF0E0 " + (int) l);
        System.out.println("double \uF0E0 int:      " + d + " \uF0E0 " + (int) d);
    }

    /**
     * 3. Написать программу, в которой осуществить упаковку int в Integer,  boolean в Boolean,
     * char в Character, а также распаковку Float в float, Long в long. Вывести результаты на консоль.
     */
    void task3() {
        int i = 24242;
        boolean b = true;
        char c = 'T';
        Float f = 23.423F;
        Long l = 2324254242L;

        Integer ii = i;
        Boolean bb = b;
        Character cc = c;
        float ff = f;
        long ll = l;

        System.out.println("3. Написать программу, в которой осуществить упаковку int в Integer,\n" +
                "boolean в Boolean, char в Character, а также распаковку Float в float,\n" +
                "Long в long. Вывести результаты на консоль.\n");
        System.out.println(ii);
        System.out.println(bb);
        System.out.println(cc);
        System.out.println(ff);
        System.out.println(ll);

    }

    /**
     * 4. Написать программу, в которой при помощи методов классов String или StringBuilder произвести:
     * - создание двух различных строк,
     * - осуществить реверс второй строки,
     * - получить две подстроки из каждой из начальных строк;
     * Вывести результат в консоль.
     */
    void task4() {
        StringBuilder sb1 = new StringBuilder("Первоя строка");
        StringBuilder sb2 = new StringBuilder("Вторая строка");
        StringBuilder sb2Rev = new StringBuilder(sb2);
        sb2Rev.reverse();
        String s1 = sb1.substring(0, 6);
        String s2 = sb1.substring(7);
        String s3 = sb2.substring(0, 6);
        String s4 = sb2.substring(7);

        System.out.println("4. Написать программу, в которой при помощи методов\n" +
                " классов String или StringBuilder произвести:\n" +
                "- создание двух различных строк,\n" +
                "- осуществить реверс второй строки,\n" +
                "- получить две подстроки из каждой из начальных строк;\n" +
                "Вывести результат в консоль.\n");
        System.out.println(sb1);
        System.out.println(sb2);
        System.out.println(sb2Rev);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
}
