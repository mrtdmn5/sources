package com.amplifyframework.predictions.models;

/* loaded from: classes.dex */
public enum TextFormatType implements IdentifyAction {
    FORM,
    TABLE,
    PLAIN,
    ALL;

    @Override // com.amplifyframework.predictions.models.IdentifyAction
    public final IdentifyActionType getType() {
        return IdentifyActionType.DETECT_TEXT;
    }
}
