package kotlinx.serialization;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;

/* compiled from: SerializationExceptions.kt */
/* loaded from: classes4.dex */
public final class UnknownFieldException extends SerializationException {
    public UnknownFieldException(int r2) {
        super(SubMenuBuilder$$ExternalSyntheticOutline0.m("An unknown field for index ", r2));
    }
}
