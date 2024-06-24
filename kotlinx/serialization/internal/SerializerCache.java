package kotlinx.serialization.internal;

import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

/* compiled from: Platform.common.kt */
/* loaded from: classes4.dex */
public interface SerializerCache<T> {
    KSerializer<T> get(KClass<Object> kClass);
}
