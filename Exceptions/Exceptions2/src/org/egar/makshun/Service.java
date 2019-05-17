package org.egar.makshun;

import org.egar.makshun.exceptions.CloseException;
import org.egar.makshun.exceptions.DaoException;
import org.egar.makshun.exceptions.ServiceException;

public class Service {

    static void doSomething() throws ServiceException {

        try {
            DAO.doSomething();
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException("Произошла ошибка ServiceException!!!");
        }
    }

    static void close() throws CloseException {
        throw new CloseException("Произошла ошибка CloseException!!!");
    }
}
