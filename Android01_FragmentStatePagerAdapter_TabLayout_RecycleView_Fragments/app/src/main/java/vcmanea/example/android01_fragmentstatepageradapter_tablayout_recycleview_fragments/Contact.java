package vcmanea.example.android01_fragmentstatepageradapter_tablayout_recycleview_fragments;

public class Contact {

    private String Name;
    private String Phone;
    private int Photo;

    public Contact(String name, String phone, int photo) {
        Name = name;
        Phone = phone;
        Photo = photo;
    }


    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public int getPhoto() {
        return Photo;
    }
}
