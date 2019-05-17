package org.egar.makshun;

import org.egar.makshun.exceptions.ApplicationException;
import org.egar.makshun.exceptions.CloseException;
import org.egar.makshun.exceptions.ServiceException;

public class Controller {

    static void controller() throws ApplicationException {

        try {
            Service.doSomething();
        } catch (ServiceException e) {
            e.printStackTrace();
            throw new ApplicationException("Произошла ошибка ApplicationException!!!");
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            try {
                Service.close();
            } catch (CloseException e) {
                e.printStackTrace();
            }
        }
    }
}
