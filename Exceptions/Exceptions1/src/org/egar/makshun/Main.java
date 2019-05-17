package org.egar.makshun;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Main class.
 *
 * @author Makshun Aleksey
 */
public class Main {

    public static void main(String[] args) {

        try {
            getArithmeticException();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        try {
            getArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();

        }

        try {
            getClassNotFoundException();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            getFileNotFoundException();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            getIOException();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            getNoSuchFieldException();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
            getNoSuchMethodException();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            getNullPointerException();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try {
            getNumberFormatException();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {
            getRuntimeException();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        try {
            getStringIndexOutOfBoundsException();
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    private static void getArithmeticException() {
        throw new ArithmeticException();
    }

    private static void getArrayIndexOutOfBoundsException() {
        throw new ArrayIndexOutOfBoundsException();
    }

    private static void getClassNotFoundException() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }

    private static void getFileNotFoundException() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    private static void getIOException() throws IOException {
        throw new IOException();
    }

    private static void getNoSuchFieldException() throws NoSuchFieldException {
        throw new NoSuchFieldException();
    }

    private static void getNoSuchMethodException() throws NoSuchMethodException {
        throw new NoSuchMethodException();
    }

    private static void getNullPointerException() {
        throw new NullPointerException();
    }

    private static void getNumberFormatException() {
        throw new NumberFormatException();
    }

    private static void getRuntimeException() {
        throw new RuntimeException();
    }

    private static void getStringIndexOutOfBoundsException() {
        throw new StringIndexOutOfBoundsException();
    }

}
