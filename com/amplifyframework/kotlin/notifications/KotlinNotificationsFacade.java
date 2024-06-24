package com.amplifyframework.kotlin.notifications;

import com.amplifyframework.analytics.UserProfile;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.kotlin.notifications.pushnotifications.KotlinPushFacade;
import com.amplifyframework.notifications.NotificationsCategoryBehavior;
import com.amplifyframework.notifications.pushnotifications.PushNotificationsException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinNotificationsFacade.kt */
/* loaded from: classes.dex */
public final class KotlinNotificationsFacade implements Notifications {
    private final KotlinPushFacade Push;
    private final NotificationsCategoryBehavior delegate;

    public KotlinNotificationsFacade() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final KotlinPushFacade getPush() {
        return this.Push;
    }

    @Override // com.amplifyframework.kotlin.notifications.Notifications
    public Object identifyUser(String str, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.identifyUser(str, new Action() { // from class: com.amplifyframework.kotlin.notifications.KotlinNotificationsFacade$identifyUser$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.notifications.KotlinNotificationsFacade$identifyUser$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(PushNotificationsException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        return orThrow == CoroutineSingletons.COROUTINE_SUSPENDED ? orThrow : Unit.INSTANCE;
    }

    public KotlinNotificationsFacade(NotificationsCategoryBehavior delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.Push = new KotlinPushFacade(null, 1, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ KotlinNotificationsFacade(com.amplifyframework.notifications.NotificationsCategoryBehavior r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto Lb
            com.amplifyframework.notifications.NotificationsCategory r1 = com.amplifyframework.core.Amplify.Notifications
            java.lang.String r2 = "Notifications"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        Lb:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.kotlin.notifications.KotlinNotificationsFacade.<init>(com.amplifyframework.notifications.NotificationsCategoryBehavior, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // com.amplifyframework.kotlin.notifications.Notifications
    public Object identifyUser(String str, UserProfile userProfile, Continuation<? super Unit> continuation) {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.identifyUser(str, userProfile, new Action() { // from class: com.amplifyframework.kotlin.notifications.KotlinNotificationsFacade$identifyUser$4$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.notifications.KotlinNotificationsFacade$identifyUser$4$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(PushNotificationsException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        return orThrow == CoroutineSingletons.COROUTINE_SUSPENDED ? orThrow : Unit.INSTANCE;
    }

    public static /* synthetic */ void getPush$annotations() {
    }
}
