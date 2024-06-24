package com.amplifyframework.kotlin.notifications.pushnotifications;

import com.amplifyframework.analytics.UserProfile;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.notifications.pushnotifications.NotificationPayload;
import com.amplifyframework.notifications.pushnotifications.PushNotificationsCategoryBehavior;
import com.amplifyframework.notifications.pushnotifications.PushNotificationsException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinPushFacade.kt */
/* loaded from: classes.dex */
public final class KotlinPushFacade implements Push {
    private final PushNotificationsCategoryBehavior delegate;

    public KotlinPushFacade() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.amplifyframework.kotlin.notifications.pushnotifications.Push
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object handleNotificationReceived(com.amplifyframework.notifications.pushnotifications.NotificationPayload r5, kotlin.coroutines.Continuation<? super com.amplifyframework.notifications.pushnotifications.PushNotificationResult> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$handleNotificationReceived$1
            if (r0 == 0) goto L13
            r0 = r6
            com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$handleNotificationReceived$1 r0 = (com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$handleNotificationReceived$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$handleNotificationReceived$1 r0 = new com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$handleNotificationReceived$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.L$1
            com.amplifyframework.notifications.pushnotifications.NotificationPayload r5 = (com.amplifyframework.notifications.pushnotifications.NotificationPayload) r5
            java.lang.Object r5 = r0.L$0
            com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade r5 = (com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5f
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            kotlin.coroutines.SafeContinuation r6 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)
            r6.<init>(r0)
            com.amplifyframework.notifications.pushnotifications.PushNotificationsCategoryBehavior r0 = r4.delegate
            com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$handleNotificationReceived$2$1 r2 = new com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$handleNotificationReceived$2$1
            r2.<init>()
            com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$handleNotificationReceived$2$2 r3 = new com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$handleNotificationReceived$2$2
            r3.<init>()
            r0.handleNotificationReceived(r5, r2, r3)
            java.lang.Object r6 = r6.getOrThrow()
            if (r6 != r1) goto L5f
            return r1
        L5f:
            java.lang.String r5 = "suspendCoroutine { conti…ion(it) }\n        )\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade.handleNotificationReceived(com.amplifyframework.notifications.pushnotifications.NotificationPayload, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.amplifyframework.kotlin.notifications.Notifications
    public Object identifyUser(String str, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.identifyUser(str, new Action() { // from class: com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$identifyUser$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$identifyUser$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(PushNotificationsException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        return orThrow == CoroutineSingletons.COROUTINE_SUSPENDED ? orThrow : Unit.INSTANCE;
    }

    @Override // com.amplifyframework.kotlin.notifications.pushnotifications.Push
    public Object recordNotificationOpened(NotificationPayload notificationPayload, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.recordNotificationOpened(notificationPayload, new Action() { // from class: com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$recordNotificationOpened$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$recordNotificationOpened$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(PushNotificationsException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    @Override // com.amplifyframework.kotlin.notifications.pushnotifications.Push
    public Object recordNotificationReceived(NotificationPayload notificationPayload, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.recordNotificationReceived(notificationPayload, new Action() { // from class: com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$recordNotificationReceived$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$recordNotificationReceived$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(PushNotificationsException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    @Override // com.amplifyframework.kotlin.notifications.pushnotifications.Push
    public Object registerDevice(String str, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.registerDevice(str, new Action() { // from class: com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$registerDevice$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$registerDevice$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(PushNotificationsException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    @Override // com.amplifyframework.kotlin.notifications.pushnotifications.Push
    public boolean shouldHandleNotification(NotificationPayload payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        return this.delegate.shouldHandleNotification(payload);
    }

    public KotlinPushFacade(PushNotificationsCategoryBehavior delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    public /* synthetic */ KotlinPushFacade(PushNotificationsCategoryBehavior pushNotificationsCategoryBehavior, int r2, DefaultConstructorMarker defaultConstructorMarker) {
        this((r2 & 1) != 0 ? Amplify.Notifications.Push : pushNotificationsCategoryBehavior);
    }

    @Override // com.amplifyframework.kotlin.notifications.Notifications
    public Object identifyUser(String str, UserProfile userProfile, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.identifyUser(str, userProfile, new Action() { // from class: com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$identifyUser$4$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade$identifyUser$4$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(PushNotificationsException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        return orThrow == CoroutineSingletons.COROUTINE_SUSPENDED ? orThrow : Unit.INSTANCE;
    }
}
