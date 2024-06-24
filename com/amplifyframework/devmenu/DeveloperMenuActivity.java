package com.amplifyframework.devmenu;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.TaskStackBuilder;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.ToolbarOnDestinationChangedListener;
import com.amplifyframework.core.R;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class DeveloperMenuActivity extends FragmentActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        View findViewById;
        super.onCreate(bundle);
        setContentView(R.layout.activity_dev_menu);
        findViewById(R.id.dev_layout).setFocusable(true);
        int r6 = R.id.nav_host_fragment;
        int r1 = ActivityCompat.$r8$clinit;
        if (Build.VERSION.SDK_INT >= 28) {
            findViewById = (View) ActivityCompat.Api28Impl.requireViewById(this, r6);
        } else {
            findViewById = findViewById(r6);
            if (findViewById == null) {
                throw new IllegalArgumentException("ID does not reference a View inside this Activity");
            }
        }
        final NavController findViewNavController = Navigation.findViewNavController(findViewById);
        if (findViewNavController != null) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            NavDestination navDestination = findViewNavController.mGraph;
            if (navDestination != null) {
                HashSet hashSet = new HashSet();
                while (navDestination instanceof NavGraph) {
                    NavGraph navGraph = (NavGraph) navDestination;
                    navDestination = navGraph.findNode(navGraph.mStartDestId, true);
                }
                hashSet.add(Integer.valueOf(navDestination.mId));
                final AppBarConfiguration appBarConfiguration = new AppBarConfiguration(hashSet);
                ToolbarOnDestinationChangedListener toolbarOnDestinationChangedListener = new ToolbarOnDestinationChangedListener(toolbar, appBarConfiguration);
                ArrayDeque arrayDeque = findViewNavController.mBackStack;
                if (!arrayDeque.isEmpty()) {
                    NavBackStackEntry navBackStackEntry = (NavBackStackEntry) arrayDeque.peekLast();
                    toolbarOnDestinationChangedListener.onDestinationChanged(findViewNavController, navBackStackEntry.mDestination, navBackStackEntry.mArgs);
                }
                findViewNavController.mOnDestinationChangedListeners.add(toolbarOnDestinationChangedListener);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.navigation.ui.NavigationUI$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Intent launchIntentForPackage;
                        appBarConfiguration.getClass();
                        NavController navController = NavController.this;
                        navController.getCurrentDestination();
                        if (navController.getDestinationCountOnBackStack() == 1) {
                            NavDestination currentDestination = navController.getCurrentDestination();
                            int r12 = currentDestination.mId;
                            for (NavGraph navGraph2 = currentDestination.mParent; navGraph2 != null; navGraph2 = navGraph2.mParent) {
                                if (navGraph2.mStartDestId != r12) {
                                    Bundle bundle2 = new Bundle();
                                    Activity activity = navController.mActivity;
                                    if (activity != null && activity.getIntent() != null && activity.getIntent().getData() != null) {
                                        bundle2.putParcelable("android-support-nav:controller:deepLinkIntent", activity.getIntent());
                                        NavDestination.DeepLinkMatch matchDeepLink = navController.mGraph.matchDeepLink(new NavDeepLinkRequest(activity.getIntent()));
                                        if (matchDeepLink != null) {
                                            bundle2.putAll(matchDeepLink.mDestination.addInDefaultArgs(matchDeepLink.mMatchingArgs));
                                        }
                                    }
                                    Context context = navController.mContext;
                                    if (context instanceof Activity) {
                                        launchIntentForPackage = new Intent(context, context.getClass());
                                    } else {
                                        launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                                        if (launchIntentForPackage == null) {
                                            launchIntentForPackage = new Intent();
                                        }
                                    }
                                    launchIntentForPackage.addFlags(268468224);
                                    NavGraph navGraph3 = navController.mGraph;
                                    if (navGraph3 != null) {
                                        int r0 = navGraph2.mId;
                                        ArrayDeque arrayDeque2 = new ArrayDeque();
                                        arrayDeque2.add(navGraph3);
                                        NavDestination navDestination2 = null;
                                        while (!arrayDeque2.isEmpty() && navDestination2 == null) {
                                            NavDestination navDestination3 = (NavDestination) arrayDeque2.poll();
                                            if (navDestination3.mId == r0) {
                                                navDestination2 = navDestination3;
                                            } else if (navDestination3 instanceof NavGraph) {
                                                NavGraph.AnonymousClass1 anonymousClass1 = new NavGraph.AnonymousClass1();
                                                while (anonymousClass1.hasNext()) {
                                                    arrayDeque2.add((NavDestination) anonymousClass1.next());
                                                }
                                            }
                                        }
                                        if (navDestination2 != null) {
                                            launchIntentForPackage.putExtra("android-support-nav:controller:deepLinkIds", navDestination2.buildDeepLinkIds());
                                            launchIntentForPackage.putExtra("android-support-nav:controller:deepLinkExtras", bundle2);
                                            if (launchIntentForPackage.getIntArrayExtra("android-support-nav:controller:deepLinkIds") != null) {
                                                TaskStackBuilder taskStackBuilder = new TaskStackBuilder(context);
                                                Intent intent = new Intent(launchIntentForPackage);
                                                ComponentName component = intent.getComponent();
                                                if (component == null) {
                                                    component = intent.resolveActivity(taskStackBuilder.mSourceContext.getPackageManager());
                                                }
                                                if (component != null) {
                                                    taskStackBuilder.addParentStack(component);
                                                }
                                                ArrayList<Intent> arrayList = taskStackBuilder.mIntents;
                                                arrayList.add(intent);
                                                for (int r02 = 0; r02 < arrayList.size(); r02++) {
                                                    arrayList.get(r02).putExtra("android-support-nav:controller:deepLinkIntent", launchIntentForPackage);
                                                }
                                                taskStackBuilder.startActivities();
                                                if (activity != null) {
                                                    activity.finish();
                                                    return;
                                                }
                                                return;
                                            }
                                            throw new IllegalStateException("You must call setDestination() before constructing the deep link");
                                        }
                                        throw new IllegalArgumentException("Navigation destination " + NavDestination.getDisplayName(context, r0) + " cannot be found in the navigation graph " + navGraph3);
                                    }
                                    throw new IllegalStateException("You must call setGraph() before calling getGraph()");
                                }
                                r12 = navGraph2.mId;
                            }
                            return;
                        }
                        navController.popBackStack();
                    }
                });
                DeveloperMenu.singletonInstance(getApplicationContext()).setOnHideAction(new DeveloperMenuActivity$$ExternalSyntheticLambda0(this));
                return;
            }
            throw new IllegalStateException("You must call setGraph() before calling getGraph()");
        }
        throw new IllegalStateException("Activity " + this + " does not have a NavController set on " + r6);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        DeveloperMenu.singletonInstance(getApplicationContext()).setVisible(true);
        super.onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        DeveloperMenu.singletonInstance(getApplicationContext()).setVisible(false);
        super.onStop();
    }
}
