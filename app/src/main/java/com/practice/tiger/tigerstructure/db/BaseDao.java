package com.practice.tiger.tigerstructure.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.practice.tiger.tigerstructure.db.annotion.DbFiled;
import com.practice.tiger.tigerstructure.db.annotion.DbTable;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Author：NaShichao
 * Time：2017/1/10  下午12:04
 * Email：na.shichao@163.com
 * Description：
 */

public class BaseDao<T> implements IBaseDao<T> {

    private SQLiteDatabase sqLiteDatabase;
    /*
     * 保证实例化一次
     */
    private boolean isInit = false;
    /*
     * 持有操作数据库表所对应的java类型
     */
    private Class<T> entity;
    private String tableName;
    /**
     * 维护表名与成员变量的映射关系
     * key      表名
     * value    Field
     */
    private HashMap<String, Field> cacheMap;

    protected boolean init(Class<T> entity, SQLiteDatabase sqLiteDatabase) {
        if (!isInit) {
            this.sqLiteDatabase = sqLiteDatabase;
            this.entity = entity;
            if (entity.getAnnotation(DbTable.class) == null) {
                tableName = entity.getClass().getSimpleName();
            } else {
                tableName = entity.getAnnotation(DbTable.class).value();
            }
            if (!sqLiteDatabase.isOpen()) {
                return false;
            }
            cacheMap = new HashMap<>();
            initCacheMap();
            isInit = true;
        }
        return isInit;
    }

    /**
     * 维护映射关系
     */
    private void initCacheMap() {
        String sql = "select * from " + this.tableName + " limit 1 , 0";
        Cursor cursor = null;

        try {
            cursor = sqLiteDatabase.rawQuery(sql, null);
            String[] columnNames = cursor.getColumnNames();// 表名

            Field[] columnFields = entity.getFields();// Field数组
            for (Field field : columnFields) {
                field.setAccessible(true);
            }
            /**
             * 开始找对应关系
             */
            for (String columnName : columnNames) {
                /**
                 * 如果找到对应的 Field 就赋值给他
                 */
                Field columnField = null;
                for (Field field : columnFields) {
                    String fieldName = null;
                    if (field.getAnnotation(DbFiled.class) != null) {
                        fieldName = field.getAnnotation(DbFiled.class).value();
                    } else {
                        fieldName = field.getName();
                    }
                    /**
                     * 如果表的列名 等于 成员变量的注解名字
                     */
                    if (fieldName.equals(columnName)) {
                        columnField = field;
                        break;
                    }
                }
                if (columnField != null) {
                    cacheMap.put(columnName, columnField);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override
    public Long insert(T entity) {
        Map<String, String> map = getValues(entity);
        ContentValues values = getContentValues(map);
        Long result = sqLiteDatabase.insert(tableName, null, values);
        return result;
    }

    private ContentValues getContentValues(Map<String, String> map) {
        ContentValues contentValues = new ContentValues();
        Set keys = map.entrySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = map.get(key);
            if (value != null) {
                contentValues.put(key, value);
            }
        }
        return null;
    }

    private Map<String, String> getValues(T entity) {
        HashMap<String, String> result = new HashMap<>();
        Iterator<Field> fieldIterator = cacheMap.values().iterator();
        while (fieldIterator.hasNext()) {
            Field columnField = fieldIterator.next();
            String cacheKey = null;
            String cacheValue = null;
            if (columnField.getAnnotation(DbFiled.class) != null) {
                cacheKey = columnField.getAnnotation(DbFiled.class).value();
            } else {
                cacheKey = columnField.getName();
            }
            try {
                if (null == columnField.get(entity)) {
                    continue;
                }
                cacheValue = columnField.get(entity).toString();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            result.put(cacheKey, cacheValue);
        }
        return result;
    }

    @Override
    public Long update(T entity, T where) {
        return null;
    }
}
