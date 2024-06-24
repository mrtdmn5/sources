package com.amplifyframework.predictions.operation;

import com.amplifyframework.core.async.AmplifyOperation;
import com.amplifyframework.core.category.CategoryType;
import com.amplifyframework.predictions.models.IdentifyAction;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class IdentifyOperation<R> extends AmplifyOperation<R> {
    private final IdentifyAction identifyAction;

    public IdentifyOperation(IdentifyAction identifyAction, R r) {
        super(CategoryType.PREDICTIONS, r);
        Objects.requireNonNull(identifyAction);
        this.identifyAction = identifyAction;
    }

    public IdentifyAction getIdentifyAction() {
        return this.identifyAction;
    }
}
