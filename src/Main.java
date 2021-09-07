import model.DanhSachSinhVien;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static DanhSachSinhVien dsSv = new DanhSachSinhVien();

    public static void main(String[] args) {
        String luaChon;
        do {
            System.out.println("\n====== MENU ======");
            System.out.println("1, Quan ly sinh vien");
            System.out.println("2, Hien thi danh sach sinh vien");
            System.out.println("3, Sap xep va hien thi danh sach sinh vien");
            System.out.println("4, Loc sinh vien va hien thi");
            System.out.println("5, Tim kiem sinh vien");
            System.out.println("6, Thoat chuong trinh");
            System.out.print("Moi nhap lua chon: ");
            luaChon = sc.nextLine();
            switch (luaChon) {
                case "1":
                    quanLySinhVien();
                    break;
                case "2":
                    hienThiDanhSachSinhVien();
                    break;
                case "3":
                    sapXepDanhSachSinhVien();
                    break;
                case "4":
                    locDanhSachSinhVien();
                    break;
                case "5":
                    timKiemSinhVien();
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nKhong co lua chon nay, moi nhap lai!!");
                    break;
            }

        } while (true);

    }

    private static void quanLySinhVien() {
        String luaChon;
        do {
            System.out.println("\n---- Quan ly sinh vien ----");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Sua thong tin sinh vien");
            System.out.println("3. Xoa sinh vien");
            System.out.println("4. Quay lai");
            System.out.print("Moi nhap lua chon: ");
            luaChon = sc.nextLine();
            switch (luaChon) {
                case "1":
                    System.out.println("\n-- Them sinh vien --");
                    dsSv.themSinhVien();
                    break;
                case "2":
                    System.out.println("\n-- Sua thong tin sinh vien --");
                    dsSv.suaThongTin();
                    break;
                case "3":
                    System.out.println("\n-- Xoa sinh vien --");
                    dsSv.xoaSinhVien();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("\nKhong co lua chon nay, moi nhap lai!!");
                    break;
            }
        } while (true);
    }

    private static void hienThiDanhSachSinhVien() {
        dsSv.hienThi();
    }

    private static void sapXepDanhSachSinhVien() {
        String luaChon;
        do {
            System.out.println("\n---- Sap xep danh sach sinh vien ----");
            System.out.println("1. Sap xep theo ten");
            System.out.println("2. Sap xep theo nam sinh");
            System.out.println("3. Sap xep theo so dien thoai");
            System.out.println("4. Quay lai");
            System.out.print("Moi nhap lua chon: ");
            luaChon = sc.nextLine();
            switch (luaChon) {
                case "1":
                    System.out.println("\n-- Sap xep theo ten sinh vien --");
                    dsSv.sapXep(1);
                    break;
                case "2":
                    System.out.println("\n-- Sap xep theo nam sinh --");
                    dsSv.sapXep(2);
                    break;
                case "3":
                    System.out.println("\n-- Sap xep theo so dien thoai --");
                    dsSv.sapXep(3);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("\nKhong co lua chon nay, moi nhap lai!!");
                    break;
            }
        } while (true);
    }

    private static void locDanhSachSinhVien() {
        String luaChon;
        do {
            System.out.println("\n---- Loc danh sach sinh vien ----");
            System.out.println("1. Loc theo he Cao Dang");
            System.out.println("2. Loc theo he Dai Hoc");
            System.out.println("3. Quay lai");
            System.out.print("Moi nhap lua chon: ");
            luaChon = sc.nextLine();
            switch (luaChon) {
                case "1":
                    System.out.println("\n-- Loc theo he Cao Dang --");
                    dsSv.loc(1);
                    break;
                case "2":
                    System.out.println("\n-- Loc theo he Dai Hoc --");
                    dsSv.loc(2);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("\nKhong co lua chon nay, moi nhap lai!!");
                    break;
            }
        } while (true);
    }

    private static void timKiemSinhVien() {
        String luaChon;
        do {
            System.out.println("\n---- Tim kiem sinh vien ----");
            System.out.println("1. Tim kiem theo ten");
            System.out.println("2. Tim kiem theo nam sinh");
            System.out.println("3. Tim kiem theo so dien thoai");
            System.out.println("4. Tim kiem theo chuyen nganh");
            System.out.println("5. Quay lai");
            System.out.print("Moi nhap lua chon: ");
            luaChon = sc.nextLine();
            switch (luaChon) {
                case "1":
                    System.out.println("\n-- Tim kiem theo ten --");
                    dsSv.timKiem(1);
                    break;
                case "2":
                    System.out.println("\n-- Tim kiem theo nam sinh --");
                    dsSv.timKiem(2);
                    break;
                case "3":
                    System.out.println("\n-- Tim kiem theo so dien thoai --");
                    dsSv.timKiem(3);
                    break;
                case "4":
                    System.out.println("\n-- Tim kiem theo chuyen nganh --");
                    dsSv.timKiem(4);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("\nKhong co lua chon nay, moi nhap lai!!");
                    break;
            }
        } while (true);
    }
}
