package vcmanea.example.android10_fragments_supporting_multiple_layouts;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Country {

    private String countryName;
    private String countryDescriptiom;
    private static List<Country> myList;

     Country(String countryName, String countryDescriptiom) {
        this.countryName = countryName;
        this.countryDescriptiom = countryDescriptiom;

    }






    public String getCountryName() {
        return countryName;
    }
    public String getCountryDescriptiom() {
        return countryDescriptiom;
    }





    public static List<Country> getCountryList(){
         if(myList==null){
             myList=new ArrayList<>();
         }
         return myList;










    }
}

