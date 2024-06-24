package com.amplifyframework.notifications.pushnotifications;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.amplifyframework.notifications.pushnotifications.NotificationContentProvider;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;

/* compiled from: NotificationPayload.kt */
@Parcelize
/* loaded from: classes.dex */
public class NotificationPayload implements Parcelable {
    private final String channelId;
    private final NotificationContentProvider contentProvider;
    private final Map<String, String> rawData;
    private final Class<?> targetClass;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<NotificationPayload> CREATOR = new Creator();

    /* compiled from: NotificationPayload.kt */
    /* loaded from: classes.dex */
    public static final class Builder {
        private String channelId;
        private final NotificationContentProvider contentProvider;
        private Class<?> targetClass;

        public Builder(NotificationContentProvider contentProvider) {
            Intrinsics.checkNotNullParameter(contentProvider, "contentProvider");
            this.contentProvider = contentProvider;
        }

        public final NotificationPayload build() {
            return new NotificationPayload(this);
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final NotificationContentProvider getContentProvider() {
            return this.contentProvider;
        }

        public final Class<?> getTargetClass() {
            return this.targetClass;
        }

        public final Builder notificationChannelId(String str) {
            this.channelId = str;
            return this;
        }

        public final Builder targetClass(Class<?> cls) {
            this.targetClass = cls;
            return this;
        }
    }

    /* compiled from: NotificationPayload.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Builder builder(NotificationContentProvider contentProvider) {
            Intrinsics.checkNotNullParameter(contentProvider, "contentProvider");
            return new Builder(contentProvider);
        }

        public final NotificationPayload fromIntent(Intent intent) {
            if (intent != null) {
                return (NotificationPayload) intent.getParcelableExtra("amplifyNotificationPayload");
            }
            return null;
        }

        public final NotificationPayload invoke(NotificationContentProvider contentProvider, Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(contentProvider, "contentProvider");
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder(contentProvider);
            block.invoke(builder);
            return builder.build();
        }

        private Companion() {
        }
    }

    /* compiled from: NotificationPayload.kt */
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<NotificationPayload> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NotificationPayload createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new NotificationPayload((NotificationContentProvider) parcel.readParcelable(NotificationPayload.class.getClassLoader()), parcel.readString(), (Class) parcel.readSerializable());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NotificationPayload[] newArray(int r1) {
            return new NotificationPayload[r1];
        }
    }

    public NotificationPayload(NotificationContentProvider contentProvider, String str, Class<?> cls) {
        Intrinsics.checkNotNullParameter(contentProvider, "contentProvider");
        this.contentProvider = contentProvider;
        this.channelId = str;
        this.targetClass = cls;
        this.rawData = extractRawData();
    }

    public static final Builder builder(NotificationContentProvider notificationContentProvider) {
        return Companion.builder(notificationContentProvider);
    }

    private final Map<String, String> extractRawData() {
        NotificationContentProvider notificationContentProvider = this.contentProvider;
        if (notificationContentProvider instanceof NotificationContentProvider.FCM) {
            return notificationContentProvider.getContent();
        }
        return EmptyMap.INSTANCE;
    }

    public static final NotificationPayload fromIntent(Intent intent) {
        return Companion.fromIntent(intent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final NotificationContentProvider getContentProvider() {
        return this.contentProvider;
    }

    public final Map<String, String> getRawData() {
        return this.rawData;
    }

    public final Class<?> getTargetClass() {
        return this.targetClass;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int r3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeParcelable(this.contentProvider, r3);
        out.writeString(this.channelId);
        out.writeSerializable(this.targetClass);
    }

    public /* synthetic */ NotificationPayload(NotificationContentProvider notificationContentProvider, String str, Class cls, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(notificationContentProvider, (r5 & 2) != 0 ? null : str, (r5 & 4) != 0 ? null : cls);
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public NotificationPayload(Builder builder) {
        this(builder.getContentProvider(), builder.getChannelId(), builder.getTargetClass());
        Intrinsics.checkNotNullParameter(builder, "builder");
    }

    public static /* synthetic */ void getRawData$annotations() {
    }
}
