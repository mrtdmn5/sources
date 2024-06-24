package com.animaconnected.secondo.provider.login;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.asf.SignatureGenerator$Companion$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.googlefit.GoogleFitDataSetsKt$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.screens.details.bottomdialog.DetailBottomDialog;
import com.animaconnected.watch.device.Command;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DialogMessage.kt */
/* loaded from: classes3.dex */
public final class DialogInfo {
    public static final int $stable = 0;
    private final String body;
    private final String button;
    private final String title;

    public DialogInfo(String str, String str2, String str3) {
        SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, DetailBottomDialog.keyTitle, str2, "body", str3, Command.BUTTON);
        this.title = str;
        this.body = str2;
        this.button = str3;
    }

    public static /* synthetic */ DialogInfo copy$default(DialogInfo dialogInfo, String str, String str2, String str3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = dialogInfo.title;
        }
        if ((r4 & 2) != 0) {
            str2 = dialogInfo.body;
        }
        if ((r4 & 4) != 0) {
            str3 = dialogInfo.button;
        }
        return dialogInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.body;
    }

    public final String component3() {
        return this.button;
    }

    public final DialogInfo copy(String title, String body, String button) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(button, "button");
        return new DialogInfo(title, body, button);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DialogInfo)) {
            return false;
        }
        DialogInfo dialogInfo = (DialogInfo) obj;
        if (Intrinsics.areEqual(this.title, dialogInfo.title) && Intrinsics.areEqual(this.body, dialogInfo.body) && Intrinsics.areEqual(this.button, dialogInfo.button)) {
            return true;
        }
        return false;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getButton() {
        return this.button;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.button.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.body, this.title.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DialogInfo(title=");
        sb.append(this.title);
        sb.append(", body=");
        sb.append(this.body);
        sb.append(", button=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.button, ')');
    }

    public /* synthetic */ DialogInfo(String str, String str2, String str3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (r4 & 4) != 0 ? GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(KronabyApplication.Companion, R.string.activity_ok, "getString(...)") : str3);
    }
}
