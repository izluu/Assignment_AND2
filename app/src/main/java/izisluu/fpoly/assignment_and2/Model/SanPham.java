package izisluu.fpoly.assignment_and2.Model;

public class SanPham {
    private String tenSP,maSP,gia,soLuong;
    public SanPham(String tenSP, String maSP, String gia, String soLuong) {
        this.tenSP = tenSP;
        this.maSP = maSP;
        this.gia = gia;
        this.soLuong = soLuong;
    }
    public SanPham(){}

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }
}
