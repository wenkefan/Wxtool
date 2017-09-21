package com.sanqi.wxtool.base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.sanqi.wxtool.data.SQLiteHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wenke on 2017/9/18.
 */

public class CommodityDao implements Serializable {

    private static final String TABLENAME= "Commodity";

    private static CommodityDao dao;
    private Context context;
    private SQLiteHelper openHelper;


    public static CommodityDao getInstance(Context context) {
        if (dao == null) {
            synchronized (CommodityDao.class) {
                if (dao == null) {
                    dao = new CommodityDao(context);
                }
            }
        }
        return dao;
    }

    private CommodityDao(Context context) {
        this.context = context;
        openHelper = SQLiteHelper.getInstance(context);
    }

    /**
     * 批量增加
     *
     * @param list
     */
    public int insert(CommodityBase list) {
        SQLiteDatabase db = openHelper.getWritableDatabase();
        for (CommodityBase.NTbkItemBean base : list.getN_tbk_item()) {
            try {
                db.beginTransaction();
                long num_iid = base.getNum_iid();
                String item_url = base.getItem_url();
                String pict_url = base.getPict_url();
                String provcity = base.getProvcity();
                String reserve_price = base.getReserve_price();
                String title = base.getTitle();
                int user_type = base.getUser_type();
                String zk_final_price = base.getZk_final_price();
                //额外添加的两个字段
                int not_uploaded = 0;//未上传  0/1
                int uploaded = 0;//已上传
                db.execSQL("insert into Commodity(num_iid,item_url,pict_url,provcity,reserve_price,title,user_type,zk_final_price,not_uploaded,uploaded)values(?,?,?,?,?,?,?,?,?,?)",
                        new Object[]{num_iid,item_url,pict_url,provcity,reserve_price,title,user_type,zk_final_price,not_uploaded,uploaded});
                db.setTransactionSuccessful();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        db.endTransaction();
        db.close();
        return -1;
    }

    /**
     * 批量增加
     *
     * @param map
     */
    public void insert(Map<String, CommodityBase> map) {

    }

    /**
     * 单个增加
     *
     * @param base
     */
    public void insert(CommodityBase.NTbkItemBean base) {
        SQLiteDatabase db = openHelper.getWritableDatabase();
        try {
            db.beginTransaction();
            long num_iid = base.getNum_iid();
            String item_url = base.getItem_url();
            String pict_url = base.getPict_url();
            String provcity = base.getProvcity();
            String reserve_price = base.getReserve_price();
            String title = base.getTitle();
            int user_type = base.getUser_type();
            String zk_final_price = base.getZk_final_price();
            //额外添加的两个字段
            int not_uploaded = 0;//未上传  0/1
            int uploaded = 0;//已上传
            db.execSQL("insert into AttendanceRecord(item_url,num_iid,pict_url,provcity,reserve_price,title,user_type,zk_final_price,not_uploaded,uploaded)values(?,?,?,?,?,?,?,?,?,?)",
                    new Object[]{num_iid,item_url,pict_url,provcity,reserve_price,title,user_type,zk_final_price,not_uploaded,uploaded});
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
        db.close();
    }

    /**
     * 查询未发送和已发送
     *
     * @param not_uploaded
     * @param uploaded
     */
    public List<CommodityBase.NTbkItemBean> query(int not_uploaded, int uploaded) {
        SQLiteDatabase db = openHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLENAME +
                 " where not_uploaded = ? and uploaded = ?",
                new String[]{String.valueOf(not_uploaded), String.valueOf(uploaded)});
        List<CommodityBase.NTbkItemBean> bases = new ArrayList<>();
        if (cursor.moveToNext()){
            CommodityBase.NTbkItemBean base = new CommodityBase.NTbkItemBean();
            base.setNum_iid(cursor.getLong(cursor.getColumnIndex("num_iid")));
            base.setItem_url(cursor.getString(cursor.getColumnIndex("item_url")));
            base.setPict_url(cursor.getString(cursor.getColumnIndex("pict_url")));
            base.setProvcity(cursor.getString(cursor.getColumnIndex("provcity")));
            base.setReserve_price(cursor.getString(cursor.getColumnIndex("reserve_price")));
            base.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            base.setUser_type(cursor.getInt(cursor.getColumnIndex("user_type")));
            base.setZk_final_price(cursor.getString(cursor.getColumnIndex("zk_final_price")));
            base.setNot_uploaded(cursor.getInt(cursor.getColumnIndex("not_uploaded")));
            base.setUploaded(cursor.getInt(cursor.getColumnIndex("uploaded")));
            bases.add(base);
        }
        return bases;
    }

    /**
     * 修改未发送为已发送
     *
     * @param id
     */
    public void update(int id) {
        SQLiteDatabase db = openHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("uploaded", 1);
        db.update(TABLENAME,values,"num_iid = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    /**
     * 根据num_iid删除单个数据
     *
     * @param id
     */
    public void delect(int id) {

    }

    /**
     * 根据对象删除单个数据
     *
     * @param base
     */
    public void delect(CommodityBase base) {

    }

    /**
     * 批量删除数据
     *
     * @param map
     */
    public void delect(Map<String, CommodityBase> map) {

    }

    /**
     * 批量删除数据
     *
     * @param list
     */
    public void delect(List<CommodityBase> list) {
        SQLiteDatabase db = openHelper.getReadableDatabase();

    }

    public void delect(String tableName) {
        SQLiteDatabase db = openHelper.getReadableDatabase();
        db.execSQL("delect from" + tableName);
        db.close();
    }
}
