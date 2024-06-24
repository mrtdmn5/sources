package io.ktor.http;

import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentDisposition.kt */
/* loaded from: classes3.dex */
public final class ContentDisposition extends HeaderValueWithParameters {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        EmptyList emptyList = EmptyList.INSTANCE;
        new ContentDisposition("file", emptyList);
        new ContentDisposition("mixed", emptyList);
        new ContentDisposition("attachment", emptyList);
        new ContentDisposition("inline", emptyList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentDisposition(String disposition, List<HeaderValueParam> parameters) {
        super(disposition, parameters);
        Intrinsics.checkNotNullParameter(disposition, "disposition");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ContentDisposition) {
            ContentDisposition contentDisposition = (ContentDisposition) obj;
            if (Intrinsics.areEqual(this.content, contentDisposition.content)) {
                if (Intrinsics.areEqual(this.parameters, contentDisposition.parameters)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.parameters.hashCode() + (this.content.hashCode() * 31);
    }
}
