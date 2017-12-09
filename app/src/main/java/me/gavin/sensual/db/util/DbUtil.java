package me.gavin.sensual.db.util;


import me.gavin.sensual.db.dao.CollectionDao;
import me.gavin.sensual.db.service.CollectionService;
import me.gavin.sensual.inject.component.ApplicationComponent;

/**
 * GreenDao 数据库管理助手
 *
 * @author lizhangqu(513163535@qq.com) 2015/9/01
 */
public class DbUtil {

    private static CollectionService collectionService;

    private static CollectionDao getSearchHistoryDao() {
        return DbCore.getDaoSession(ApplicationComponent.Instance.get().getApplication()).getCollectionDao();
    }

    public static CollectionService getCollectionService() {
        if (collectionService == null) {
            collectionService = new CollectionService(getSearchHistoryDao());
        }
        return collectionService;
    }
}
