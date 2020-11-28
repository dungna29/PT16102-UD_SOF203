/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B6_BaiMauDangCoBan;

/**
 *
 * @author LegendNguyen
 */
public class NganhHoc {
    private int Id;
    private String MaNganh;
    private String TenNganh;   

    public NganhHoc() {
    }

    public NganhHoc(int Id, String MaNganh, String TenNganh) {
        this.Id = Id;
        this.MaNganh = MaNganh;
        this.TenNganh = TenNganh;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getMaNganh() {
        return MaNganh;
    }

    public void setMaNganh(String MaNganh) {
        this.MaNganh = MaNganh;
    }

    public String getTenNganh() {
        return TenNganh;
    }

    public void setTenNganh(String TenNganh) {
        this.TenNganh = TenNganh;
    }

    @Override
    public String toString() {
        return "NganhHoc{" + "Id=" + Id + ", MaNganh=" + MaNganh + ", TenNganh=" + TenNganh + '}';
    }

   
    
    
}
