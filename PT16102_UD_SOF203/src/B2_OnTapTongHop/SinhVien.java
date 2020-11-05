/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B2_OnTapTongHop;

import java.io.Serializable;

/**
 *
 * @author LegendNguyen
 */
public class SinhVien implements Serializable{
    //Phần 1: Thuộc tính luôn được đặt ở trên đầu
    private String MaSV;
    private String Ten;
    private String Nganh;
    //Phần 2: Khai báo 2 Contructor

    public SinhVien() {
    }

    public SinhVien(String MaSV, String Ten, String Nganh) {
        this.MaSV = MaSV;
        this.Ten = Ten;
        this.Nganh = Nganh;
    }
    
    //Phần 3: Phần Getter và Setter

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getNganh() {
        return Nganh;
    }

    public void setNganh(String Nganh) {
        this.Nganh = Nganh;
    }
    
    //Phần 4: Các hàm đặc trưng cho đối tượng

    @Override
    public String toString() {
        return "SinhVien{" + "MaSV=" + MaSV + ", Ten=" + Ten + ", Nganh=" + Nganh + '}';
    }
    
}
