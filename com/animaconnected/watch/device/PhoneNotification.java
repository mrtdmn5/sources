package com.animaconnected.watch.device;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.animaconnected.watch.image.Kolor;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.strings.KeyString;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchNotification.kt */
/* loaded from: classes3.dex */
public final class PhoneNotification {
    private final String appId;
    private final int color;
    private final int id;
    private final Mitmap image;
    private final String key;
    private final KeyString text;
    private final KeyString title;
    private final Vibration vibration;

    public /* synthetic */ PhoneNotification(int r1, String str, KeyString keyString, KeyString keyString2, Mitmap mitmap, int r6, String str2, Vibration vibration, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, str, keyString, keyString2, mitmap, r6, str2, vibration);
    }

    /* renamed from: copy-uy536eg$default, reason: not valid java name */
    public static /* synthetic */ PhoneNotification m1082copyuy536eg$default(PhoneNotification phoneNotification, int r10, String str, KeyString keyString, KeyString keyString2, Mitmap mitmap, int r15, String str2, Vibration vibration, int r18, Object obj) {
        int r2;
        String str3;
        KeyString keyString3;
        KeyString keyString4;
        Mitmap mitmap2;
        int r7;
        String str4;
        Vibration vibration2;
        if ((r18 & 1) != 0) {
            r2 = phoneNotification.id;
        } else {
            r2 = r10;
        }
        if ((r18 & 2) != 0) {
            str3 = phoneNotification.key;
        } else {
            str3 = str;
        }
        if ((r18 & 4) != 0) {
            keyString3 = phoneNotification.title;
        } else {
            keyString3 = keyString;
        }
        if ((r18 & 8) != 0) {
            keyString4 = phoneNotification.text;
        } else {
            keyString4 = keyString2;
        }
        if ((r18 & 16) != 0) {
            mitmap2 = phoneNotification.image;
        } else {
            mitmap2 = mitmap;
        }
        if ((r18 & 32) != 0) {
            r7 = phoneNotification.color;
        } else {
            r7 = r15;
        }
        if ((r18 & 64) != 0) {
            str4 = phoneNotification.appId;
        } else {
            str4 = str2;
        }
        if ((r18 & 128) != 0) {
            vibration2 = phoneNotification.vibration;
        } else {
            vibration2 = vibration;
        }
        return phoneNotification.m1084copyuy536eg(r2, str3, keyString3, keyString4, mitmap2, r7, str4, vibration2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.key;
    }

    public final KeyString component3() {
        return this.title;
    }

    public final KeyString component4() {
        return this.text;
    }

    public final Mitmap component5() {
        return this.image;
    }

    /* renamed from: component6-IpmnaRI, reason: not valid java name */
    public final int m1083component6IpmnaRI() {
        return this.color;
    }

    public final String component7() {
        return this.appId;
    }

    public final Vibration component8() {
        return this.vibration;
    }

    /* renamed from: copy-uy536eg, reason: not valid java name */
    public final PhoneNotification m1084copyuy536eg(int r12, String key, KeyString title, KeyString text, Mitmap image, int r17, String appId, Vibration vibration) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(vibration, "vibration");
        return new PhoneNotification(r12, key, title, text, image, r17, appId, vibration, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhoneNotification)) {
            return false;
        }
        PhoneNotification phoneNotification = (PhoneNotification) obj;
        if (this.id == phoneNotification.id && Intrinsics.areEqual(this.key, phoneNotification.key) && Intrinsics.areEqual(this.title, phoneNotification.title) && Intrinsics.areEqual(this.text, phoneNotification.text) && Intrinsics.areEqual(this.image, phoneNotification.image) && Kolor.m1539equalsimpl0(this.color, phoneNotification.color) && Intrinsics.areEqual(this.appId, phoneNotification.appId) && this.vibration == phoneNotification.vibration) {
            return true;
        }
        return false;
    }

    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: getColor-IpmnaRI, reason: not valid java name */
    public final int m1085getColorIpmnaRI() {
        return this.color;
    }

    public final int getId() {
        return this.id;
    }

    public final Mitmap getImage() {
        return this.image;
    }

    public final String getKey() {
        return this.key;
    }

    public final KeyString getText() {
        return this.text;
    }

    public final KeyString getTitle() {
        return this.title;
    }

    public final Vibration getVibration() {
        return this.vibration;
    }

    public int hashCode() {
        return this.vibration.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.appId, (Kolor.m1544hashCodeimpl(this.color) + ((this.image.hashCode() + ((this.text.hashCode() + ((this.title.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.key, Integer.hashCode(this.id) * 31, 31)) * 31)) * 31)) * 31)) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PhoneNotification(id=");
        sb.append(this.id);
        sb.append(", key='");
        sb.append(this.key);
        sb.append("', title length=");
        sb.append(this.title.app().length());
        sb.append(", text length=");
        sb.append(this.text.app().length());
        sb.append(", appId='");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.appId, "')");
    }

    private PhoneNotification(int r2, String key, KeyString title, KeyString text, Mitmap image, int r7, String appId, Vibration vibration) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(vibration, "vibration");
        this.id = r2;
        this.key = key;
        this.title = title;
        this.text = text;
        this.image = image;
        this.color = r7;
        this.appId = appId;
        this.vibration = vibration;
    }
}
