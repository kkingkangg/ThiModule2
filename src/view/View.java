package view;

import model.DanhBa;

import java.sql.ClientInfoStatus;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ---");
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng: ");

    }

    public void xemDanhSach(List<DanhBa> list) {
        for (DanhBa danhBa : list) {
            System.out.println(danhBa.getSoDienThoai() + ", " + danhBa.getNhom() + ", " + danhBa.getHoTen() + ", " + danhBa.getGioiTinh() + ", " + danhBa.getDiaChi() + ", " + danhBa.getNgaySinh() + ", " + danhBa.getEmail());
            System.out.println("thêm thành công");
        }
        menu();
    }

    public void themMoi(List<DanhBa> list) {
        System.out.print("Mời nhập Số điện thoại: ");
        String sdt = sc.nextLine();
        System.out.print("Mời nhập nhóm: ");
        String nhom = sc.nextLine();
        System.out.print("Mời nhập Họ Tên: ");
        String ten = sc.nextLine();
        System.out.print("Mời nhập giới tính: ");
        String gioiTinh = sc.nextLine();
        System.out.print("Mời nhập địa chỉ: ");
        String diaChi = sc.nextLine();
        System.out.print("Mời nhập ngày sinh: ");
        String ngaySinh = sc.nextLine();
        System.out.print("Mời nhập mail: ");
        String mail = sc.nextLine();

        DanhBa newObj = new DanhBa(sdt, nhom, ten, gioiTinh, diaChi, ngaySinh, mail);
        list.add(newObj);
        menu();
    }

    public void capNhat(List<DanhBa> list) {
        System.out.println("Nhập số diện thoại cần sửa: ");
        String sdt = sc.nextLine();
        for (DanhBa obj : list) {
            if ((obj.getSoDienThoai()).equals(sdt)) {
                System.out.print("Mời nhập nhóm: ");
                String nhom = sc.nextLine();
                System.out.print("Mời nhập Họ Tên: ");
                String ten = sc.nextLine();
                System.out.print("Mời nhập giới tính: ");
                String gioiTinh = sc.nextLine();
                System.out.print("Mời nhập địa chỉ: ");
                String diaChi = sc.nextLine();
                System.out.print("Mời nhập ngày sinh: ");
                String ngaySinh = sc.nextLine();
                System.out.print("Mời nhập mail: ");
                String mail = sc.nextLine();
                obj.setNhom(nhom);
                obj.setHoTen(ten);
                obj.setGioiTinh(gioiTinh);
                obj.setDiaChi(diaChi);
                obj.setNgaySinh(ngaySinh);
                obj.setEmail(mail);
            } else {
                System.out.println("Không tìm thấy số điện thoại, nhập lại");
                capNhat(list);
            }
        }
        menu();
    }

    public void xoa(List<DanhBa> list) {
        System.out.println("Mời nhập số điện thoại muốn xóa: ");
        String sdt = sc.nextLine();
        for (DanhBa obj : list)
            if ((obj.getSoDienThoai()).equals(sdt)) {
                System.out.println("Bạn chắc chắn muốn xóa?");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int xacNhan = sc.nextInt();
                if (xacNhan == 1) {
                    list.remove(obj);
                } else {
                    menu();
                }
            } else {
                System.out.println("Không tìm thấy số điện thoại trên danh bạ, nhập lại");
                xoa(list);
            }

        menu();
    }

    public void timKiem(List<DanhBa> list) {
        System.out.println("Mời nhập số điện thoại muốn tìm kiếm: ");
        String sdt = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSoDienThoai().contains(sdt)) {
                System.out.println(list.get(i));
            }
        }
        menu();
    }

    public void docDanhBa(List<DanhBa>list){

    }

}