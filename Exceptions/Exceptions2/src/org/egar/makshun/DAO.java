package org.egar.makshun;

import org.egar.makshun.exceptions.DaoException;

public class DAO {

    static void doSomething() throws DaoException, RuntimeException {

        throw new DaoException("Произошла ошибка DaoException!!!");
    }
}
