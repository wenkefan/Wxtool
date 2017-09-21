package com.sanqi.wxtool.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wenke on 2017/9/18.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATANAME = "wxtool.db";
    private static final String TABLENAME= "Commodity";
    private static final int DATAVERSION = 1;

    private static SQLiteHelper helper;

    public static SQLiteHelper getInstance(Context context){

        if (helper == null){
            synchronized (SQLiteOpenHelper.class){
                if (helper == null){
                    helper = new SQLiteHelper(context) ;
                }

            }
        }
        return helper ;
    }


    /**
     *
     * @param context
     * @param name      数据库的名字
     * @param factory
     * @param version   数据库版本
     */
    public SQLiteHelper(Context context) {
        super(context, DATANAME, null, DATAVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLENAME +"(num_iid integer primary key,item_url varchar(100),pict_url varchar(100),provcity varchar(50),reserve_price varcher(20),title varchar(100),user_type integer,zk_final_price varchar(20),not_uploaded integer,uploaded integer )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
