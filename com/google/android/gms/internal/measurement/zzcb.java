package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzcb extends zzbn implements zzcc {
    public zzcb() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzcc asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (queryLocalInterface instanceof zzcc) {
            return (zzcc) queryLocalInterface;
        }
        return new zzca(iBinder);
    }

    @Override // com.google.android.gms.internal.measurement.zzbn
    public final boolean zza(int r12, Parcel parcel, Parcel parcel2) throws RemoteException {
        boolean z;
        boolean z2;
        zzcf zzcdVar;
        boolean z3;
        boolean z4 = false;
        zzcf zzcfVar = null;
        zzcf zzcfVar2 = null;
        zzcf zzcfVar3 = null;
        zzcf zzcfVar4 = null;
        zzci zzciVar = null;
        zzci zzciVar2 = null;
        zzci zzciVar3 = null;
        zzcf zzcfVar5 = null;
        zzcf zzcfVar6 = null;
        zzcf zzcfVar7 = null;
        zzcf zzcfVar8 = null;
        zzcf zzcfVar9 = null;
        zzcf zzcfVar10 = null;
        zzck zzckVar = null;
        zzcf zzcfVar11 = null;
        zzcf zzcfVar12 = null;
        zzcf zzcfVar13 = null;
        zzcf zzcfVar14 = null;
        zzcf zzcfVar15 = null;
        switch (r12) {
            case 1:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzcl zzclVar = (zzcl) zzbo.zza(parcel, zzcl.CREATOR);
                long readLong = parcel.readLong();
                zzbo.zzc(parcel);
                initialize(asInterface, zzclVar, readLong);
                break;
            case 2:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Bundle bundle = (Bundle) zzbo.zza(parcel, Bundle.CREATOR);
                if (parcel.readInt() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (parcel.readInt() != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                long readLong2 = parcel.readLong();
                zzbo.zzc(parcel);
                logEvent(readString, readString2, bundle, z, z2, readLong2);
                break;
            case 3:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                Bundle bundle2 = (Bundle) zzbo.zza(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface instanceof zzcf) {
                        zzcdVar = (zzcf) queryLocalInterface;
                    } else {
                        zzcdVar = new zzcd(readStrongBinder);
                    }
                    zzcfVar = zzcdVar;
                }
                long readLong3 = parcel.readLong();
                zzbo.zzc(parcel);
                logEventAndBundle(readString3, readString4, bundle2, zzcfVar, readLong3);
                break;
            case 4:
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                ClassLoader classLoader = zzbo.zza;
                if (parcel.readInt() != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                long readLong4 = parcel.readLong();
                zzbo.zzc(parcel);
                setUserProperty(readString5, readString6, asInterface2, z3, readLong4);
                break;
            case 5:
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                ClassLoader classLoader2 = zzbo.zza;
                if (parcel.readInt() != 0) {
                    z4 = true;
                }
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface2 instanceof zzcf) {
                        zzcfVar15 = (zzcf) queryLocalInterface2;
                    } else {
                        zzcfVar15 = new zzcd(readStrongBinder2);
                    }
                }
                zzbo.zzc(parcel);
                getUserProperties(readString7, readString8, z4, zzcfVar15);
                break;
            case 6:
                String readString9 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface3 instanceof zzcf) {
                        zzcfVar14 = (zzcf) queryLocalInterface3;
                    } else {
                        zzcfVar14 = new zzcd(readStrongBinder3);
                    }
                }
                zzbo.zzc(parcel);
                getMaxUserProperties(readString9, zzcfVar14);
                break;
            case 7:
                String readString10 = parcel.readString();
                long readLong5 = parcel.readLong();
                zzbo.zzc(parcel);
                setUserId(readString10, readLong5);
                break;
            case 8:
                Bundle bundle3 = (Bundle) zzbo.zza(parcel, Bundle.CREATOR);
                long readLong6 = parcel.readLong();
                zzbo.zzc(parcel);
                setConditionalUserProperty(bundle3, readLong6);
                break;
            case 9:
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                Bundle bundle4 = (Bundle) zzbo.zza(parcel, Bundle.CREATOR);
                zzbo.zzc(parcel);
                clearConditionalUserProperty(readString11, readString12, bundle4);
                break;
            case 10:
                String readString13 = parcel.readString();
                String readString14 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface4 instanceof zzcf) {
                        zzcfVar13 = (zzcf) queryLocalInterface4;
                    } else {
                        zzcfVar13 = new zzcd(readStrongBinder4);
                    }
                }
                zzbo.zzc(parcel);
                getConditionalUserProperties(readString13, readString14, zzcfVar13);
                break;
            case 11:
                ClassLoader classLoader3 = zzbo.zza;
                if (parcel.readInt() != 0) {
                    z4 = true;
                }
                long readLong7 = parcel.readLong();
                zzbo.zzc(parcel);
                setMeasurementEnabled(z4, readLong7);
                break;
            case 12:
                long readLong8 = parcel.readLong();
                zzbo.zzc(parcel);
                resetAnalyticsData(readLong8);
                break;
            case 13:
                long readLong9 = parcel.readLong();
                zzbo.zzc(parcel);
                setMinimumSessionDuration(readLong9);
                break;
            case 14:
                long readLong10 = parcel.readLong();
                zzbo.zzc(parcel);
                setSessionTimeoutDuration(readLong10);
                break;
            case 15:
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString15 = parcel.readString();
                String readString16 = parcel.readString();
                long readLong11 = parcel.readLong();
                zzbo.zzc(parcel);
                setCurrentScreen(asInterface3, readString15, readString16, readLong11);
                break;
            case 16:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface5 instanceof zzcf) {
                        zzcfVar12 = (zzcf) queryLocalInterface5;
                    } else {
                        zzcfVar12 = new zzcd(readStrongBinder5);
                    }
                }
                zzbo.zzc(parcel);
                getCurrentScreenName(zzcfVar12);
                break;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface6 instanceof zzcf) {
                        zzcfVar11 = (zzcf) queryLocalInterface6;
                    } else {
                        zzcfVar11 = new zzcd(readStrongBinder6);
                    }
                }
                zzbo.zzc(parcel);
                getCurrentScreenClass(zzcfVar11);
                break;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    if (queryLocalInterface7 instanceof zzck) {
                        zzckVar = (zzck) queryLocalInterface7;
                    } else {
                        zzckVar = new zzcj(readStrongBinder7);
                    }
                }
                zzbo.zzc(parcel);
                setInstanceIdProvider(zzckVar);
                break;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface8 instanceof zzcf) {
                        zzcfVar10 = (zzcf) queryLocalInterface8;
                    } else {
                        zzcfVar10 = new zzcd(readStrongBinder8);
                    }
                }
                zzbo.zzc(parcel);
                getCachedAppInstanceId(zzcfVar10);
                break;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface9 instanceof zzcf) {
                        zzcfVar9 = (zzcf) queryLocalInterface9;
                    } else {
                        zzcfVar9 = new zzcd(readStrongBinder9);
                    }
                }
                zzbo.zzc(parcel);
                getAppInstanceId(zzcfVar9);
                break;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface10 instanceof zzcf) {
                        zzcfVar8 = (zzcf) queryLocalInterface10;
                    } else {
                        zzcfVar8 = new zzcd(readStrongBinder10);
                    }
                }
                zzbo.zzc(parcel);
                getGmpAppId(zzcfVar8);
                break;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface11 instanceof zzcf) {
                        zzcfVar7 = (zzcf) queryLocalInterface11;
                    } else {
                        zzcfVar7 = new zzcd(readStrongBinder11);
                    }
                }
                zzbo.zzc(parcel);
                generateEventId(zzcfVar7);
                break;
            case 23:
                String readString17 = parcel.readString();
                long readLong12 = parcel.readLong();
                zzbo.zzc(parcel);
                beginAdUnitExposure(readString17, readLong12);
                break;
            case 24:
                String readString18 = parcel.readString();
                long readLong13 = parcel.readLong();
                zzbo.zzc(parcel);
                endAdUnitExposure(readString18, readLong13);
                break;
            case 25:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong14 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityStarted(asInterface4, readLong14);
                break;
            case 26:
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong15 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityStopped(asInterface5, readLong15);
                break;
            case 27:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                Bundle bundle5 = (Bundle) zzbo.zza(parcel, Bundle.CREATOR);
                long readLong16 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityCreated(asInterface6, bundle5, readLong16);
                break;
            case 28:
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong17 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityDestroyed(asInterface7, readLong17);
                break;
            case 29:
                IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong18 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityPaused(asInterface8, readLong18);
                break;
            case 30:
                IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong19 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivityResumed(asInterface9, readLong19);
                break;
            case 31:
                IObjectWrapper asInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface12 instanceof zzcf) {
                        zzcfVar6 = (zzcf) queryLocalInterface12;
                    } else {
                        zzcfVar6 = new zzcd(readStrongBinder12);
                    }
                }
                long readLong20 = parcel.readLong();
                zzbo.zzc(parcel);
                onActivitySaveInstanceState(asInterface10, zzcfVar6, readLong20);
                break;
            case 32:
                Bundle bundle6 = (Bundle) zzbo.zza(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface13 instanceof zzcf) {
                        zzcfVar5 = (zzcf) queryLocalInterface13;
                    } else {
                        zzcfVar5 = new zzcd(readStrongBinder13);
                    }
                }
                long readLong21 = parcel.readLong();
                zzbo.zzc(parcel);
                performAction(bundle6, zzcfVar5, readLong21);
                break;
            case 33:
                int readInt = parcel.readInt();
                String readString19 = parcel.readString();
                IObjectWrapper asInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbo.zzc(parcel);
                logHealthData(readInt, readString19, asInterface11, asInterface12, asInterface13);
                break;
            case 34:
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface14 instanceof zzci) {
                        zzciVar3 = (zzci) queryLocalInterface14;
                    } else {
                        zzciVar3 = new zzcg(readStrongBinder14);
                    }
                }
                zzbo.zzc(parcel);
                setEventInterceptor(zzciVar3);
                break;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface15 instanceof zzci) {
                        zzciVar2 = (zzci) queryLocalInterface15;
                    } else {
                        zzciVar2 = new zzcg(readStrongBinder15);
                    }
                }
                zzbo.zzc(parcel);
                registerOnMeasurementEventListener(zzciVar2);
                break;
            case 36:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface16 instanceof zzci) {
                        zzciVar = (zzci) queryLocalInterface16;
                    } else {
                        zzciVar = new zzcg(readStrongBinder16);
                    }
                }
                zzbo.zzc(parcel);
                unregisterOnMeasurementEventListener(zzciVar);
                break;
            case 37:
                HashMap readHashMap = parcel.readHashMap(zzbo.zza);
                zzbo.zzc(parcel);
                initForTests(readHashMap);
                break;
            case 38:
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface17 instanceof zzcf) {
                        zzcfVar4 = (zzcf) queryLocalInterface17;
                    } else {
                        zzcfVar4 = new zzcd(readStrongBinder17);
                    }
                }
                int readInt2 = parcel.readInt();
                zzbo.zzc(parcel);
                getTestFlag(zzcfVar4, readInt2);
                break;
            case 39:
                ClassLoader classLoader4 = zzbo.zza;
                if (parcel.readInt() != 0) {
                    z4 = true;
                }
                zzbo.zzc(parcel);
                setDataCollectionEnabled(z4);
                break;
            case 40:
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface18 instanceof zzcf) {
                        zzcfVar3 = (zzcf) queryLocalInterface18;
                    } else {
                        zzcfVar3 = new zzcd(readStrongBinder18);
                    }
                }
                zzbo.zzc(parcel);
                isDataCollectionEnabled(zzcfVar3);
                break;
            case 41:
            default:
                return false;
            case 42:
                Bundle bundle7 = (Bundle) zzbo.zza(parcel, Bundle.CREATOR);
                zzbo.zzc(parcel);
                setDefaultEventParameters(bundle7);
                break;
            case 43:
                long readLong22 = parcel.readLong();
                zzbo.zzc(parcel);
                clearMeasurementEnabled(readLong22);
                break;
            case 44:
                Bundle bundle8 = (Bundle) zzbo.zza(parcel, Bundle.CREATOR);
                long readLong23 = parcel.readLong();
                zzbo.zzc(parcel);
                setConsent(bundle8, readLong23);
                break;
            case 45:
                Bundle bundle9 = (Bundle) zzbo.zza(parcel, Bundle.CREATOR);
                long readLong24 = parcel.readLong();
                zzbo.zzc(parcel);
                setConsentThirdParty(bundle9, readLong24);
                break;
            case 46:
                IBinder readStrongBinder19 = parcel.readStrongBinder();
                if (readStrongBinder19 != null) {
                    IInterface queryLocalInterface19 = readStrongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface19 instanceof zzcf) {
                        zzcfVar2 = (zzcf) queryLocalInterface19;
                    } else {
                        zzcfVar2 = new zzcd(readStrongBinder19);
                    }
                }
                zzbo.zzc(parcel);
                getSessionId(zzcfVar2);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
