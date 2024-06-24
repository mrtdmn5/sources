package com.google.android.gms.common.wrappers;

import android.content.Context;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.google.android.gms.common.util.PlatformVersion;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.SerializationException;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class InstantApps {
    public static Context zza;
    public static Boolean zzb;

    public static synchronized boolean isInstantApp(Context context) {
        boolean isInstantApp;
        Boolean bool;
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = zza;
            if (context2 != null && (bool = zzb) != null && context2 == applicationContext) {
                return bool.booleanValue();
            }
            zzb = null;
            if (PlatformVersion.isAtLeastO()) {
                isInstantApp = applicationContext.getPackageManager().isInstantApp();
                zzb = Boolean.valueOf(isInstantApp);
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    zzb = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    zzb = Boolean.FALSE;
                }
            }
            zza = applicationContext;
            return zzb.booleanValue();
        }
    }

    public static final void throwSubtypeNotRegistered(String str, KClass baseClass) {
        String m;
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        String str2 = "in the scope of '" + baseClass.getSimpleName() + '\'';
        if (str == null) {
            m = ConstraintSet$$ExternalSyntheticOutline0.m("Class discriminator was missing and no default polymorphic serializers were registered ", str2);
        } else {
            StringBuilder sb = new StringBuilder("Class '");
            sb.append(str);
            sb.append("' is not registered for polymorphic serialization ");
            sb.append(str2);
            sb.append(".\nTo be registered automatically, class '");
            sb.append(str);
            sb.append("' has to be '@Serializable', and the base class '");
            sb.append(baseClass.getSimpleName());
            sb.append("' has to be sealed and '@Serializable'.\nAlternatively, register the serializer for '");
            m = ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, str, "' explicitly in a corresponding SerializersModule.");
        }
        throw new SerializationException(m);
    }
}
