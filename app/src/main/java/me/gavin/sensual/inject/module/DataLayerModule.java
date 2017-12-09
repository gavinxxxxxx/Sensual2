package me.gavin.sensual.inject.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.gavin.sensual.service.GankManager;
import me.gavin.sensual.service.SettingManager;
import me.gavin.sensual.service.base.DataLayer;

/**
 * DataLayerModule
 *
 * @author gavin.xiong 2017/4/28
 */
@Module
public class DataLayerModule {

    @Singleton
    @Provides
    public GankManager provideGankManager() {
        return new GankManager();
    }

    @Singleton
    @Provides
    public SettingManager provideSettingManager() {
        return new SettingManager();
    }

    @Singleton
    @Provides
    public DataLayer provideDataLayer(GankManager gankManager, SettingManager settingManager) {
        return new DataLayer(gankManager, settingManager);
    }
}
