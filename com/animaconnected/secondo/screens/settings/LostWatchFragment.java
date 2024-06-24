package com.animaconnected.secondo.screens.settings;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.ThemeProviderBase;
import com.animaconnected.secondo.provider.lostwatch.LostWatchProvider;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.location.Spot;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.kronaby.watch.app.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.MagicApiIntrinsics;

/* loaded from: classes3.dex */
public class LostWatchFragment extends BaseFragment {
    private static final String BUNDLE_ADDRESS = "address";
    private static final float MIN_RADIUS_FOR_MAP = 100.0f;
    private static final long ONE_DAY_IN_MILLIS = 86400000;
    private String mAddress;
    private TextView mDateText;
    private boolean mFailedLocation;
    private Handler mHandler;
    private GoogleMap mMap;
    private View mMapContainer;
    private TextView mMapDescriptionFirst;
    private TextView mMapDescriptionSecond;
    private ProgressBar mProgressBar;
    private Spot mSpot;

    private void enableMyLocation() {
        boolean z;
        boolean z2 = false;
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            z = true;
        } else {
            z = false;
        }
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            z2 = true;
        }
        if (z && z2) {
            GoogleMap googleMap = this.mMap;
            googleMap.getClass();
            try {
                googleMap.zza.setMyLocationEnabled(true);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    private String formatTime(Date date, Locale locale, boolean z) {
        String bestDateTimePattern;
        if (DateFormat.is24HourFormat(getContext())) {
            if (z) {
                bestDateTimePattern = DateFormat.getBestDateTimePattern(locale, "EEEE Hm");
            } else {
                bestDateTimePattern = DateFormat.getBestDateTimePattern(locale, "Hm");
            }
        } else if (z) {
            bestDateTimePattern = DateFormat.getBestDateTimePattern(locale, "EEEE hma");
        } else {
            bestDateTimePattern = DateFormat.getBestDateTimePattern(locale, "hma");
        }
        return new SimpleDateFormat(bestDateTimePattern, locale).format(date);
    }

    private void initializeMap() {
        if (this.mMap == null) {
            ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map)).getMapAsync(new OnMapReadyCallback() { // from class: com.animaconnected.secondo.screens.settings.LostWatchFragment$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.maps.OnMapReadyCallback
                public final void onMapReady(GoogleMap googleMap) {
                    LostWatchFragment.this.lambda$initializeMap$1(googleMap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initializeMap$1(GoogleMap googleMap) {
        this.mMap = googleMap;
        showMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(Spot spot) {
        if (spot != null) {
            this.mSpot = spot;
        } else {
            this.mFailedLocation = true;
        }
        showMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMap$2(LatLng latLng, float f) {
        this.mMap.animateCamera(MagicApiIntrinsics.newLatLngZoom(latLng, f));
    }

    public static LostWatchFragment newInstance(String str) {
        LostWatchFragment lostWatchFragment = new LostWatchFragment();
        Bundle bundle = new Bundle();
        bundle.putString("address", str);
        lostWatchFragment.setArguments(bundle);
        return lostWatchFragment;
    }

    private void setLastLocationFormat(Spot spot) {
        String string;
        Locale translationCompatibleLocale = ProviderFactory.createConfigProvider().getTranslationCompatibleLocale();
        Calendar calendar = Calendar.getInstance(translationCompatibleLocale);
        Calendar calendar2 = Calendar.getInstance(translationCompatibleLocale);
        calendar2.setTimeInMillis(spot.timeStamp);
        Date time = calendar2.getTime();
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        long timeInMillis = calendar.getTimeInMillis() - calendar2.getTimeInMillis();
        if (timeInMillis < 0) {
            string = formatTime(time, translationCompatibleLocale, true);
        } else if (timeInMillis <= ONE_DAY_IN_MILLIS) {
            string = getString(R.string.timestamp_text_today);
        } else if (timeInMillis <= 172800000) {
            string = getString(R.string.timestamp_text_yesterday);
        } else if (timeInMillis <= 604800000) {
            string = formatTime(time, translationCompatibleLocale, true);
        } else {
            string = getString(R.string.timestamp_text_many_days_ago, ((int) Math.floor(timeInMillis / ONE_DAY_IN_MILLIS)) + "");
        }
        this.mDateText.setText(string);
    }

    private void showMap() {
        if (this.mMap != null && isAdded()) {
            if (this.mFailedLocation) {
                this.mProgressBar.setVisibility(8);
                this.mMap.moveCamera(MagicApiIntrinsics.newLatLngZoom(new LatLng(0.0d, 0.0d), 0.0f));
                this.mMapDescriptionFirst.setText(getContext().getString(R.string.lost_watch_description_no_location_text));
                this.mMapDescriptionSecond.setVisibility(8);
                this.mDateText.setText(getContext().getString(R.string.lost_watch_location_not_found));
                return;
            }
            if (this.mSpot != null) {
                this.mProgressBar.setVisibility(8);
                WatchProvider watch = ProviderFactory.getWatch();
                if (watch.isConnected() && this.mAddress.equals(watch.getAddress())) {
                    this.mMapDescriptionFirst.setText(getContext().getString(R.string.lost_watch_description_text_first_connected));
                    this.mMapDescriptionSecond.setText(getContext().getString(R.string.lost_watch_description_text_second_connected));
                    this.mDateText.setVisibility(8);
                } else {
                    this.mMapDescriptionFirst.setText(getContext().getString(R.string.lost_watch_description_text_first));
                    this.mMapDescriptionSecond.setText(getContext().getString(R.string.lost_watch_description_text_second));
                    setLastLocationFormat(this.mSpot);
                }
                this.mMapContainer.setAlpha(1.0f);
                enableMyLocation();
                Spot spot = this.mSpot;
                final LatLng latLng = new LatLng(spot.latitude, spot.longitude);
                float f = this.mSpot.accuracy;
                if (f <= MIN_RADIUS_FOR_MAP) {
                    f = 100.0f;
                }
                GoogleMap googleMap = this.mMap;
                CircleOptions circleOptions = new CircleOptions();
                circleOptions.zza = latLng;
                circleOptions.zzb = f;
                circleOptions.zzc = 15.0f;
                circleOptions.zzd = ThemeProviderBase.getColor(getContext(), R.attr.settingsLostWatchMapCircleOutlineColor);
                googleMap.addCircle(circleOptions);
                final float f2 = 15.0f - ((f - MIN_RADIUS_FOR_MAP) / 500.0f);
                this.mHandler.postDelayed(new Runnable() { // from class: com.animaconnected.secondo.screens.settings.LostWatchFragment$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        LostWatchFragment.this.lambda$showMap$2(latLng, f2);
                    }
                }, 1000L);
            }
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        return getString(R.string.feature_path_settings);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return TipsAndTricksConstants.LOST_WATCH_NAME;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_lost_watch, viewGroup, false);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mMapDescriptionFirst = (TextView) inflate.findViewById(R.id.lost_watch_map_description_1);
        this.mMapDescriptionSecond = (TextView) inflate.findViewById(R.id.lost_watch_map_description_2);
        this.mDateText = (TextView) inflate.findViewById(R.id.lost_watch_timestamp);
        this.mProgressBar = (ProgressBar) inflate.findViewById(R.id.map_progress_bar);
        View findViewById = inflate.findViewById(R.id.map_container_layout);
        this.mMapContainer = findViewById;
        findViewById.setAlpha(0.5f);
        this.mAddress = requireArguments().getString("address");
        ProviderFactory.getLostWatchProvider().getLastKnownSpot(this.mAddress, new LostWatchProvider.OnSpotFetchedListener() { // from class: com.animaconnected.secondo.screens.settings.LostWatchFragment$$ExternalSyntheticLambda0
            @Override // com.animaconnected.secondo.provider.lostwatch.LostWatchProvider.OnSpotFetchedListener
            public final void onSpotFetched(Spot spot) {
                LostWatchFragment.this.lambda$onCreateView$0(spot);
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        initializeMap();
    }
}
