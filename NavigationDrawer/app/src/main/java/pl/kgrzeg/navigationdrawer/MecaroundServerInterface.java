package pl.kgrzeg.navigationdrawer;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by course on 10/11/2017.
 */

public interface MecaroundServerInterface {

    // Login request
    @POST
    Call<LoginResponse> doLogin(@Field("email") String e, @Field("password") String p);
}
