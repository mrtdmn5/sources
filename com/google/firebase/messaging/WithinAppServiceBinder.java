package com.google.firebase.messaging;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.EnhancedIntentService;
import com.google.firebase.messaging.WithinAppServiceConnection;

/* loaded from: classes3.dex */
public final class WithinAppServiceBinder extends Binder {
    public final IntentHandler intentHandler;

    /* loaded from: classes3.dex */
    public interface IntentHandler {
    }

    public WithinAppServiceBinder(EnhancedIntentService.AnonymousClass1 anonymousClass1) {
        this.intentHandler = anonymousClass1;
    }

    public final void send(final WithinAppServiceConnection.BindRequest bindRequest) {
        Task processIntent;
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "service received new intent via bind strategy");
            }
            processIntent = EnhancedIntentService.this.processIntent(bindRequest.intent);
            processIntent.addOnCompleteListener(new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new OnCompleteListener() { // from class: com.google.firebase.messaging.WithinAppServiceBinder$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    WithinAppServiceConnection.BindRequest.this.taskCompletionSource.trySetResult(null);
                }
            });
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
