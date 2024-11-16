package izisluu.fpoly.assignment_and2.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Array;
import java.util.ArrayList;

import izisluu.fpoly.assignment_and2.Database.QLSPHelper;
import izisluu.fpoly.assignment_and2.Model.SanPham;
import izisluu.fpoly.assignment_and2.Model.User;

public class DbDAO {
    private QLSPHelper helper;
    private SQLiteDatabase database;


    public DbDAO(Context context) {
        helper = new QLSPHelper(context);
        database = helper.getWritableDatabase();
    }

    @SuppressLint("Range")
    public ArrayList<User> getUser() {
        ArrayList<User> lst = new ArrayList<>();
        String sql = "SELECT * FROM" + helper.TABLE_USER;

        Cursor cursor = database.rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                User user = new User();
                user.setName(cursor.getString(cursor.getColumnIndex(helper.COLLUM_NAME)));
                user.setUsername(cursor.getString(cursor.getColumnIndex(helper.COLLUM_USERNAME)));
                user.setPasswword(cursor.getString(cursor.getColumnIndex(helper.COLLUM_PASSWORD)));
                lst.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return lst;
    }

    public Boolean addUser(User user) {
        ContentValues values = new ContentValues();
        values.put(helper.COLLUM_NAME, user.getName());
        values.put(helper.COLLUM_USERNAME, user.getUsername());
        values.put(helper.COLLUM_PASSWORD, user.getPasswword());
        long result = database.insert(helper.TABLE_USER, null, values);
        return result != -1;
    }

    public Boolean updateUser(User user) {
        ContentValues values = new ContentValues();
        values.put(helper.COLLUM_NAME, user.getName());
        values.put(helper.COLLUM_USERNAME, user.getUsername());
        values.put(helper.COLLUM_PASSWORD, user.getPasswword());
        int row = database.update(helper.TABLE_USER, values, helper.COLLUM_USERNAME + "=?", new String[]{user.getUsername()});
        return row > 0;
    }

    public Boolean deleteUser(String username) {

        int row = database.delete(helper.TABLE_USER, helper.COLLUM_USERNAME + "=?", new String[]{username});
        return row > 0;
    }
    @SuppressLint("Range")
    public ArrayList<SanPham> getSanPham() {
        ArrayList<SanPham> lst = new ArrayList<>();
        String sql = "SELECT * FROM" + helper.TABLE_SANPHAM;
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do {
                SanPham sp = new SanPham();
                sp.setGia(cursor.getString(cursor.getColumnIndex(helper.COLLUM_GIA)));
                sp.setMaSP(cursor.getString(cursor.getColumnIndex(helper.COLLUM_MASP)));
                sp.setSoLuong(cursor.getString(cursor.getColumnIndex(helper.COLLUM_SOLUONG)));
                sp.setTenSP(cursor.getString(cursor.getColumnIndex(helper.COLLUM_TENSP)));
                lst.add(sp);

            }while (cursor.moveToNext());
        }
        cursor.close();
        return lst;
    }
    public Boolean addSP(SanPham sp) {
        ContentValues values = new ContentValues();
        values.put(helper.COLLUM_MASP, sp.getMaSP());
        values.put(helper.COLLUM_TENSP, sp.getTenSP());
        values.put(helper.COLLUM_GIA, sp.getGia());
        values.put(helper.COLLUM_SOLUONG, sp.getSoLuong());
        long result = database.insert(helper.TABLE_SANPHAM, null, values);
        return result != -1;
    }
    public Boolean updateSP(SanPham sp) {
        ContentValues values = new ContentValues();
        values.put(helper.COLLUM_MASP, sp.getMaSP());
        values.put(helper.COLLUM_TENSP, sp.getTenSP());
        values.put(helper.COLLUM_GIA, sp.getGia());
        values.put(helper.COLLUM_SOLUONG, sp.getSoLuong());
        int row = database.update(helper.TABLE_SANPHAM, values, helper.COLLUM_MASP + "=?", new String[]{sp.getMaSP()});
        return row > 0;

    }
    public Boolean deleteSP(String masp) {
        int row = database.delete(helper.TABLE_SANPHAM, helper.COLLUM_MASP + "=?", new String[]{masp});
        return row > 0;
    }

}
