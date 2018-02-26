package proxy;

import exceptions.AppException;

import java.io.IOException;

public interface MyAction {

    Object invoke() throws AppException, IOException;
}
