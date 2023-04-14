package com.example.ql_tkb_phamthiyennhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CSDLile extends AppCompatActivity {

    String nameDB = "qltkb.db"; //Khai báo tên Database
    SQLiteDatabase database;
    Button btnCreateDB, btnDeleteDB, btnTblKHOA, btnTblGIANGVIEN, btnKHOA, btnGIANGVIEN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csdlile);

        btnCreateDB = (Button) findViewById(R.id.btnCreateDB);
        btnDeleteDB = (Button) findViewById(R.id.btnDeleteDB);
        btnTblKHOA = (Button) findViewById(R.id.btnTblKHOA);
        btnTblGIANGVIEN = (Button) findViewById(R.id.btnTblGIANGVIEN);
        btnKHOA = (Button) findViewById(R.id.btnKHOA);
        btnGIANGVIEN = (Button) findViewById(R.id.btnGIANGVIEN);

        //Gọi hàm tạo Database
        btnCreateDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doCreateDB(nameDB);
            }
        });
        //Gọi hàm xóa Database
        btnDeleteDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doDeleteBD(nameDB);
            }
        });

//Tạo Table KHOA
        btnTblKHOA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sql = "CREATE TABLE tblKHOA (MAKHOA TEXT PRIMARY KEY,TENKHOA TEXT);";
                if (doAction(sql) == true) {
                    Toast.makeText(CSDLile.this, "Tạo Table [KHOA] thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CSDLile.this, "Tạo Table [KHOA] [KHÔNG] thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Tạo Table GIANGVIEN
        btnTblGIANGVIEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sql = "CREATE TABLE tblGIANGVIEN (MAGV TEXT PRIMARY KEY,TENGV TEXT, PHAI TEXT, NGAYSINH TEXT, DIACHI TEXT, MAKHOA TEXT, FOREIGN KEY (MAKHOA) REFERENCES tblKHOA(MAKHOA));";
                if (doAction(sql) == true) {
                    Toast.makeText(CSDLile.this, "Tạo Table [GIANGVIEN] thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CSDLile.this, "Tạo Table [GIANGVIEN] [KHÔNG] thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });


    //sang trang
        btnKHOA.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
        Intent intent = new Intent(CSDLile.this, KHOAActivity.class);
        startActivity(intent);
    }
    });
}


    //Tạo hàm sử dụng cho Insert, Update, Delete, Create Table
    public boolean doAction (String sql)
    {
        try
        {
            database = openOrCreateDatabase(nameDB, MODE_PRIVATE,null);
            database.execSQL(sql);
            return true;
        }
        catch(Exception ex){
            return false;
        }
        finally {
            database.close();
        }
    }

    //Tạo Database
    public void doCreateDB(String nameDB){

        try {

            database = openOrCreateDatabase(nameDB,MODE_PRIVATE,null);
            Toast.makeText(CSDLile.this,"Tạo [Database] thành công",Toast.LENGTH_SHORT).show();
        }

        catch (Exception ex)
        {
            Toast.makeText(CSDLile.this,"Tạo [Database] [KHÔNG] thành công",Toast.LENGTH_SHORT).show();
        }

    }
    //Xóa Database
    public void doDeleteBD(String nameDB) {
        String msg = "";
        try {
            if (deleteDatabase(nameDB) == true) {
                msg = "Xóa [Database] thành công";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

            }
        } catch (Exception ex) {
            Toast.makeText(this, "Xóa [Database] [KHÔNG] thành công", Toast.LENGTH_LONG).show();
        }
    }
}