package model;

import helper.Helper;
import helper.HelperException;
import helper.PhoneException;

import java.util.*;

public class DanhSachSinhVien {
    private final List<SinhVien> svList;
    Scanner sc = new Scanner(System.in);

    public DanhSachSinhVien() {
        svList = new ArrayList<>();
        svList.add(new SinhVien("Lam", 2000, "0945676638", "IT", "Dai Hoc"));
        svList.add(new SinhVien("Nam", 2001, "321654", "May", "Cao Dang"));
        svList.add(new SinhVien("Minh", 2003, "562345", "Thoi trang", "Dai Hoc"));
        svList.add(new SinhVien("Lam", 1999, "1234521", "Du lich", "Cao Dang"));
        svList.add(new SinhVien("Trang", 2002, "4578654", "Dien", "Dai Hoc"));
        svList.add(new SinhVien("Thao", 2001, "454532", "Co Khi", "Cao Dang"));
    }

    public static void inTieuDeHienThi() {
        System.out.printf("%5s %15s %15s %20s %n", "STT", "Ho Ten", "So DT", "He Dai hoc");
    }

    public static void inTieuDeDayDu() {
        System.out.printf("%5s %15s %15s %15s %20s %20s %n", "STT", "Ho Ten", "Nam sinh", "So DT", "Chuyen nganh", "He Dai hoc");
    }

    public boolean kiemTraSoDt(String soDt) {
        SinhVien sv = new SinhVien(soDt);
        return svList.contains(sv);
    }

    public void themSinhVien() {
        String hoTen = null, soDt = null, chuyenNganh = null;
        int namSinh = -1;
        SinhVien sv;
        do {
            try {
                sv = new SinhVien();
                if (hoTen == null) {
                    System.out.print("Nhap ten sinh vien: ");
                    hoTen = sc.nextLine();
                }
                sv.setHoTen(hoTen);
                if (namSinh == -1) {
                    System.out.print("Nhap nam sinh: ");
                    namSinh = sc.nextInt();
                    sc.nextLine();
                }
                sv.setNamSinh(namSinh);
                if (soDt == null) {
                    System.out.print("Nhap so dien thoai: ");
                    soDt = sc.nextLine();
                    sv.setSoDt(soDt);
                    if (kiemTraSoDt(soDt))
                        throw new PhoneException("So dien thoai da ton tai");
                } else
                    sv.setSoDt(soDt);
                if (chuyenNganh == null) {
                    System.out.print("Nhap chuyen nganh: ");
                    chuyenNganh = sc.nextLine();
                }
                sv.setChuyenNganh(chuyenNganh);
                System.out.print("Nhap he dai hoc (1 - he Cao Dang , con lai - he Dai Hoc): ");
                sv.setHeDh(sc.nextLine().equals("1") ? "Cao Dang" : "Dai Hoc");
                svList.add(sv);
                System.out.println("Them thanh cong sinh vien");
            } catch (InputMismatchException e) {
                System.out.println("Nhap sai dinh dang");
                sc.nextLine();
                namSinh = -1;
                sv = null;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                sv = null;
                if (e instanceof HelperException && hoTen == null)
                    hoTen = null;
                if (e instanceof HelperException && namSinh < 0 || namSinh > Calendar.getInstance().get(Calendar.YEAR))
                    namSinh = -1;
                if (e instanceof PhoneException)
                    soDt = null;
                chuyenNganh = null;
            }
        } while (sv == null);
    }

