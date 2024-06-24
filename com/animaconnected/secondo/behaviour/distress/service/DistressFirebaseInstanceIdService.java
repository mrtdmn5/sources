package com.animaconnected.secondo.behaviour.distress.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.behaviour.distress.api.DistressApi;
import com.animaconnected.secondo.behaviour.distress.model.DistressModel;
import com.animaconnected.secondo.behaviour.distress.model.Subject;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import kotlin.Unit;

/* loaded from: classes3.dex */
public class DistressFirebaseInstanceIdService extends BroadcastReceiver {
    private static final String TAG = "DistressFirebaseInstanceIdService";

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTokenRefresh$0(Context context, Task task) {
        if (task.isSuccessful() && task.getResult() != null) {
            String str = (String) task.getResult();
            DistressModel distressModel = DistressModel.getInstance(context);
            distressModel.setToken(null);
            Subject subject = distressModel.getSubject();
            if (subject != null && subject.isRegistered()) {
                registerToken(subject, str, context);
                return;
            }
            return;
        }
        Log.w(TAG, "FirebaseInstanceId.getInstanceId() failed", task.getException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$registerToken$1(String str, Subject subject, Context context, Unit unit) {
        Log.i(TAG, "Token " + str + " registered for user " + subject);
        DistressModel.getInstance(context).setToken(str);
        DistressModel.getInstance(context).save();
    }

    private void onTokenRefresh(final Context context) {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.animaconnected.secondo.behaviour.distress.service.DistressFirebaseInstanceIdService$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                DistressFirebaseInstanceIdService.this.lambda$onTokenRefresh$0(context, task);
            }
        });
    }

    private void registerToken(final Subject subject, final String str, final Context context) {
        Log.i(TAG, "Registering token " + str + " for user " + subject);
        DistressApi.getInstance(context).registerTokenFuture(str, subject).success(new SuccessCallback() { // from class: com.animaconnected.secondo.behaviour.distress.service.DistressFirebaseInstanceIdService$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                DistressFirebaseInstanceIdService.lambda$registerToken$1(str, subject, context, (Unit) obj);
            }
        }).fail(new DistressFirebaseInstanceIdService$$ExternalSyntheticLambda1());
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        onTokenRefresh(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$registerToken$2(Throwable th) {
    }
}
