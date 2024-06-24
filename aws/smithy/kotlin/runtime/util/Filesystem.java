package aws.smithy.kotlin.runtime.util;

import java.io.Serializable;
import kotlin.coroutines.Continuation;

/* compiled from: Filesystem.kt */
/* loaded from: classes.dex */
public interface Filesystem {
    String getFilePathSeparator();

    Serializable readFileOrNull(String str, Continuation continuation);
}
