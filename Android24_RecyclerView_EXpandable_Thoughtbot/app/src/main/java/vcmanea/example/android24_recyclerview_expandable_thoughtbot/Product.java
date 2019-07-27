package vcmanea.example.android24_recyclerview_expandable_thoughtbot;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

   public String name;

    public Product(String name) {
        this.name = name;
    }

    protected Product(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }
}
