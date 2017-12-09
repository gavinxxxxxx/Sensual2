package me.gavin.sensual.base;

import android.app.Application;

import me.gavin.sensual.BuildConfig;
import me.gavin.sensual.db.util.DbCore;
import me.gavin.sensual.inject.component.ApplicationComponent;
import me.gavin.sensual.inject.component.DaggerApplicationComponent;
import me.gavin.sensual.inject.module.ApplicationModule;
import me.yokeyword.fragmentation.Fragmentation;

/**
 * 自定义 Application
 *
 * @author gavin.xiong 2017/4/25
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
        DbCore.init(this);
        Fragmentation.builder()
                .stackViewMode(Fragmentation.BUBBLE)
                .debug(BuildConfig.DEBUG)
                .handleException(e -> {
                    // TODO: 2017/12/9
                })
                .install();
    }

    private void initDagger() {
        ApplicationComponent.Instance.init(DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build());
    }
}
