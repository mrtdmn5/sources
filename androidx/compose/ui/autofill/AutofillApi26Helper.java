package androidx.compose.ui.autofill;

import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidAutofill.android.kt */
/* loaded from: classes.dex */
public final class AutofillApi26Helper {
    public static final AutofillApi26Helper INSTANCE = new AutofillApi26Helper();

    public final AutofillId getAutofillId(ViewStructure structure) {
        AutofillId autofillId;
        Intrinsics.checkNotNullParameter(structure, "structure");
        autofillId = structure.getAutofillId();
        return autofillId;
    }

    public final boolean isDate(AutofillValue value) {
        boolean isDate;
        Intrinsics.checkNotNullParameter(value, "value");
        isDate = value.isDate();
        return isDate;
    }

    public final boolean isList(AutofillValue value) {
        boolean isList;
        Intrinsics.checkNotNullParameter(value, "value");
        isList = value.isList();
        return isList;
    }

    public final boolean isText(AutofillValue value) {
        boolean isText;
        Intrinsics.checkNotNullParameter(value, "value");
        isText = value.isText();
        return isText;
    }

    public final boolean isToggle(AutofillValue value) {
        boolean isToggle;
        Intrinsics.checkNotNullParameter(value, "value");
        isToggle = value.isToggle();
        return isToggle;
    }

    public final void setAutofillHints(ViewStructure structure, String[] hints) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        Intrinsics.checkNotNullParameter(hints, "hints");
        structure.setAutofillHints(hints);
    }

    public final void setAutofillId(ViewStructure structure, AutofillId parent, int r4) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        Intrinsics.checkNotNullParameter(parent, "parent");
        structure.setAutofillId(parent, r4);
    }

    public final void setAutofillType(ViewStructure structure, int r3) {
        Intrinsics.checkNotNullParameter(structure, "structure");
        structure.setAutofillType(r3);
    }

    public final CharSequence textValue(AutofillValue value) {
        CharSequence textValue;
        Intrinsics.checkNotNullParameter(value, "value");
        textValue = value.getTextValue();
        Intrinsics.checkNotNullExpressionValue(textValue, "value.textValue");
        return textValue;
    }
}
