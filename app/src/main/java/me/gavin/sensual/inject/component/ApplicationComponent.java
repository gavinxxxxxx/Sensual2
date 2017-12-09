package me.gavin.sensual.inject.component;

import android.app.Application;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Component;
import me.gavin.sensual.base.BaseActivity;
import me.gavin.sensual.base.BaseFragment;
import me.gavin.sensual.base.BaseViewModel;
import me.gavin.sensual.inject.module.ApplicationModule;
import me.gavin.sensual.service.base.BaseManager;

/**
 * ApplicationComponent
 *
 * @author gavin.xiong 2017/4/28
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseActivity activity);

    void inject(BaseFragment fragment);

    void inject(BaseViewModel viewModel);

//    void inject(BaseDialogFragment dialogFragment);

    void inject(BaseManager manager);

    // 可以获取 ApplicationModule 及其 includes 的所有 Module 提供的对象（方法名随意）
    Application getApplication();

    class Instance {

        private static ApplicationComponent sComponent;

        public static void init(@NonNull ApplicationComponent component) {
            sComponent = component;
        }

        public static ApplicationComponent get() {
            return sComponent;
        }
    }
}
