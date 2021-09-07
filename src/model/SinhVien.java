package model;

import helper.HelperException;
import helper.PhoneException;

import java.util.Calendar;
import java.util.Objects;

public class SinhVien {
    private String hoTen;
    private int namSinh;
    private String soDt;
    private String chuyenNganh;
    private String heDh;

    public SinhVien(String hoTen, int namSinh, String soDt, String chuyenNganh, String heDh) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.soDt = soDt;
        this.chuyenNganh = chuyenNganh;
        this.heDh = heDh;
    }

    public SinhVien(String soDt) {
        this.soDt = soDt;
    }

    public SinhVien() {
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) throws Exception {
        if (hoTen.isEmpty() || hoTen.isBlank())
            throw new HelperException("Ten sinh vien khong duoc bo trong");
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) throws Exception {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if (namSinh < 0 || namSinh > year)
            throw new HelperException("Nam sinh phai > 0 va <= nam hien tai");
        this.namSinh = namSinh;
    }

    public String getSoDt() {
        return soDt;
    }

    public void setSoDt(String soDt) throws Exception {
        if(soDt.length() != 10 && soDt.length() != 11)
            throw new PhoneException("So dien thoai phai du 10-11 chu so");
        try {
            Long.valueOf(soDt);
        } catch (NumberFormatException e) {
            throw new PhoneException("So dien thoai chi bao gom chu so");
        }
        this.soDt = soDt;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) throws Exception {
        if (chuyenNganh.isEmpty() || chuyenNganh.isBlank())
            throw new HelperException("Chuyen nganh khong duoc bo trong");
        this.chuyenNganh = chuyenNganh;
    }

    public String getHeDh() {
        return heDh;
    }

    public void setHeDh(String heDh) {
        this.heDh = heDh;
    }

    public String hienThiDayDu() {
        return String.format("%15s %15d %15s %20s %20s %n", hoTen, namSinh, soDt, chuyenNganh, heDh);
    }

    @Override
    public String toString() {
        return String.format("%15s %15s %20s%n", hoTen, soDt, heDh);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhVien sinhVien = (SinhVien) o;
        return soDt.equals(sinhVien.soDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soDt);
    }
}
