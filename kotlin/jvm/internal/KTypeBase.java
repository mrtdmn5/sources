package kotlin.jvm.internal;

import java.lang.reflect.Type;
import kotlin.reflect.KType;

/* compiled from: KTypeBase.kt */
/* loaded from: classes.dex */
public interface KTypeBase extends KType {
    Type getJavaType();
}
