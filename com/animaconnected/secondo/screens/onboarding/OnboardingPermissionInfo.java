package com.animaconnected.secondo.screens.onboarding;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.asf.SignatureGenerator$Companion$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingPermission.kt */
/* loaded from: classes3.dex */
public final class OnboardingPermissionInfo {
    public static final int $stable = 0;
    private final int imageId;
    private final String primaryButtonText;
    private final String secondaryButtonText;
    private final String title;

    public OnboardingPermissionInfo(String str, int r8, String str2, String str3) {
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, DetailBottomDialog.keyTitle, str2, "primaryButtonText", str3, "secondaryButtonText");
        this.title = str;
        this.imageId = r8;
        this.primaryButtonText = str2;
        this.secondaryButtonText = str3;
    }

    public static /* synthetic */ OnboardingPermissionInfo copy$default(OnboardingPermissionInfo onboardingPermissionInfo, String str, int r2, String str2, String str3, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = onboardingPermissionInfo.title;
        }
        if ((r5 & 2) != 0) {
            r2 = onboardingPermissionInfo.imageId;
        }
        if ((r5 & 4) != 0) {
            str2 = onboardingPermissionInfo.primaryButtonText;
        }
        if ((r5 & 8) != 0) {
            str3 = onboardingPermissionInfo.secondaryButtonText;
        }
        return onboardingPermissionInfo.copy(str, r2, str2, str3);
    }

    public final String component1() {
        return this.title;
    }

    public final int component2() {
        return this.imageId;
    }

    public final String component3() {
        return this.primaryButtonText;
    }

    public final String component4() {
        return this.secondaryButtonText;
    }

    public final OnboardingPermissionInfo copy(String title, int r3, String primaryButtonText, String secondaryButtonText) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(primaryButtonText, "primaryButtonText");
        Intrinsics.checkNotNullParameter(secondaryButtonText, "secondaryButtonText");
        return new OnboardingPermissionInfo(title, r3, primaryButtonText, secondaryButtonText);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnboardingPermissionInfo)) {
            return false;
        }
        OnboardingPermissionInfo onboardingPermissionInfo = (OnboardingPermissionInfo) obj;
        if (Intrinsics.areEqual(this.title, onboardingPermissionInfo.title) && this.imageId == onboardingPermissionInfo.imageId && Intrinsics.areEqual(this.primaryButtonText, onboardingPermissionInfo.primaryButtonText) && Intrinsics.areEqual(this.secondaryButtonText, onboardingPermissionInfo.secondaryButtonText)) {
            return true;
        }
        return false;
    }

    public final int getImageId() {
        return this.imageId;
    }

    public final String getPrimaryButtonText() {
        return this.primaryButtonText;
    }

    public final String getSecondaryButtonText() {
        return this.secondaryButtonText;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.secondaryButtonText.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.primaryButtonText, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.imageId, this.title.hashCode() * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OnboardingPermissionInfo(title=");
        sb.append(this.title);
        sb.append(", imageId=");
        sb.append(this.imageId);
        sb.append(", primaryButtonText=");
        sb.append(this.primaryButtonText);
        sb.append(", secondaryButtonText=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.secondaryButtonText, ')');
    }

    public /* synthetic */ OnboardingPermissionInfo(String str, int r2, String str2, String str3, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (r5 & 2) != 0 ? 0 : r2, str2, str3);
    }
}
