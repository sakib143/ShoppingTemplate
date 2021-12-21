package com.innomalist.taxi.shoppingapp.base;


import com.innomalist.taxi.shoppingapp.ModelInterface;
import com.innomalist.taxi.shoppingapp.PresenterInterface;
import com.innomalist.taxi.shoppingapp.data.source.AppRepository;

public abstract class BasePresenter implements PresenterInterface {
    protected AppRepository appRepository = BaseApplication.getAppRepository();

    public void close() {
        ModelInterface modelInterface = getModelInterface();
        if (modelInterface != null) {
            modelInterface.close();
        }
    }
}
