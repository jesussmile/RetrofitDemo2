package com.example.pannam.retrofitdemo2.helper;

/**
 * Created by pannam on 2/17/2016.
 */
public class Constants {
    public static final class HTTP {


        //static makes it uniform value across all the class instances.. ensures that
        // you don't waste memory creating many of the same thing if it will be the same value for all objects.
  //      public static final String BASE_URL = "http://services.hanselandpetal.com";
        public static final String BASE_URL = "http://services.hanselandpetal.com";


    }

    public static final class DATABASE{

    }

    public static final class REFERENCE {
        public static final String FLOWER = Config.PACKAGE_NAME + " flower";
    }


    public static final class Config{
        public static final String PACKAGE_NAME ="com.example.pannam.retrofitdemo2";
    }

}
