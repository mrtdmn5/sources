package com.amplifyframework.notifications.pushnotifications;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;

/* compiled from: NotificationPayload.kt */
@Parcelize
/* loaded from: classes.dex */
public class NotificationContentProvider implements Parcelable {
    public static final Parcelable.Creator<NotificationContentProvider> CREATOR = new Creator();
    private final Map<String, String> content;

    /* compiled from: NotificationPayload.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<NotificationContentProvider> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NotificationContentProvider createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int r2 = 0; r2 != readInt; r2++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            return new NotificationContentProvider(linkedHashMap);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NotificationContentProvider[] newArray(int r1) {
            return new NotificationContentProvider[r1];
        }
    }

    /* compiled from: NotificationPayload.kt */
    @Parcelize
    /* loaded from: classes.dex */
    public static final class FCM extends NotificationContentProvider {
        public static final Parcelable.Creator<FCM> CREATOR = new Creator();
        private final Map<String, String> content;

        /* compiled from: NotificationPayload.kt */
        /* loaded from: classes.dex */
        public static final class Creator implements Parcelable.Creator<FCM> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FCM createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                for (int r2 = 0; r2 != readInt; r2++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
                return new FCM(linkedHashMap);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FCM[] newArray(int r1) {
                return new FCM[r1];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FCM(Map<String, String> content) {
            super(content);
            Intrinsics.checkNotNullParameter(content, "content");
            this.content = content;
        }

        @Override // com.amplifyframework.notifications.pushnotifications.NotificationContentProvider
        public Map<String, String> getContent() {
            return this.content;
        }

        @Override // com.amplifyframework.notifications.pushnotifications.NotificationContentProvider, android.os.Parcelable
        public void writeToParcel(Parcel out, int r4) {
            Intrinsics.checkNotNullParameter(out, "out");
            Map<String, String> map = this.content;
            out.writeInt(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                out.writeString(entry.getKey());
                out.writeString(entry.getValue());
            }
        }
    }

    public NotificationContentProvider(Map<String, String> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, String> getContent() {
        return this.content;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int r4) {
        Intrinsics.checkNotNullParameter(out, "out");
        Map<String, String> map = this.content;
        out.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            out.writeString(entry.getKey());
            out.writeString(entry.getValue());
        }
    }
}
