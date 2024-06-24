package com.animaconnected.secondo.behaviour;

import android.content.Context;
import com.animaconnected.draganddrop.provider.BadgeState;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.PermissionProvider;
import com.animaconnected.secondo.provider.location.AndroidLocationBackend;
import com.animaconnected.secondo.screens.behaviourconfiguration.ConfigurationChecker;
import com.animaconnected.secondo.screens.behaviourconfiguration.FeatureIssue;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.animaconnected.watch.behaviour.Behaviour;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BehaviourPlugin.kt */
/* loaded from: classes3.dex */
public final class BehaviourPluginKt {
    public static final BadgeState getBadgeState(BehaviourPlugin<Behaviour> behaviourPlugin) {
        Intrinsics.checkNotNullParameter(behaviourPlugin, "<this>");
        PermissionProvider.Companion companion = PermissionProvider.Companion;
        if (!companion.filterMissingPermissions(behaviourPlugin.getRequiredPermissions(), KronabyApplication.Companion.getContext()).isEmpty()) {
            return BadgeState.Error;
        }
        if (companion.isLocationPermission(behaviourPlugin.getRequiredPermissions()) && !AndroidLocationBackend.isLocationEnabled()) {
            return BadgeState.Error;
        }
        if (!ConfigurationChecker.isConfigured(behaviourPlugin)) {
            return BadgeState.Neutral;
        }
        if (behaviourPlugin.isNew()) {
            return BadgeState.Positive;
        }
        return BadgeState.Normal;
    }

    public static final boolean showFeatureIssueNotification(BehaviourPlugin<?> behaviourPlugin, Context context, String behaviourName) {
        Intrinsics.checkNotNullParameter(behaviourPlugin, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(behaviourName, "behaviourName");
        FeatureIssue calculateIssue = FeatureIssue.Companion.calculateIssue(behaviourPlugin.getRequiredPermissions(), context);
        if (calculateIssue == FeatureIssue.None) {
            return false;
        }
        if (calculateIssue == FeatureIssue.LocationDisabled) {
            behaviourName = context.getString(R.string.notification_location_off);
        }
        Intrinsics.checkNotNull(behaviourName);
        NotificationUtils.showPermissionNotification(behaviourName, behaviourPlugin.getRequiredPermissions(), calculateIssue);
        return true;
    }
}
