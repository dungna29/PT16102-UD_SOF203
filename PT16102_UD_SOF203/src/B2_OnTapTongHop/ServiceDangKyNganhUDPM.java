/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B2_OnTapTongHop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LegendNguyen
 */
public class ServiceDangKyNganhUDPM implements IServiceDangKyNganhUDPM{
   //Khai báo 1 biến toàn cục là 1 danh sách sinh viên
    private List<SinhVien> lstSinhVien = new ArrayList<>();
    
    public ServiceDangKyNganhUDPM() {
    }
    //Đây là 1 class chứa toàn bộ các chức năng và nó dành cho việc xử lý nghiệp vụ phía dưới
    //Class Service luôn có 1 Contructor trên đầu

    @Override
    public boolean themSV(SinhVien sv) {
       return true;
    }

    @Override
    public boolean xoaSV(int indexSV) {
       return true;
    }

    @Override
    public boolean luuFileSV(List<SinhVien> lstSinhVien) {
        return true;
    }

    @Override
    public boolean moFileSV() {
        return true;
    }

    //Hàm này trả về 1 danh sách sinh viên khi được gọi ở phần View
    @Override
    public List<SinhVien> getListSinhVien() {
       return lstSinhVien;
    }

    @Override
    public int getIndexSV(String maSV) {
        return 0;
    }
    
}
