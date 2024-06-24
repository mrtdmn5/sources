package com.google.android.gms.internal.measurement;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzjz {
    public static final Logger zza = Logger.getLogger(zzjm.class.getName());
    public static final String zzb = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    public static zzjr zzb() {
        String format;
        ClassLoader classLoader = zzjz.class.getClassLoader();
        if (zzjr.class.equals(zzjr.class)) {
            format = zzb;
        } else if (zzjr.class.getPackage().equals(zzjz.class.getPackage())) {
            format = String.format("%s.BlazeGenerated%sLoader", zzjr.class.getPackage().getName(), "zzjr");
        } else {
            throw new IllegalArgumentException(zzjr.class.getName());
        }
        try {
            try {
                try {
                    try {
                        return (zzjr) zzjr.class.cast(((zzjz) Class.forName(format, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zza());
                    } catch (InstantiationException e) {
                        throw new IllegalStateException(e);
                    } catch (InvocationTargetException e2) {
                        throw new IllegalStateException(e2);
                    }
                } catch (IllegalAccessException e3) {
                    throw new IllegalStateException(e3);
                }
            } catch (NoSuchMethodException e4) {
                throw new IllegalStateException(e4);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(zzjz.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add((zzjr) zzjr.class.cast(((zzjz) it.next()).zza()));
                } catch (ServiceConfigurationError e5) {
                    zza.logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat("zzjr"), (Throwable) e5);
                }
            }
            if (arrayList.size() == 1) {
                return (zzjr) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (zzjr) zzjr.class.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(e6);
            } catch (NoSuchMethodException e7) {
                throw new IllegalStateException(e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(e8);
            }
        }
    }

    public abstract zzjr zza();
}
