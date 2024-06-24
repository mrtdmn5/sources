package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Window;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewPropertyAnimatorCompat;

/* loaded from: classes.dex */
public interface DecorToolbar {
    boolean canShowOverflowMenu();

    void collapseActionView();

    void dismissPopupMenus();

    Context getContext();

    int getDisplayOptions();

    void getNavigationMode();

    CharSequence getTitle();

    boolean hasExpandedActionView();

    boolean hideOverflowMenu();

    void initIndeterminateProgress();

    void initProgress();

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    void setCollapsible(boolean z);

    void setDisplayOptions(int r1);

    void setEmbeddedTabView();

    void setHomeButtonEnabled();

    void setIcon(int r1);

    void setIcon(Drawable drawable);

    void setLogo(int r1);

    void setMenu(MenuBuilder menuBuilder, AppCompatDelegateImpl.ActionMenuPresenterCallback actionMenuPresenterCallback);

    void setMenuPrepared();

    void setNavigationIcon(Drawable drawable);

    void setVisibility(int r1);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    ViewPropertyAnimatorCompat setupAnimatorToVisibility(int r1, long j);

    boolean showOverflowMenu();
}
