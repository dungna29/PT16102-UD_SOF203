/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B5_ThucHanhTrenSwing;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LegendNguyen
 */
public class ServiceNganhHoc {
    DAONganhHoc _dAONganhHoc = new DAONganhHoc();
    List<NganhHoc> _lstNganhHoc;
    public ServiceNganhHoc() {
      _lstNganhHoc = _dAONganhHoc.getListNganhHocDB();
    }
    
    //Hàm lấy danh sách sinh viên
    List<NganhHoc> getLstNganhHoc(){  
        return _lstNganhHoc;
    }
    boolean addNganhHoc(NganhHoc nganhHoc){
        if (nganhHoc == null) {
            return false;
        }
        _lstNganhHoc.add(nganhHoc); 
        return true;
        
    }
    boolean saveNganhHoc(){
        _dAONganhHoc.insertNganhHocToDB(_lstNganhHoc);
        _lstNganhHoc = new ArrayList<>();        
        return true;
    }
}
