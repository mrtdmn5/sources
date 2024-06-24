package androidx.compose.ui.text.font;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontWeight.kt */
/* loaded from: classes.dex */
public final class FontWeight implements Comparable<FontWeight> {
    public static final FontWeight Bold;
    public static final FontWeight Light;
    public static final FontWeight Medium;
    public static final FontWeight Normal;
    public static final FontWeight SemiBold;
    public static final FontWeight W400;
    public static final FontWeight W500;
    public static final FontWeight W600;
    public static final List<FontWeight> values;
    public final int weight;

    static {
        FontWeight fontWeight = new FontWeight(100);
        FontWeight fontWeight2 = new FontWeight(200);
        FontWeight fontWeight3 = new FontWeight(TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY);
        FontWeight fontWeight4 = new FontWeight(400);
        W400 = fontWeight4;
        FontWeight fontWeight5 = new FontWeight(500);
        W500 = fontWeight5;
        FontWeight fontWeight6 = new FontWeight(600);
        W600 = fontWeight6;
        FontWeight fontWeight7 = new FontWeight(TipsAndTricksConstants.FIND_PHONE_PRIORITY);
        FontWeight fontWeight8 = new FontWeight(TipsAndTricksConstants.REJECT_CALL_PRIORITY);
        FontWeight fontWeight9 = new FontWeight(STSAssumeRoleSessionCredentialsProvider.DEFAULT_DURATION_SECONDS);
        Light = fontWeight3;
        Normal = fontWeight4;
        Medium = fontWeight5;
        SemiBold = fontWeight6;
        Bold = fontWeight7;
        values = CollectionsKt__CollectionsKt.listOf((Object[]) new FontWeight[]{fontWeight, fontWeight2, fontWeight3, fontWeight4, fontWeight5, fontWeight6, fontWeight7, fontWeight8, fontWeight9});
    }

    public FontWeight(int r4) {
        this.weight = r4;
        boolean z = false;
        if (1 <= r4 && r4 < 1001) {
            z = true;
        }
        if (z) {
        } else {
            throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Font weight can be in range [1, 1000]. Current value: ", r4).toString());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FontWeight)) {
            return false;
        }
        if (this.weight == ((FontWeight) obj).weight) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.weight;
    }

    public final String toString() {
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(new StringBuilder("FontWeight(weight="), this.weight, ')');
    }

    @Override // java.lang.Comparable
    public final int compareTo(FontWeight other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.compare(this.weight, other.weight);
    }
}
