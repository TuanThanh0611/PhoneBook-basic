import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
class Contact{
    public String getName() {
        return name;
    }

    public String getStd() {
        return std;
    }

    private String name;
    private String std;
    private String address;
    private String email;


    public Contact(String name, String std, String address, String email) {
        this.name = name;
        this.std = std;
        this.address = address;
        this.email = email;
    }
    public void getString(){
        System.out.println("Tên: "+name+"" +
                "\nSố điện thoại: "+std+"" +
                "\nĐịa chỉ: "+address+"" +
                "\nemail: "+email);
    }
}
class PhoneBook{
    ArrayList<Contact> contacts;
    Scanner input=new Scanner(System.in);
    PhoneBook(){
        contacts=new ArrayList<>();
    }
    public void addNew(){
        Contact newContact;
        System.out.println("Nhập tên: ");
        String a=input.nextLine();
        System.out.println("Số điện thoại: ");
        String b=input.nextLine();
        System.out.println("Địa chỉ: ");
        String c=input.nextLine();
        System.out.println("Email: ");
        String d=input.nextLine();
        newContact=new Contact(a,b,c,d);
        contacts.add(newContact);
    }
    public void printALl(){
        for(int i=0;i<contacts.size();i++){
            System.out.println("      Khách hàng số "+i);
            contacts.get(i).getString();

        }
    }
    public void searchName(){
        System.out.println("Nhập tên đối tượng cần tìm: ");
        String n=input.nextLine();
        for(int i=0;i<contacts.size();i++){
            if(Objects.equals(contacts.get(i).getName(), n)){
                contacts.get(i).getString();
                return;
            }
        }
        System.out.println("-----Không tìm thấy đối tượng!!!-----");

    }
    public void searchSTD(){
        System.out.println("Nhập số điện thoại đối tượng cần tìm: ");
        String n=input.nextLine();
        for(int i=0;i<contacts.size();i++){
            if(Objects.equals(contacts.get(i).getStd(), n)){
                contacts.get(i).getString();
                return;
            }
        }
        System.out.println("-----Không tìm thấy đối tượng!!!-----");

    }
    public void change(){
        System.out.println("Nhập tên đối tượng muốn thay đổi thông tin: ");
        String s=input.nextLine();
        int x=0;
        Contact t=null;
        for(int i=0;i<contacts.size();i++){
            if(Objects.equals(s, contacts.get(i).getName())){
                t=contacts.get(i);
                x=i;
                break;
            }
        }
        if(t==null){
            System.out.println("Đối tượng không tồn tại!!!");
            return;
        }
        System.out.println("Nhập tên: ");
        String a=input.nextLine();
        System.out.println("Số điện thoại: ");
        String b=input.nextLine();
        System.out.println("Địa chỉ: ");
        String c=input.nextLine();
        System.out.println("Email: ");
        String d=input.nextLine();
        t=new Contact(a,b,c,d);
        contacts.set(x,t);

    }
    public void delete(){
        System.out.println("Nhập tên đối tượng muốn xóa thông tin: ");
        String s=input.nextLine();

        for(int i=0;i<contacts.size();i++){
            if(Objects.equals(s, contacts.get(i).getName())){
                contacts.remove(i);
                return;
            }
        }
        System.out.println("Không tìm thấy đối tượng!!!");


    }
}
public class Main{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        PhoneBook contactsList=new PhoneBook();
        int n=9,t=4;
        do{

            System.out.println("Ấn phím để lựa thao tác:" +
                    "\n1.Thêm liên lạc mới vào danh bạ." +
                    "\n2.Hiển thị tất cả các liên lạc." +
                    "\n3.Tìm kiếm liên lạc bằng tên hoặc sđt." +
                    "\n4.Sữa đổi thông tin liên lạc." +
                    "\n5.Xóa liên lạc." +
                    "\n0.Thoát.\n"
            );
            n=input.nextInt();
            switch (n){
                case 1:
                    contactsList.addNew();
                    break;
                case 2:
                    contactsList.printALl();
                    break;
                case 3:
                    do{
                    System.out.println("Nhấn phím 1 để tìm kiếm theo tên.\nNhấn phím 2 để tìm theo số điện thoại.");
                    t=input.nextInt();
                    if(t==1){
                        contactsList.searchName();
                    }else if(t==2){
                        contactsList.searchSTD();
                    }else{
                        System.out.println("Thao tác sai, vui lòng nhập lại!!!");
                    }
                    }while(t!=2&&t!=1);
                    break;
                case 4:
                    contactsList.change();
                    break;
                case 5:
                    contactsList.delete();
                    break;
                default:
                    System.out.println("Thao tác sai, vui lòng nhập lại!!!");


            }
        }while(n!=0);
    }
}