package me.gavin.sensual.service;

import java.util.List;

import io.reactivex.Observable;
import me.gavin.sensual.app.setting.License;
import me.gavin.sensual.service.base.BaseManager;
import me.gavin.sensual.service.base.DataLayer;
import okhttp3.ResponseBody;

/**
 * SettingManager
 *
 * @author gavin.xiong 2017/4/28
 */
public class SettingManager extends BaseManager implements DataLayer.SettingService {

    @Override
    public Observable<ResponseBody> download(String url) {
        return getApi().download(url);
    }

    @Override
    public Observable<List<License>> getLicense() {
        return getApi().getLicense();
    }
}