    public void suaThongTin() {
        List<Integer> vt = new ArrayList<>();
        System.out.print("Nhap ten sinh vien can sua: ");
        String ten = sc.nextLine().toLowerCase();
        if (Helper.timKiemHoTen(ten, svList) == 0) {
            System.out.println("Khong tim thay sinh vien ten " + ten);
            return;
        } else {
            System.out.println("- Danh sach sinh vien co ten la " + ten + " : ");
            inTieuDeDayDu();
            for (int i = 0; i < svList.size(); i++) {
                if (svList.get(i).getHoTen().toLowerCase().contains(ten)) {
                    System.out.printf("%5s %s", (i + 1), svList.get(i).hienThiDayDu());
                    vt.add(i + 1);
                }
            }
            System.out.print("Nhap vao vi tri can sua: ");
            int index = Helper.validateNumber(sc.nextLine());
            if (index > 0 && vt.contains(index)) {
                String hoTen = null, soDt = null, chuyenNganh = null, heDh = null;
                int namSinh = -1;
                SinhVien sv;
                do {
                    try {
                        sv = svList.get(index - 1);
                        if (hoTen == null) {
                            System.out.print("Nhap ten sinh vien (co the nhap exit de bo qua): ");
                            hoTen = Helper.checkExit(sc.nextLine(), sv.getHoTen());
                        }
                        sv.setHoTen(hoTen);
                        if (namSinh == -1) {
                            System.out.print("Nhap nam sinh (co the nhap exit de bo qua): ");
                            namSinh = Helper.checkExit(sc.nextLine(), sv.getNamSinh());
                        }
                        sv.setNamSinh(namSinh);
                        if (soDt == null) {
                            System.out.print("Nhap so dien thoai (co the nhap exit de bo qua): ");
                            soDt = sc.nextLine();
                            if (!soDt.equals("exit")) {
                                if (kiemTraSoDt(soDt))
                                    throw new PhoneException("So dien thoai da ton tai");
                            } else
                                soDt = sv.getSoDt();
                        }
                        sv.setSoDt(soDt);
                        if (chuyenNganh == null) {
                            System.out.print("Nhap chuyen nganh (co the nhap exit de bo qua): ");
                            chuyenNganh = Helper.checkExit(sc.nextLine(), sv.getChuyenNganh());
                        }
                        sv.setChuyenNganh(chuyenNganh);

                        System.out.print("Nhap he dai hoc (1 - he Cao Dang , con lai - he Dai Hoc , exit - bo qua): ");
                        heDh = sc.nextLine();
                        heDh = heDh.equals("1") ? "Cao Dang" : (heDh.equals("2") ? "Dai Hoc" : sv.getHeDh());
                        sv.setHeDh(heDh);
                        svList.set(index - 1, sv);
                        System.out.println("Sua thong tin sinh vien thanh cong");
                        vt.clear();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        if (e instanceof HelperException && hoTen.isEmpty() || hoTen.isBlank())
                            hoTen = null;
                        if (e instanceof HelperException && namSinh < 0 || namSinh > Calendar.getInstance().get(Calendar.YEAR))
                            namSinh = -1;
                        if (e instanceof PhoneException)
                            soDt = null;
                        chuyenNganh = null;
                        sv = null;
                    }
                } while (sv == null);
            } else {
                System.out.println("Vi tri nhap sai!");
            }
        }
    }

    public void xoaSinhVien() {
        List<Integer> vt = new ArrayList<>();
        System.out.print("Nhap ten sinh vien can xoa: ");
        String ten = sc.nextLine().toLowerCase();
        if (Helper.timKiemHoTen(ten, svList) == 0) {
            System.out.println("Khong tim thay sinh vien ten " + ten);
            return;
        } else {
            System.out.println("- Danh sach sinh vien co ten la " + ten + " : ");
            inTieuDeDayDu();
            for (int i = 0; i < svList.size(); i++) {
                if (svList.get(i).getHoTen().toLowerCase().contains(ten)) {
                    System.out.printf("%5s %s", (i + 1), svList.get(i).hienThiDayDu());
                    vt.add(i + 1);
                }
            }
            System.out.print("Nhap vao vi tri can xoa: ");
            int index = Helper.validateNumber(sc.nextLine());
            if (index > 0 && vt.contains(index)) {
                System.out.print("Xac nhan xoa (Y/N)?");
                if (sc.nextLine().equalsIgnoreCase("y")) {
                    svList.remove(index - 1);
                    System.out.println("Xoa thanh cong");
                    vt.clear();
                } else
                    System.out.println("Xoa that bai");
            } else {
                System.out.println("Vi tri nhap sai!");
            }
        }
    }

