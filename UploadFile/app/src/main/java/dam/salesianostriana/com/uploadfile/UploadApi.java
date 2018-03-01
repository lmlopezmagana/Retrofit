package dam.salesianostriana.com.uploadfile;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Luismi on 25/02/2018.
 */



public interface UploadApi {


    @Multipart
    @Headers({
          "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1YTk2YTczZDI4YmRmMTAwOTJlMGRiNjIiLCJpYXQiOjE1MTk4MzU2NTQsImV4cCI6MTUyMTA0NTI1NH0.Kd59pSaMS1AyLLsAF-ZqxFgJrBq-W3biovMliDt70LA"
    })
    @POST("/api/v1/files/upload")
    Call<ResponseBody> uploadFile(@Part MultipartBody.Part photo, @Part("title") RequestBody title, @Part("coords") RequestBody coords);

}
