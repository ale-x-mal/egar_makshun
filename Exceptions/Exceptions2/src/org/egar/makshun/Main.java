package org.egar.makshun;

import org.egar.makshun.exceptions.ApplicationException;

public class Main {

    public static void main(String[] args) {
        try {
            Controller.controller();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }
}