    public void sapXep(int type) {
        List<SinhVien> list = new ArrayList<>(svList);
        switch (type) {
            case 1:
                list.sort((sv1, sv2) -> sv1.getHoTen().toLowerCase().compareTo(sv2.getHoTen().toLowerCase()));
                break;
            case 2:
                list.sort((sv1, sv2) -> Integer.compare(sv1.getNamSinh(), sv2.getNamSinh()));
                break;
            case 3:
                list.sort((sv1, sv2) -> sv1.getSoDt().compareTo(sv2.getSoDt()));
                break;
        }
        hienThiDayDu(list);
    }

    public void loc(int type) {
        inTieuDeDayDu();
        if (type == 1) {
            for (int i = 0; i < svList.size(); i++) {
                if (svList.get(i).getHeDh().equals("Cao Dang"))
                    System.out.printf("%5s %s", (i + 1), svList.get(i).hienThiDayDu());
            }
        } else {
            for (int i = 0; i < svList.size(); i++) {
                if (svList.get(i).getHeDh().equals("Dai Hoc"))
                    System.out.printf("%5s %s", (i + 1), svList.get(i).hienThiDayDu());
            }
        }
    }

    public void timKiem(int type) {
        String find;
        switch (type) {
            case 1:
                System.out.print("Nhap ten can tim: ");
                find = sc.nextLine().toLowerCase();
                if (Helper.timKiemHoTen(find, svList) == 0) {
                    System.out.println("Khong tim thay sinh vien ten '" + find + "'");
                    return;
                }
                inTieuDeDayDu();
                for (int i = 0; i < svList.size(); i++) {
                    if (svList.get(i).getHoTen().toLowerCase().contains(find))
                        System.out.printf("%5s %s", (i + 1), svList.get(i).hienThiDayDu());
                }
                break;
            case 2:
                System.out.print("Nhap nam sinh can tim: ");
                find = sc.nextLine();
                if (Helper.timKiemNamSinh(find, svList) == 0) {
                    System.out.println("Khong tim thay sinh vien co nam sinh '" + find + "'");
                    return;
                }
                inTieuDeDayDu();
                for (int i = 0; i < svList.size(); i++) {
                    if ((svList.get(i).getNamSinh() + "").contains(find))
                        System.out.printf("%5s %s", (i + 1), svList.get(i).hienThiDayDu());
                }
                break;
            case 3:
                System.out.print("Nhap so dien thoai can tim: ");
                find = sc.nextLine();
                if (Helper.timKiemSoDt(find, svList) == 0) {
                    System.out.println("Khong tim thay sinh vien co so dien thoai '" + find + "'");
                    return;
                }
                inTieuDeDayDu();
                for (int i = 0; i < svList.size(); i++) {
                    if (svList.get(i).getSoDt().contains(find.toLowerCase()))
                        System.out.printf("%5s %s", (i + 1), svList.get(i).hienThiDayDu());
                }
                break;
            case 4:
                System.out.print("Nhap chuyen nganh can tim: ");
                find = sc.nextLine().toLowerCase();
                if (Helper.timKiemChuyenNganh(find, svList) == 0) {
                    System.out.println("Khong tim thay sinh vien co chuyen nganh '" + find + "'");
                    return;
                }
                inTieuDeDayDu();
                for (int i = 0; i < svList.size(); i++) {
                    if (svList.get(i).getChuyenNganh().toLowerCase().contains(find))
                        System.out.printf("%5s %s", (i + 1), svList.get(i).hienThiDayDu());
                }
                break;
        }
    }

    public void hienThi() {
        inTieuDeHienThi();
        for (int i = 0; i < svList.size(); i++) {
            System.out.printf("%5s %s", (i + 1), svList.get(i).toString());
        }
    }

    public void hienThi(List<SinhVien> list) {
        inTieuDeHienThi();
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%5s %s", (i + 1), list.get(i).toString());
        }
    }

    public void hienThiDayDu() {
        inTieuDeDayDu();
        for (int i = 0; i < svList.size(); i++) {
            System.out.printf("%5s %s", (i + 1), svList.get(i).hienThiDayDu());
        }
    }

    public void hienThiDayDu(List<SinhVien> list) {
        inTieuDeDayDu();
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%5s %s", (i + 1), list.get(i).hienThiDayDu());
        }
    }
}
