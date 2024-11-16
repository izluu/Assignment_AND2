package izisluu.fpoly.assignment_and2.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class QLSPHelper extends SQLiteOpenHelper {
    public static final String DB_QLSANPHAM_NAME = "QuanLySanPham.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_SANPHAM = "SanPham";
    public static final String COLLUM_MASP = "MaSP";
    public static final String COLLUM_GIA = "Gia";
    public static final String COLLUM_SOLUONG = "SoLuong";
    public static final String COLLUM_TENSP = "TenSP";
    public static final String TABLE_USER = "User";
    public static final String COLLUM_USERNAME = "Username";
    public static final String COLLUM_PASSWORD = "Password";
    public static final String COLLUM_NAME = "Name";
    public QLSPHelper(@Nullable Context context) {
        super(context, DB_QLSANPHAM_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_SANPHAM + "(" + COLLUM_MASP + " TEXT PRIMARY KEY,"
                + COLLUM_TENSP + " TEXT," + COLLUM_GIA + " TEXT," + COLLUM_SOLUONG + " TEXT)";
        db.execSQL(sql);
        String sql2 = "CREATE TABLE " + TABLE_USER + "(" + COLLUM_USERNAME + " TEXT PRIMARY KEY,"
                + COLLUM_PASSWORD + " TEXT," + COLLUM_NAME + " TEXT)";
        db.execSQL(sql2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SANPHAM);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
            onCreate(db);
        }
    }

}
