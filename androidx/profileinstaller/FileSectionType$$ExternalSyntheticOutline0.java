package androidx.profileinstaller;

import com.animaconnected.future.MapCallback;
import com.animaconnected.secondo.screens.notification.NotificationDragAndDropProvider;
import java.util.List;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class FileSectionType$$ExternalSyntheticOutline0 implements MapCallback {
    public static String m(String str, long j) {
        return str + j;
    }

    @Override // com.animaconnected.future.MapCallback
    public Object onResult(Object obj) {
        Void lambda$updateNotificationsGroups$12;
        lambda$updateNotificationsGroups$12 = NotificationDragAndDropProvider.lambda$updateNotificationsGroups$12((List) obj);
        return lambda$updateNotificationsGroups$12;
    }
}
