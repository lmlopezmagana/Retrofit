package dam.salesianostriana.com.uploadfile;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Luismi on 25/02/2018.
 */



public interface UploadApi {


    @Multipart
    @POST("/upload")
    Call<ResponseBody> uploadFile(@Part MultipartBody.Part file);

}
