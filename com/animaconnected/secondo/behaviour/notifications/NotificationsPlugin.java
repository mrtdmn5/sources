package com.animaconnected.secondo.behaviour.notifications;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.types.NotificationsApp;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationsPlugin.kt */
/* loaded from: classes3.dex */
public final class NotificationsPlugin implements BehaviourPlugin<NotificationsApp> {
    public static final int $stable = 8;
    private NotificationsApp notificationsApp;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<NotificationsApp>() { // from class: com.animaconnected.secondo.behaviour.notifications.NotificationsPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NotificationsApp invoke() {
            NotificationsApp notificationsApp;
            notificationsApp = NotificationsPlugin.this.notificationsApp;
            if (notificationsApp != null) {
                return notificationsApp;
            }
            Intrinsics.throwUninitializedPropertyAccessException("notificationsApp");
            throw null;
        }
    });
    private final String type = NotificationsApp.TYPE;
    private final int nameId = -1;

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return null;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getNameId() {
        return this.nameId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public void initBehaviour(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.notificationsApp = new NotificationsApp();
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public NotificationsApp getBehaviour() {
        return (NotificationsApp) this.behaviour$delegate.getValue();
    }
}
