package com.animaconnected.secondo.behaviour.distress.api;

import android.content.Context;
import android.util.Log;
import com.animaconnected.firebase.Analytics;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.future.Future;
import com.animaconnected.future.FutureCoroutineKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.behaviour.distress.api.request.FollowMeHomeRequest;
import com.animaconnected.secondo.behaviour.distress.api.request.Invitation;
import com.animaconnected.secondo.behaviour.distress.api.request.InvitationRequest;
import com.animaconnected.secondo.behaviour.distress.api.request.RegisterTokenRequest;
import com.animaconnected.secondo.behaviour.distress.api.request.UserStateResponse;
import com.animaconnected.secondo.behaviour.distress.model.DistressModel;
import com.animaconnected.secondo.behaviour.distress.model.Observer;
import com.animaconnected.secondo.behaviour.distress.model.Subject;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.behaviour.distress.WalkMeHomeState;
import com.kronaby.watch.app.R;
import com.squareup.moshi.Moshi;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/* compiled from: DistressApi.kt */
/* loaded from: classes3.dex */
public final class DistressApi {
    private static DistressApi sDistressServerApi;
    private final Analytics analytics;
    private final DistressServiceApi api;
    private final DistressModel model;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "DistressApi";

    /* compiled from: DistressApi.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DistressApi getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            DistressApi distressApi = DistressApi.sDistressServerApi;
            if (distressApi == null) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                DistressApi distressApi2 = new DistressApi(applicationContext, null);
                DistressApi.sDistressServerApi = distressApi2;
                return distressApi2;
            }
            return distressApi;
        }

        private Companion() {
        }
    }

    public /* synthetic */ DistressApi(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object createUser(com.animaconnected.secondo.behaviour.distress.model.Subject r7, kotlin.coroutines.Continuation<? super com.animaconnected.secondo.behaviour.distress.model.Subject> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.animaconnected.secondo.behaviour.distress.api.DistressApi$createUser$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.secondo.behaviour.distress.api.DistressApi$createUser$1 r0 = (com.animaconnected.secondo.behaviour.distress.api.DistressApi$createUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.behaviour.distress.api.DistressApi$createUser$1 r0 = new com.animaconnected.secondo.behaviour.distress.api.DistressApi$createUser$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r7 = r0.L$0
            com.animaconnected.secondo.behaviour.distress.api.request.RegisterUserRequest r7 = (com.animaconnected.secondo.behaviour.distress.api.request.RegisterUserRequest) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L75
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = com.animaconnected.secondo.behaviour.distress.api.DistressApi.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "createUser() called with subject = ["
            r2.<init>(r4)
            r2.append(r7)
            r4 = 93
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r8, r2)
            com.animaconnected.secondo.behaviour.distress.api.request.RegisterUserRequest r8 = new com.animaconnected.secondo.behaviour.distress.api.request.RegisterUserRequest
            java.lang.String r2 = r7.getFirstName()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r4 = r7.getLastName()
            java.lang.String r7 = r7.getPhoneNumber()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r8.<init>(r2, r4, r7)
            com.animaconnected.secondo.behaviour.distress.api.DistressServiceApi r7 = r6.api
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = r7.createUser(r8, r0)
            if (r7 != r1) goto L72
            return r1
        L72:
            r5 = r8
            r8 = r7
            r7 = r5
        L75:
            com.animaconnected.secondo.behaviour.distress.api.request.RegisterUserResponse r8 = (com.animaconnected.secondo.behaviour.distress.api.request.RegisterUserResponse) r8
            java.lang.String r0 = com.animaconnected.secondo.behaviour.distress.api.DistressApi.TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "createUser response = "
            r1.<init>(r2)
            r1.append(r8)
            r2 = 32
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
            java.lang.String r8 = r8.getUserId()
            com.animaconnected.secondo.behaviour.distress.model.Subject r0 = new com.animaconnected.secondo.behaviour.distress.model.Subject
            r1 = 0
            r0.<init>(r1, r3, r1)
            java.lang.String r1 = r7.getFirstName()
            r0.setFirstName(r1)
            java.lang.String r1 = r7.getLastName()
            r0.setLastName(r1)
            java.lang.String r7 = r7.getPhoneNumber()
            r0.setPhoneNumber(r7)
            r0.setUserId(r8)
            r0.setRegistered(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.api.DistressApi.createUser(com.animaconnected.secondo.behaviour.distress.model.Subject, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object followMeHome(WalkMeHomeState walkMeHomeState, Continuation<? super Unit> continuation) {
        String str;
        Log.d(TAG, "followMeHome() called with state = [" + walkMeHomeState + ']');
        Subject subject = this.model.getSubject();
        String str2 = null;
        if (subject != null) {
            str = subject.getUserId();
        } else {
            str = null;
        }
        Intrinsics.checkNotNull(str);
        String[] strArr = new String[1];
        Observer observer = this.model.getObserver();
        if (observer != null) {
            str2 = observer.getUserId();
        }
        Intrinsics.checkNotNull(str2);
        strArr[0] = str2;
        Object followMeHome = this.api.followMeHome(new FollowMeHomeRequest(str, strArr, walkMeHomeState.string, subject.getLocation()), continuation);
        if (followMeHome == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return followMeHome;
        }
        return Unit.INSTANCE;
    }

    public static final DistressApi getInstance(Context context) {
        return Companion.getInstance(context);
    }

    private final Future<Unit> wrapInFuture(Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        CoroutineScope scope = KronabyApplication.Companion.getScope();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return FutureCoroutineKt.asFuture(BuildersKt.async$default(scope, MainDispatcherLoader.dispatcher, new DistressApi$wrapInFuture$1(function1, null), 2));
    }

    public final Object cancelInvitation(Continuation<? super Unit> continuation) {
        String invitationToken = this.model.getInvitationToken();
        Log.d(TAG, "invitationCancel() called with token = " + invitationToken + ']');
        if (invitationToken != null) {
            Object invitationCancel = this.api.invitationCancel(invitationToken, continuation);
            if (invitationCancel == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return invitationCancel;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final Future<Unit> cancelInvitationFuture() {
        return wrapInFuture(new DistressApi$cancelInvitationFuture$1(this, null));
    }

    public final Object getInvitation(Continuation<? super Invitation> continuation) {
        String str;
        Subject subject = this.model.getSubject();
        Log.d(TAG, "invitation() called with subject = [" + this.model + ".subject]");
        DistressServiceApi distressServiceApi = this.api;
        if (subject != null) {
            str = subject.getUserId();
        } else {
            str = null;
        }
        return distressServiceApi.invitation(new InvitationRequest(str), continuation);
    }

    public final Object getUserState(Continuation<? super UserStateResponse> continuation) {
        String str;
        String userId;
        Subject subject = this.model.getSubject();
        String str2 = "";
        if (subject == null || (str = subject.getUserId()) == null) {
            str = "";
        }
        Observer observer = this.model.getObserver();
        if (observer != null && (userId = observer.getUserId()) != null) {
            str2 = userId;
        }
        Map<String, String> mapOf = MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_WALKERID, str), new Pair(AnalyticsConstants.KEY_FOLLOWERID, str2));
        Log.d(TAG, "userState() called with walkerID: " + str + " and followerID: " + str2);
        return this.api.userState(mapOf, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object home(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.secondo.behaviour.distress.api.DistressApi$home$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.secondo.behaviour.distress.api.DistressApi$home$1 r0 = (com.animaconnected.secondo.behaviour.distress.api.DistressApi$home$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.behaviour.distress.api.DistressApi$home$1 r0 = new com.animaconnected.secondo.behaviour.distress.api.DistressApi$home$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.behaviour.distress.api.DistressApi r0 = (com.animaconnected.secondo.behaviour.distress.api.DistressApi) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L44
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            com.animaconnected.watch.behaviour.distress.WalkMeHomeState r5 = com.animaconnected.watch.behaviour.distress.WalkMeHomeState.Idle
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.followMeHome(r5, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            r0 = r4
        L44:
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r5 = r0.model
            com.animaconnected.watch.behaviour.distress.WalkMeHomeState r0 = com.animaconnected.watch.behaviour.distress.WalkMeHomeState.Idle
            r5.setState(r0)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.api.DistressApi.home(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Future<Unit> homeFuture() {
        return wrapInFuture(new DistressApi$homeFuture$1(this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object registerSubject(com.animaconnected.secondo.behaviour.distress.model.Subject r8, kotlin.coroutines.Continuation<? super com.animaconnected.secondo.behaviour.distress.model.Subject> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.animaconnected.secondo.behaviour.distress.api.DistressApi$registerSubject$1
            if (r0 == 0) goto L13
            r0 = r9
            com.animaconnected.secondo.behaviour.distress.api.DistressApi$registerSubject$1 r0 = (com.animaconnected.secondo.behaviour.distress.api.DistressApi$registerSubject$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.behaviour.distress.api.DistressApi$registerSubject$1 r0 = new com.animaconnected.secondo.behaviour.distress.api.DistressApi$registerSubject$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L59
            if (r2 == r5) goto L51
            if (r2 == r4) goto L42
            if (r2 != r3) goto L3a
            java.lang.Object r8 = r0.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r1 = r0.L$1
            com.animaconnected.secondo.behaviour.distress.model.Subject r1 = (com.animaconnected.secondo.behaviour.distress.model.Subject) r1
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.behaviour.distress.api.DistressApi r0 = (com.animaconnected.secondo.behaviour.distress.api.DistressApi) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto Lb0
        L3a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L42:
            java.lang.Object r8 = r0.L$1
            com.animaconnected.secondo.behaviour.distress.model.Subject r8 = (com.animaconnected.secondo.behaviour.distress.model.Subject) r8
            java.lang.Object r2 = r0.L$0
            com.animaconnected.secondo.behaviour.distress.api.DistressApi r2 = (com.animaconnected.secondo.behaviour.distress.api.DistressApi) r2
            kotlin.ResultKt.throwOnFailure(r9)
            r6 = r2
            r2 = r8
            r8 = r6
            goto L8e
        L51:
            java.lang.Object r8 = r0.L$0
            com.animaconnected.secondo.behaviour.distress.api.DistressApi r8 = (com.animaconnected.secondo.behaviour.distress.api.DistressApi) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L68
        L59:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r9 = r7.createUser(r8, r0)
            if (r9 != r1) goto L67
            return r1
        L67:
            r8 = r7
        L68:
            com.animaconnected.secondo.behaviour.distress.model.Subject r9 = (com.animaconnected.secondo.behaviour.distress.model.Subject) r9
            java.lang.String r2 = com.animaconnected.secondo.behaviour.distress.api.DistressApi.TAG
            java.lang.String r5 = "Subject registration success!"
            android.util.Log.i(r2, r5)
            com.google.firebase.messaging.FirebaseMessaging r2 = com.google.firebase.messaging.FirebaseMessaging.getInstance()
            com.google.android.gms.tasks.Task r2 = r2.getToken()
            java.lang.String r5 = "getToken(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r2 = com.animaconnected.secondo.provider.googlefit.GoogleFitProviderKt.getSuspending(r2, r0)
            if (r2 != r1) goto L8b
            return r1
        L8b:
            r6 = r2
            r2 = r9
            r9 = r6
        L8e:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r4 = com.animaconnected.secondo.behaviour.distress.api.DistressApi.TAG
            java.lang.String r5 = "Token result success: "
            java.lang.String r5 = r5.concat(r9)
            android.util.Log.i(r4, r5)
            r0.L$0 = r8
            r0.L$1 = r2
            r0.L$2 = r9
            r0.label = r3
            java.lang.Object r0 = r8.registerToken(r9, r2, r0)
            if (r0 != r1) goto Lad
            return r1
        Lad:
            r0 = r8
            r8 = r9
            r1 = r2
        Lb0:
            java.lang.String r9 = com.animaconnected.secondo.behaviour.distress.api.DistressApi.TAG
            java.lang.String r2 = "Token registered "
            android.util.Log.i(r9, r2)
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r9 = r0.model
            r9.setSubject(r1)
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r9 = r0.model
            r9.setToken(r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.api.DistressApi.registerSubject(com.animaconnected.secondo.behaviour.distress.model.Subject, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object registerToken(String str, Subject subject, Continuation<? super Unit> continuation) {
        Log.d(TAG, "registerToken() called with token = [" + str + "], subject = [" + subject + ']');
        DistressServiceApi distressServiceApi = this.api;
        String userId = subject.getUserId();
        Intrinsics.checkNotNull(userId);
        Object registerToken = distressServiceApi.registerToken(new RegisterTokenRequest(userId, str), continuation);
        if (registerToken == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return registerToken;
        }
        return Unit.INSTANCE;
    }

    public final Future<Unit> registerTokenFuture(String token, Subject userId) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(userId, "userId");
        return wrapInFuture(new DistressApi$registerTokenFuture$1(this, token, userId, null));
    }

    public final Object removeObserver(Continuation<? super Unit> continuation) {
        String str;
        Log.d(TAG, "removeObserver() called");
        HashMap hashMap = new HashMap();
        Subject subject = this.model.getSubject();
        String str2 = null;
        if (subject != null) {
            str = subject.getUserId();
        } else {
            str = null;
        }
        Intrinsics.checkNotNull(str);
        hashMap.put("userId", str);
        Observer observer = this.model.getObserver();
        if (observer != null) {
            str2 = observer.getUserId();
        }
        Intrinsics.checkNotNull(str2);
        hashMap.put(AnalyticsConstants.KEY_FOLLOWERID, str2);
        Object removeObserver = this.api.removeObserver(hashMap, continuation);
        if (removeObserver == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return removeObserver;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object safe(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.secondo.behaviour.distress.api.DistressApi$safe$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.secondo.behaviour.distress.api.DistressApi$safe$1 r0 = (com.animaconnected.secondo.behaviour.distress.api.DistressApi$safe$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.behaviour.distress.api.DistressApi$safe$1 r0 = new com.animaconnected.secondo.behaviour.distress.api.DistressApi$safe$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.behaviour.distress.api.DistressApi r0 = (com.animaconnected.secondo.behaviour.distress.api.DistressApi) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L44
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            com.animaconnected.watch.behaviour.distress.WalkMeHomeState r5 = com.animaconnected.watch.behaviour.distress.WalkMeHomeState.Active
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.followMeHome(r5, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            r0 = r4
        L44:
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r5 = r0.model
            com.animaconnected.watch.behaviour.distress.WalkMeHomeState r0 = com.animaconnected.watch.behaviour.distress.WalkMeHomeState.Active
            r5.setState(r0)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.api.DistressApi.safe(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Future<Unit> safeFuture() {
        return wrapInFuture(new DistressApi$safeFuture$1(this, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object startDistress(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.secondo.behaviour.distress.api.DistressApi$startDistress$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.secondo.behaviour.distress.api.DistressApi$startDistress$1 r0 = (com.animaconnected.secondo.behaviour.distress.api.DistressApi$startDistress$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.behaviour.distress.api.DistressApi$startDistress$1 r0 = new com.animaconnected.secondo.behaviour.distress.api.DistressApi$startDistress$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.behaviour.distress.api.DistressApi r0 = (com.animaconnected.secondo.behaviour.distress.api.DistressApi) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L4c
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r5 = r4.model
            boolean r5 = r5.canStartDistress()
            if (r5 == 0) goto L56
            com.animaconnected.watch.behaviour.distress.WalkMeHomeState r5 = com.animaconnected.watch.behaviour.distress.WalkMeHomeState.Distress
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.followMeHome(r5, r0)
            if (r5 != r1) goto L4b
            return r1
        L4b:
            r0 = r4
        L4c:
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r5 = r0.model
            com.animaconnected.watch.behaviour.distress.WalkMeHomeState r0 = com.animaconnected.watch.behaviour.distress.WalkMeHomeState.Distress
            r5.setState(r0)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L56:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "You can't be in this state when starting distress."
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.api.DistressApi.startDistress(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object startWalk(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.animaconnected.secondo.behaviour.distress.api.DistressApi$startWalk$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.secondo.behaviour.distress.api.DistressApi$startWalk$1 r0 = (com.animaconnected.secondo.behaviour.distress.api.DistressApi$startWalk$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.behaviour.distress.api.DistressApi$startWalk$1 r0 = new com.animaconnected.secondo.behaviour.distress.api.DistressApi$startWalk$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L45
            if (r2 == r5) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L8c
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.secondo.behaviour.distress.api.DistressApi r2 = (com.animaconnected.secondo.behaviour.distress.api.DistressApi) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L79
        L3d:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.secondo.behaviour.distress.api.DistressApi r2 = (com.animaconnected.secondo.behaviour.distress.api.DistressApi) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5e
        L45:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r7 = r6.model
            boolean r7 = r7.canStartWalk()
            if (r7 == 0) goto La4
            com.animaconnected.watch.behaviour.distress.WalkMeHomeState r7 = com.animaconnected.watch.behaviour.distress.WalkMeHomeState.Pending
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = r6.followMeHome(r7, r0)
            if (r7 != r1) goto L5d
            return r1
        L5d:
            r2 = r6
        L5e:
            java.lang.String r7 = com.animaconnected.secondo.behaviour.distress.api.DistressApi.TAG
            java.lang.String r5 = "Walk started"
            android.util.Log.d(r7, r5)
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r7 = r2.model
            com.animaconnected.watch.behaviour.distress.WalkMeHomeState r5 = com.animaconnected.watch.behaviour.distress.WalkMeHomeState.Pending
            r7.setState(r5)
            com.animaconnected.watch.behaviour.distress.WalkMeHomeState r7 = com.animaconnected.watch.behaviour.distress.WalkMeHomeState.Active
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r2.followMeHome(r7, r0)
            if (r7 != r1) goto L79
            return r1
        L79:
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r7 = r2.model
            com.animaconnected.watch.behaviour.distress.WalkMeHomeState r4 = com.animaconnected.watch.behaviour.distress.WalkMeHomeState.Active
            r7.setState(r4)
            r7 = 0
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r7 = r2.getUserState(r0)
            if (r7 != r1) goto L8c
            return r1
        L8c:
            com.animaconnected.secondo.behaviour.distress.api.request.UserStateResponse r7 = (com.animaconnected.secondo.behaviour.distress.api.request.UserStateResponse) r7
            java.lang.String r0 = com.animaconnected.secondo.behaviour.distress.api.DistressApi.TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "got user state "
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            android.util.Log.d(r0, r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        La4:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "You can't be in this state when starting a walk."
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.api.DistressApi.startWalk(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateLocation(com.animaconnected.secondo.behaviour.distress.api.request.FollowMeLocation r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.animaconnected.secondo.behaviour.distress.api.DistressApi$updateLocation$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.secondo.behaviour.distress.api.DistressApi$updateLocation$1 r0 = (com.animaconnected.secondo.behaviour.distress.api.DistressApi$updateLocation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.behaviour.distress.api.DistressApi$updateLocation$1 r0 = new com.animaconnected.secondo.behaviour.distress.api.DistressApi$updateLocation$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            java.lang.Object r7 = r0.L$0
            com.animaconnected.secondo.behaviour.distress.api.DistressApi r7 = (com.animaconnected.secondo.behaviour.distress.api.DistressApi) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7f
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = com.animaconnected.secondo.behaviour.distress.api.DistressApi.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "updateLocation() called with "
            r2.<init>(r5)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r8, r2)
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r8 = r6.model
            com.animaconnected.secondo.behaviour.distress.model.Subject r8 = r8.getSubject()
            if (r8 != 0) goto L53
            goto L56
        L53:
            r8.setLocation(r7)
        L56:
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r8 = r6.model
            r8.save()
            com.animaconnected.secondo.behaviour.distress.api.request.FollowMeHomeLocationRequest r8 = new com.animaconnected.secondo.behaviour.distress.api.request.FollowMeHomeLocationRequest
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r2 = r6.model
            com.animaconnected.secondo.behaviour.distress.model.Subject r2 = r2.getSubject()
            if (r2 == 0) goto L6a
            java.lang.String r2 = r2.getUserId()
            goto L6b
        L6a:
            r2 = r4
        L6b:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r8.<init>(r2, r7)
            com.animaconnected.secondo.behaviour.distress.api.DistressServiceApi r7 = r6.api
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r8 = r7.followMeHomeLocation(r8, r0)
            if (r8 != r1) goto L7e
            return r1
        L7e:
            r7 = r6
        L7f:
            retrofit2.Response r8 = (retrofit2.Response) r8
            com.animaconnected.firebase.Analytics r0 = r7.analytics
            com.animaconnected.firebase.AppEvents r0 = r0.getAppEvents()
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r1 = r7.model
            com.animaconnected.secondo.behaviour.distress.model.Subject r1 = r1.getSubject()
            if (r1 == 0) goto L94
            java.lang.String r1 = r1.getUserId()
            goto L95
        L94:
            r1 = r4
        L95:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            com.animaconnected.secondo.behaviour.distress.model.DistressModel r7 = r7.model
            com.animaconnected.secondo.behaviour.distress.model.Observer r7 = r7.getObserver()
            if (r7 == 0) goto La4
            java.lang.String r4 = r7.getUserId()
        La4:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r7 = java.lang.String.valueOf(r2)
            okhttp3.ResponseBody r8 = r8.errorBody
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r0.walkerUpdated(r1, r4, r7, r8)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.api.DistressApi.updateLocation(com.animaconnected.secondo.behaviour.distress.api.request.FollowMeLocation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private DistressApi(Context context) {
        this.model = DistressModel.Companion.getInstance(context);
        this.analytics = ProviderFactory.INSTANCE.getAnalytics();
        String str = context.getString(R.string.distress_scheme) + context.getString(R.string.distress_stable) + context.getString(R.string.distress_path);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Retrofit.Builder builder2 = new Retrofit.Builder();
        builder2.baseUrl(str);
        builder2.callFactory = new OkHttpClient(builder);
        builder2.converterFactories.add(new MoshiConverterFactory(new Moshi(new Moshi.Builder())));
        Object create = builder2.build().create(DistressServiceApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        this.api = (DistressServiceApi) create;
    }
}
