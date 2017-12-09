package me.gavin.sensual.service;

import android.support.v4.app.Fragment;

import io.reactivex.Observable;
import me.gavin.sensual.app.common.Image;
import me.gavin.sensual.app.gank.Result;
import me.gavin.sensual.service.base.BaseManager;
import me.gavin.sensual.service.base.DataLayer;

/**
 * DailyManager
 *
 * @author gavin.xiong 2017/4/28
 */
public class GankManager extends BaseManager implements DataLayer.GankService {

    @Override
    public Observable<Image> getImage(Fragment fragment, int limit, int no) {
        return getApi().getGankImage(limit, no)
                .map(Result::getResults)
                .flatMap(Observable::fromIterable)
                .map(image -> Image.newImage(fragment, image.getUrl()));
    }
}
