package com.example.ql_tkb_phamthiyennhi;

public class MyKHOA {
    String maKhoa;
    String tenKhoa;

    //ham khoi tao
    public  MyKHOA(String makhoa, String tenkhoa){
        this.maKhoa=makhoa;
        this.tenKhoa=tenkhoa;
    }

    //thu tuc hien thi du lieu
    public String toString(){
        String msg="";
        msg+="Mã khoa: "+ this.maKhoa + "\n";
        msg+="Tên khoa: "+ this.tenKhoa;
        return msg;
    }
}
