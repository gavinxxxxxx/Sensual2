package me.gavin.sensual.service.base;

import android.support.v4.app.Fragment;

import java.util.List;

import io.reactivex.Observable;
import me.gavin.sensual.app.common.Image;
import me.gavin.sensual.app.setting.License;
import okhttp3.ResponseBody;

/**
 * DataLayer
 *
 * @author gavin.xiong 2017/4/28
 */
public class DataLayer {

    private GankService mGankService;
    private SettingService mSettingService;

    public DataLayer(GankService gankService,
                     SettingService settingService) {
        mGankService = gankService;
        mSettingService = settingService;
    }

    public GankService getGankService() {
        return mGankService;
    }

    public SettingService getSettingService() {
        return mSettingService;
    }

    public interface GankService {
        Observable<Image> getImage(Fragment fragment, int limit, int no);
    }

    public interface SettingService {
        Observable<ResponseBody> download(String url);

        Observable<List<License>> getLicense();
    }

}
