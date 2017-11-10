package pl.kgrzeg.navigationdrawer;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by course on 10/11/2017.
 */

public interface MecaroundServerInterface {

    // Login request
    @POST("auth/login")
    @FormUrlEncoded
    Call<LoginResponse> serverLogin(@Field("email") String e, @Field("password") String p);
}
