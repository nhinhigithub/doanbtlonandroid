package com.example.ql_tkb_phamthiyennhi;

public class MyGIANGVIEN {
    String maGV;
    String tenGV;
    String Phai;
    String Ngaysinh;
    String Diachi;
    String maKhoa;
    //ham khoi tao
    public  MyGIANGVIEN(String magv, String tengv,String phai, String ngaysinh,String diachi, String makhoa ){
        this.maGV=magv;
        this.tenGV=tengv;
        this.Phai=phai;
        this.Ngaysinh=ngaysinh;
        this.Diachi=diachi;
        this.maKhoa=makhoa;
    }

    //thu tuc hien thi du lieu
    public String toString(){
        String msg="";
        msg+="Mã giảng viên: "+ this.maGV + "\n";
        msg+="Tên giảng viên: "+ this.tenGV + "\n";
        msg+="Phái: "+ this.Phai + "\n";
        msg+="Ngày sinh: "+ this.Ngaysinh + "\n";
        msg+="Địa chỉ: "+ this.Diachi + "\n";
        msg+="Mã khoa: "+ this.maKhoa;
        return msg;
    }
}
