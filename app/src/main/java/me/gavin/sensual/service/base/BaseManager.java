package me.gavin.sensual.service.base;

import com.google.gson.Gson;

import javax.inject.Inject;

import me.gavin.sensual.inject.component.ApplicationComponent;
import me.gavin.sensual.net.ClientAPI;

/**
 * BaseManager
 *
 * @author gavin.xiong 2017/4/28
 */
public abstract class BaseManager {

    @Inject
    ClientAPI mApi;
    @Inject
    Gson mGson;

    public BaseManager() {
        ApplicationComponent.Instance.get().inject(this);
    }

    public ClientAPI getApi() {
        return mApi;
    }

    public Gson getGson() {
        return mGson;
    }
}
