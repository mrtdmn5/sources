package com.amplifyframework.core.model;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/* loaded from: classes.dex */
public interface Model {

    /* loaded from: classes.dex */
    public enum Type {
        USER,
        SYSTEM
    }

    default String getModelName() {
        return getClass().getSimpleName();
    }

    default String getPrimaryKeyString() {
        try {
            if (resolveIdentifier() instanceof ModelIdentifier) {
                return ((ModelIdentifier) resolveIdentifier()).getIdentifier();
            }
            return (String) resolveIdentifier();
        } catch (Exception e) {
            throw new IllegalStateException(Model$$ExternalSyntheticOutline0.m("Invalid Primary Key, It should either be of type String or composite Primary Key.", e));
        }
    }

    default Serializable resolveIdentifier() {
        try {
            Object invoke = getClass().getMethod("getId", new Class[0]).invoke(this, new Object[0]);
            Objects.requireNonNull(invoke);
            return (Serializable) invoke;
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Primary key field Id not found.", e);
        } catch (NoSuchMethodException e2) {
            throw new IllegalStateException("Primary key field Id not found.", e2);
        } catch (InvocationTargetException e3) {
            throw new IllegalStateException("Primary key field Id not found.", e3);
        }
    }
}
