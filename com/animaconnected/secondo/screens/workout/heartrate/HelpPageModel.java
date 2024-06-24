package com.animaconnected.secondo.screens.workout.heartrate;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HelpPagesBottomDialog.kt */
/* loaded from: classes3.dex */
public final class HelpPageModel {
    private final int descriptionId;
    private final float lottieAspectRatio;
    private final LottieFile lottieFile;
    private final int titleId;

    public HelpPageModel(int r2, int r3, LottieFile lottieFile, float f) {
        Intrinsics.checkNotNullParameter(lottieFile, "lottieFile");
        this.titleId = r2;
        this.descriptionId = r3;
        this.lottieFile = lottieFile;
        this.lottieAspectRatio = f;
    }

    public static /* synthetic */ HelpPageModel copy$default(HelpPageModel helpPageModel, int r1, int r2, LottieFile lottieFile, float f, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            r1 = helpPageModel.titleId;
        }
        if ((r5 & 2) != 0) {
            r2 = helpPageModel.descriptionId;
        }
        if ((r5 & 4) != 0) {
            lottieFile = helpPageModel.lottieFile;
        }
        if ((r5 & 8) != 0) {
            f = helpPageModel.lottieAspectRatio;
        }
        return helpPageModel.copy(r1, r2, lottieFile, f);
    }

    public final int component1() {
        return this.titleId;
    }

    public final int component2() {
        return this.descriptionId;
    }

    public final LottieFile component3() {
        return this.lottieFile;
    }

    public final float component4() {
        return this.lottieAspectRatio;
    }

    public final HelpPageModel copy(int r2, int r3, LottieFile lottieFile, float f) {
        Intrinsics.checkNotNullParameter(lottieFile, "lottieFile");
        return new HelpPageModel(r2, r3, lottieFile, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HelpPageModel)) {
            return false;
        }
        HelpPageModel helpPageModel = (HelpPageModel) obj;
        if (this.titleId == helpPageModel.titleId && this.descriptionId == helpPageModel.descriptionId && this.lottieFile == helpPageModel.lottieFile && Float.compare(this.lottieAspectRatio, helpPageModel.lottieAspectRatio) == 0) {
            return true;
        }
        return false;
    }

    public final int getDescriptionId() {
        return this.descriptionId;
    }

    public final float getLottieAspectRatio() {
        return this.lottieAspectRatio;
    }

    public final LottieFile getLottieFile() {
        return this.lottieFile;
    }

    public final int getTitleId() {
        return this.titleId;
    }

    public int hashCode() {
        return Float.hashCode(this.lottieAspectRatio) + ((this.lottieFile.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.descriptionId, Integer.hashCode(this.titleId) * 31, 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HelpPageModel(titleId=");
        sb.append(this.titleId);
        sb.append(", descriptionId=");
        sb.append(this.descriptionId);
        sb.append(", lottieFile=");
        sb.append(this.lottieFile);
        sb.append(", lottieAspectRatio=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.lottieAspectRatio, ')');
    }
}
