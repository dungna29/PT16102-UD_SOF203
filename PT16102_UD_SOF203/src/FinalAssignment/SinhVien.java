/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalAssignment;

/**
 *
 * @author LegendNguyen
 */
public class SinhVien {

    private int id;
    private int idNganhHoc;
    private String tenNganhHoc;
    private String maSv;
    private String email;
    private String password;
    private boolean status;

    public SinhVien() {
    }

    public SinhVien(int id, int idNganhHoc, String tenNganhHoc, String maSv, String email, String password, boolean status) {
        this.id = id;
        this.idNganhHoc = idNganhHoc;
        this.tenNganhHoc = tenNganhHoc;
        this.maSv = maSv;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNganhHoc() {
        return idNganhHoc;
    }

    public void setIdNganhHoc(int idNganhHoc) {
        this.idNganhHoc = idNganhHoc;
    }

    public String getTenNganhHoc() {
        return tenNganhHoc;
    }

    public void setTenNganhHoc(String tenNganhHoc) {
        this.tenNganhHoc = tenNganhHoc;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getStringStatus() {
        if (status) {
            return "Hoạt Động";
        } else {
            return "Không Hoạt Động";
        }
    }

}
