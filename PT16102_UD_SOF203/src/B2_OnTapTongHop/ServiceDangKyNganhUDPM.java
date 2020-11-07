/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B2_OnTapTongHop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LegendNguyen
 */
public class ServiceDangKyNganhUDPM implements IServiceDangKyNganhUDPM {
    //Khai báo 1 biến toàn cục là 1 danh sách sinh viên

    private List<SinhVien> lstSinhVien = new ArrayList<>();
    static File file = new File("dataJAVA3.txt");//Đặt tên mặc định cho file

    public ServiceDangKyNganhUDPM() {
    }
    //Đây là 1 class chứa toàn bộ các chức năng và nó dành cho việc xử lý nghiệp vụ phía dưới
    //Class Service luôn có 1 Contructor trên đầu

    @Override
    public boolean themSV(SinhVien sv) {
        if (sv != null) {
            lstSinhVien.add(sv);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean xoaSV(int indexSV) {
        if (indexSV < 0) {
            return false;
        }
        lstSinhVien.remove(indexSV);//Hàm xóa theo index trong List
        return true;
    }

    @Override
    public boolean luuFileSV() {
        try {
            int count = 0;
            checkFile();
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                
                try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                    for (SinhVien x : lstSinhVien) {
                        oos.writeObject(x);
                        count++;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (count == 0) {
                return false;
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public boolean moFileSV() {
        try {
            checkFile();
            if (!file.exists()) {
                return false;
            }
            lstSinhVien = new ArrayList<>();//Tại sao lại new List ở đây
            try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                while (ois.hashCode() > -1) {
                    lstSinhVien.add((SinhVien) ois.readObject());
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
        }

    //Hàm này trả về 1 danh sách sinh viên khi được gọi ở phần View
    @Override
    public List<SinhVien> getListSinhVien() {
        return lstSinhVien;
    }

    @Override
    public int getIndexSV(String maSV) {//Tham số truyền vào là mã sinh viên
        for (int i = 0; i < lstSinhVien.size(); i++) {
            if (lstSinhVien.get(i).getMaSV().equalsIgnoreCase(maSV)) {
                return i;//Trả ra index nếu tìm thấy sinh viên đó có trong danh sách theo mã sinh viên
            }
        }
        return -1;//Trả về kết quả -1 khi không tìm thấy sinh viên đó có trong lớp

    }
    
      //Kiểm tra sự tồn tại của file đã có hay chưa nếu chưa có thì sẽ tạo file mới
    void checkFile() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }

}
