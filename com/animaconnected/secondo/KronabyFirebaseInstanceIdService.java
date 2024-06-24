package com.animaconnected.secondo;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.utils.ThreadUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

/* loaded from: classes.dex */
public class KronabyFirebaseInstanceIdService {
    private static final String ACTION_TOKEN_REFRESH = "com.animaconnected.intent.action.FIREBASE_TOKEN_REFRESHED";
    private static final String EXTRA_TOKEN = "token";
    private static final String PREF_FCM_TOKEN_TS = "fcm_token_ts";
    private static final String SHARED_PREFS_NAME = "firebase_token_storage";
    private static final String TAG = "KronabyFirebaseInstanceIdService";
    private static final float sTokenTimeout = 1.296E9f;
    private final Context mContext;

    public KronabyFirebaseInstanceIdService(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendToken$0(String str, Void r4) {
        Log.d(TAG, "Token updated: " + str);
        this.mContext.getSharedPreferences(SHARED_PREFS_NAME, 0).edit().putFloat(PREF_FCM_TOKEN_TS, (float) System.currentTimeMillis()).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendToken$1(Task task) {
        if (task.isSuccessful() && task.getResult() != null) {
            final String str = (String) task.getResult();
            if (ProviderFactory.createSigninProvider().isSignedIn()) {
                Log.d(TAG, "Will try to sendToken... ");
                ProviderFactory.getCloudProvider().updateTokens(str).success(new SuccessCallback() { // from class: com.animaconnected.secondo.KronabyFirebaseInstanceIdService$$ExternalSyntheticLambda1
                    @Override // com.animaconnected.future.SuccessCallback
                    public final void onSuccess(Object obj) {
                        KronabyFirebaseInstanceIdService.this.lambda$sendToken$0(str, (Void) obj);
                    }
                });
                return;
            } else {
                Log.d(TAG, "Abort trying to update token (not signed in): " + str);
                return;
            }
        }
        Log.w(TAG, "FirebaseInstanceId.getInstanceId() failed", task.getException());
    }

    private void sendToken() {
        Log.d(TAG, "sendToken invoked");
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.animaconnected.secondo.KronabyFirebaseInstanceIdService$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                KronabyFirebaseInstanceIdService.this.lambda$sendToken$1(task);
            }
        });
    }

    public void onTokenRefresh(String str) {
        Log.i(TAG, "Refreshed token: " + str);
        Intent intent = new Intent();
        intent.setAction(ACTION_TOKEN_REFRESH);
        intent.setPackage(KronabyApplication.getContext().getPackageName());
        intent.putExtra("token", str);
        this.mContext.sendBroadcast(intent);
        sendToken();
    }

    public void refreshTokenIfNeeded() {
        Log.d(TAG, "refreshTokenIfNeeded called");
        ThreadUtils.assertIsOnMainThread();
        if (((float) System.currentTimeMillis()) - this.mContext.getSharedPreferences(SHARED_PREFS_NAME, 0).getFloat(PREF_FCM_TOKEN_TS, 0.0f) >= sTokenTimeout) {
            sendToken();
        }
    }
}
