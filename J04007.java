package CodePTIT_Java;
import java.util.Scanner;
class Nhanvien{
    public String id;
    public String name;
    public String gender;
    public String dob;
    public String address;
    public String MST;
    public String ngayky;
    public Nhanvien ( String name, String gender, String dob, String address, String MST, String ngayky){
        this.id = "00001";
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.MST = MST;
        this.ngayky = ngayky;
    }
    @Override
    public String toString(){
        return id + " " + name + " " + gender + " " + dob + " " + address + " " + MST + " " + ngayky;
    }

}
public class J04007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String gender = sc.nextLine();
        String dob = sc.nextLine();
        String address = sc.nextLine();
        String MST = sc.nextLine();
        String ngayky = sc.nextLine();
        Nhanvien nv = new Nhanvien( name, gender, dob, address, MST, ngayky);
        System.out.println(nv);
    }
}
