package androidx.compose.foundation.text;

import androidx.compose.runtime.ComposerImpl;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.RestrictedComponentContainer;
import com.google.firebase.concurrent.ExecutorsRegistrar;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class CoreTextFieldKt$$ExternalSyntheticOutline0 implements ComponentFactory {
    public static Object m(ComposerImpl composerImpl, boolean z, int r2) {
        composerImpl.end(z);
        composerImpl.startReplaceableGroup(r2);
        return composerImpl.nextSlot();
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(RestrictedComponentContainer restrictedComponentContainer) {
        return ExecutorsRegistrar.LITE_EXECUTOR.get();
    }
}
