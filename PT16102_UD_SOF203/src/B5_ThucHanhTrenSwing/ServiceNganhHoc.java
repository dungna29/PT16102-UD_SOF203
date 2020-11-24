/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B5_ThucHanhTrenSwing;

import java.util.List;

/**
 *
 * @author LegendNguyen
 */
public class ServiceNganhHoc {
    DAONganhHoc dAONganhHoc = new DAONganhHoc();
    List<NganhHoc> lstNganhHoc;
    public ServiceNganhHoc() {
        lstNganhHoc = dAONganhHoc.getListNganhHocDB();
    }
    public static void main(String[] args) {
        ServiceNganhHoc serviceNganhHoc = new ServiceNganhHoc();
        for (var x : serviceNganhHoc.lstNganhHoc) {
            System.out.println(x.toString());
        }
    }
}
