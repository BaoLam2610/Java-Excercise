package helper;

import model.SinhVien;

import java.util.List;

public class Helper {

    public static int validateNumber(String str) {
        do {
            if (str.isEmpty() || str.isBlank())
                System.out.println("Truong nhap khong duoc bo trong");
            if (!str.matches("\\d+"))
                System.out.println("Truong nhap nay chi duoc nhap so");
        } while (str.isEmpty() || str.isBlank() || !str.matches("\\d+"));

        return Integer.parseInt(str);
    }

    public static String checkExit(String str, String temp) {
        if (str.equalsIgnoreCase("exit"))
            return temp;
        return str;
    }

    public static int checkExit(String str, int temp) {
        if (str.equalsIgnoreCase("exit"))
            return temp;
        return Integer.parseInt(str);
    }

    public static int timKiemHoTen(String str, List<SinhVien> svList) {
        int dem = 0;
        for (SinhVien sv : svList
        ) {
            if (sv.getHoTen().toLowerCase().contains(str))
                dem++;
        }
        return dem;
    }

    public static int timKiemNamSinh(String str, List<SinhVien> svList) {
        int dem = 0;
        for (SinhVien sv : svList
        ) {
            if ((sv.getNamSinh() + "").contains(str))
                dem++;
        }
        return dem;
    }

    public static int timKiemSoDt(String str, List<SinhVien> svList) {
        int dem = 0;
        for (SinhVien sv : svList
        ) {
            if (sv.getSoDt().contains(str))
                dem++;
        }
        return dem;
    }

    public static int timKiemChuyenNganh(String str, List<SinhVien> svList) {
        int dem = 0;
        for (SinhVien sv : svList
        ) {
            if (sv.getChuyenNganh().toLowerCase().contains(str))
                dem++;
        }
        return dem;
    }
}
