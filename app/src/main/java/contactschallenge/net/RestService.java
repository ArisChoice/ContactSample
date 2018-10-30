package contactschallenge.net;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Harish on 2/3/15.
 */
public interface RestService {
    @POST(NetworkConstatnts.API.loginUser)
    Call<Response> loginUser(@Body Object requestData);

   /* @FormUrlEncoded
    @POST(NetworkConstatnts.API.SIGNUP)
    Call<UserResponseModel> signUpRequest(@Field(NetworkConstatnts.Params.firstName) String firstName,
                                          @Field(NetworkConstatnts.Params.lastName) String lastName,
                                          @Field(NetworkConstatnts.Params.nickname) String nickNme,
                                          @Field(NetworkConstatnts.Params.email) String email,
                                          @Field(NetworkConstatnts.Params.password) String password,
                                          @Field(NetworkConstatnts.Params.lookingType) int lookingType,
                                          @Field(NetworkConstatnts.Params.seekingType) int seekingType);

    @FormUrlEncoded
    @POST(NetworkConstatnts.API.SIGNUP)
    Call<UserResponseModel> signUpRequest(@FieldMap Map<String, String> fields);

    @FormUrlEncoded


    @POST(NetworkConstatnts.API.SIGNIN)
    Call<UserResponseModel> signInRequest(@Field(NetworkConstatnts.Params.email) String email,
                                          @Field(NetworkConstatnts.Params.password) String password);

    @Multipart
    @POST(NetworkConstatnts.API.addProperty)
    Call<AddPropertyResponseModel> uploadProperty(@PartMap() Map<String, RequestBody> params,
                                                  @Part List<MultipartBody.Part> file);*/


}