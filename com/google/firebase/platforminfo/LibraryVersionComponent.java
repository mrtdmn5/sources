package com.google.firebase.platforminfo;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$$ExternalSyntheticLambda0;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.RestrictedComponentContainer;

/* loaded from: classes3.dex */
public final class LibraryVersionComponent {

    /* loaded from: classes3.dex */
    public interface VersionExtractor<T> {
        String extract(Context context);
    }

    public static Component<?> create(String str, String str2) {
        AutoValue_LibraryVersion autoValue_LibraryVersion = new AutoValue_LibraryVersion(str, str2);
        Component.Builder builder = Component.builder(LibraryVersion.class);
        builder.type = 1;
        builder.factory = new Component$$ExternalSyntheticLambda0(autoValue_LibraryVersion);
        return builder.build();
    }

    public static Component<?> fromContext(final String str, final VersionExtractor<Context> versionExtractor) {
        Component.Builder builder = Component.builder(LibraryVersion.class);
        builder.type = 1;
        builder.add(Dependency.required(Context.class));
        builder.factory = new ComponentFactory() { // from class: com.google.firebase.platforminfo.LibraryVersionComponent$$ExternalSyntheticLambda0
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(RestrictedComponentContainer restrictedComponentContainer) {
                return new AutoValue_LibraryVersion(str, versionExtractor.extract((Context) restrictedComponentContainer.get(Context.class)));
            }
        };
        return builder.build();
    }
}
