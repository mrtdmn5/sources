package com.google.common.hash;

import android.graphics.Typeface;
import java.util.List;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.internal.PolymorphismValidator;

/* loaded from: classes3.dex */
public abstract class AbstractHasher {
    public abstract void dumpTo(PolymorphismValidator polymorphismValidator);

    public abstract KSerializer getContextual(KClass kClass, List list);

    public abstract DeserializationStrategy getPolymorphic(String str, KClass kClass);

    public abstract SerializationStrategy getPolymorphic(Object obj, KClass kClass);

    public abstract void onFontRetrievalFailed(int r1);

    public abstract void onFontRetrieved(Typeface typeface, boolean z);
}
