package com.practice.tiger.tigerstructure.db;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

/**
 * Author：NaShichao
 * Time：2017/1/10  上午11:56
 * Email：na.shichao@163.com
 * Description：
 */

public class BaseDaoFactory {
    private String sqLiteDatabasePath;
    private SQLiteDatabase sqLiteDatabase;

    private static BaseDaoFactory instance = new BaseDaoFactory();

    private BaseDaoFactory() {
        sqLiteDatabasePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/user.db";
        openDataBase();
    }

    public synchronized <T extends BaseDao<M>, M> T getDataHelper(Class<T> clazz, Class<M> entity) {
        BaseDao baseDao = null;
        try {
            baseDao = clazz.newInstance();
            baseDao.init(entity, sqLiteDatabase);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return (T) baseDao;
    }

    private void openDataBase() {
        this.sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(sqLiteDatabasePath, null);
    }

    public static BaseDaoFactory getInstance() {
        return instance;
    }
}
