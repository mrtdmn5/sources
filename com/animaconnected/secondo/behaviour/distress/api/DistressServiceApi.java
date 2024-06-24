package com.animaconnected.secondo.behaviour.distress.api;

import com.animaconnected.secondo.behaviour.distress.api.request.FollowMeHomeLocationRequest;
import com.animaconnected.secondo.behaviour.distress.api.request.FollowMeHomeRequest;
import com.animaconnected.secondo.behaviour.distress.api.request.Invitation;
import com.animaconnected.secondo.behaviour.distress.api.request.InvitationRequest;
import com.animaconnected.secondo.behaviour.distress.api.request.RegisterTokenRequest;
import com.animaconnected.secondo.behaviour.distress.api.request.RegisterUserRequest;
import com.animaconnected.secondo.behaviour.distress.api.request.RegisterUserResponse;
import com.animaconnected.secondo.behaviour.distress.api.request.UserStateResponse;
import com.animaconnected.secondo.notification.model.Contact;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* compiled from: DistressServiceApi.kt */
/* loaded from: classes3.dex */
public interface DistressServiceApi {
    @Headers({"Content-type:application/json"})
    @POST(Contact.TABLE_NAME_USERS)
    Object createUser(@Body RegisterUserRequest registerUserRequest, Continuation<? super RegisterUserResponse> continuation);

    @Headers({"Content-type:application/json"})
    @POST("follow-me-home")
    Object followMeHome(@Body FollowMeHomeRequest followMeHomeRequest, Continuation<? super Response<Unit>> continuation);

    @Headers({"Content-type:application/json"})
    @POST("follow-me-home/location")
    Object followMeHomeLocation(@Body FollowMeHomeLocationRequest followMeHomeLocationRequest, Continuation<? super Response<Unit>> continuation);

    @Headers({"Content-type:application/json"})
    @POST("invitation")
    Object invitation(@Body InvitationRequest invitationRequest, Continuation<? super Invitation> continuation);

    @DELETE("invitation")
    @Headers({"Content-type:application/json"})
    Object invitationCancel(@Query("invitationToken") String str, Continuation<? super Response<Unit>> continuation);

    @Headers({"Content-type:application/json"})
    @POST("push-registration/secondo/android")
    Object registerToken(@Body RegisterTokenRequest registerTokenRequest, Continuation<? super Response<Unit>> continuation);

    @Headers({"Content-type:application/json"})
    @POST("follow-me-home/remove-follower")
    Object removeObserver(@Body Map<String, String> map, Continuation<? super Response<Unit>> continuation);

    @Headers({"Content-type:application/json"})
    @POST("users/{user}")
    Object updateUser(@Path("user") String str, @Body RegisterUserRequest registerUserRequest, Continuation<? super Response<Unit>> continuation);

    @Headers({"Content-type:application/json"})
    @POST("follow-me-home/status")
    Object userState(@Body Map<String, String> map, Continuation<? super UserStateResponse> continuation);
}
