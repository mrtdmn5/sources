package com.animaconnected.secondo.behaviour.rememberthisspot;

import android.content.Context;
import android.os.Build;
import androidx.fragment.app.Fragment;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.behaviour.BehaviourPluginKt;
import com.animaconnected.secondo.behaviour.rememberthisspot.location.LocationFetcherView;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.types.RememberThisSpot;
import com.animaconnected.watch.behaviour.types.RememberThisSpotListener;
import com.animaconnected.watch.location.ErrorMissingPermission;
import com.animaconnected.watch.location.ErrorNoLocation;
import com.animaconnected.watch.location.ErrorServiceDisabled;
import com.animaconnected.watch.location.LocationResult;
import com.animaconnected.watch.location.Spot;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RememberThisSpotPlugin.kt */
/* loaded from: classes3.dex */
public final class RememberThisSpotPlugin implements BehaviourPlugin<RememberThisSpot>, RememberThisSpotListener {
    public static final int $stable = 8;
    private RememberThisSpot rememberThisSpot;
    private final String[] requiredPermissions;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<RememberThisSpot>() { // from class: com.animaconnected.secondo.behaviour.rememberthisspot.RememberThisSpotPlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RememberThisSpot invoke() {
            RememberThisSpot rememberThisSpot;
            rememberThisSpot = RememberThisSpotPlugin.this.rememberThisSpot;
            if (rememberThisSpot != null) {
                return rememberThisSpot;
            }
            Intrinsics.throwUninitializedPropertyAccessException("rememberThisSpot");
            throw null;
        }
    });
    private final String type = RememberThisSpot.TYPE;
    private final int nameId = R.string.behaviour_name_remember_this_spot;
    private final int iconResourceId = R.drawable.ic_remember_this_spot;
    private final String iconWatchAsset = "watch/ic_remember_this_spot.png";

    public RememberThisSpotPlugin() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 29) {
            strArr = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"};
        } else {
            strArr = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
        }
        this.requiredPermissions = strArr;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        BaseDetailsFragment newInstance = RememberThisSpotFragment.newInstance(slot);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
        return newInstance;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getIconResourceId() {
        return this.iconResourceId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getIconWatchAsset() {
        return this.iconWatchAsset;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getNameId() {
        return this.nameId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String[] getRequiredPermissions() {
        return this.requiredPermissions;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public void initBehaviour(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.rememberThisSpot = new RememberThisSpot(this, null, new Function0<Boolean>() { // from class: com.animaconnected.secondo.behaviour.rememberthisspot.RememberThisSpotPlugin$initBehaviour$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                RememberThisSpot rememberThisSpot;
                RememberThisSpotPlugin rememberThisSpotPlugin = RememberThisSpotPlugin.this;
                Context context2 = context;
                rememberThisSpot = rememberThisSpotPlugin.rememberThisSpot;
                if (rememberThisSpot != null) {
                    return Boolean.valueOf(!BehaviourPluginKt.showFeatureIssueNotification(rememberThisSpotPlugin, context2, rememberThisSpot.getTitle().app()));
                }
                Intrinsics.throwUninitializedPropertyAccessException("rememberThisSpot");
                throw null;
            }
        }, 2, null);
    }

    @Override // com.animaconnected.watch.behaviour.types.RememberThisSpotListener
    public void onFetched(LocationResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual(result, ErrorMissingPermission.INSTANCE)) {
            LocationFetcherView.showLocationFetchedFailed(true, false);
            return;
        }
        if (Intrinsics.areEqual(result, ErrorNoLocation.INSTANCE)) {
            LocationFetcherView.showLocationFetchedFailed(false, false);
        } else if (Intrinsics.areEqual(result, ErrorServiceDisabled.INSTANCE)) {
            LocationFetcherView.showLocationFetchedFailed(false, true);
        } else if (result instanceof Spot) {
            LocationFetcherView.showLocationFetched((Spot) result);
        }
    }

    @Override // com.animaconnected.watch.behaviour.types.RememberThisSpotListener
    public void onFetchingSpot() {
        LocationFetcherView.showLocationFetching();
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public RememberThisSpot getBehaviour() {
        return (RememberThisSpot) this.behaviour$delegate.getValue();
    }
}
