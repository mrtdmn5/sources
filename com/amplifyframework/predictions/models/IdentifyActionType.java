package com.amplifyframework.predictions.models;

/* loaded from: classes.dex */
public enum IdentifyActionType implements IdentifyAction {
    DETECT_CELEBRITIES,
    DETECT_LABELS,
    DETECT_ENTITIES,
    DETECT_TEXT;

    @Override // com.amplifyframework.predictions.models.IdentifyAction
    public final IdentifyActionType getType() {
        return this;
    }
}
