package org.pursuit.unit_04_assessment.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
        private static Retrofit getInstance;


        public static Retrofit ourInstance() {
            if (getInstance != null) {

                return getInstance;

            }

            getInstance = new Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return getInstance;

        }

    }
