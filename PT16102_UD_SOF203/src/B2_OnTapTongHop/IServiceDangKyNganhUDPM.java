/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B2_OnTapTongHop;

import java.util.List;

/**
 *
 * @author LegendNguyen
 */
public interface IServiceDangKyNganhUDPM {

    //Hàm thêm sinh viên của chương trình
    boolean themSV(SinhVien sv);

    //Hàm hóa sinh viên trong danh sách
    boolean xoaSV(int indexSV);

    //Hàm Save File
    boolean luuFileSV();

    //Hàm Open File
    boolean moFileSV();
    
    List<SinhVien> getListSinhVien();//Hàm này sẽ trả ra 1 danh sách sinh viên
    
    int getIndexSV(String maSV);//Trả ra vị trí của đối tượng sinh viên cần tìm có trong List
}
