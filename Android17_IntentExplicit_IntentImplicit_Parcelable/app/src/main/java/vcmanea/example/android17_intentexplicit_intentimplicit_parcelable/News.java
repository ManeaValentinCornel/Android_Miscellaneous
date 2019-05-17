package vcmanea.example.android17_intentexplicit_intentimplicit_parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class News implements Parcelable {

    String name;
    String secondName;

    public News(){
        super();
    }

    public News(Parcel parcel) {
        this.name=parcel.readString();
        this.secondName=parcel.readString();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.secondName);
    }

    public static final Creator<News> CREATOR=new Creator<News>() {
        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
