package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.CustomToolbar;
import com.animaconnected.secondo.widget.chart.ChartView;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentGenericWorkoutMetricDetailBinding implements ViewBinding {
    public final CardView cardEmptyState;
    public final CardView cardLastSynced;
    public final ChartView chartProgressBar;
    public final ChartView chartViewDetail;
    public final ChartView chartViewHistory;
    public final ChartView chartViewToday;
    public final RelativeLayout containerDetail;
    public final RelativeLayout containerHistory;
    public final RelativeLayout containerToday;
    public final RelativeLayout containerTodayChartInfo;
    public final CustomToolbar customToolbar;
    private final FrameLayout rootView;
    public final TextView tvAboutDesc;
    public final TextView tvAboutTitle;
    public final TextView tvChartDetailTitle;
    public final TextView tvChartHistoryTitle;
    public final TextView tvChartTodaySubheading;
    public final TextView tvChartTodayTitle;
    public final TextView tvEmptyStateDescription;
    public final TextView tvEmptyStateTitle;
    public final TextView tvFullHistory;
    public final TextView tvFullHistoryDetail;
    public final TextView tvLastSynced;
    public final TextView tvMetricName;
    public final TextView tvSecondAboutDesc;
    public final TextView tvSecondAboutTitle;
    public final View viewAnimContainer;

    private FragmentGenericWorkoutMetricDetailBinding(FrameLayout frameLayout, CardView cardView, CardView cardView2, ChartView chartView, ChartView chartView2, ChartView chartView3, ChartView chartView4, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, CustomToolbar customToolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, View view) {
        this.rootView = frameLayout;
        this.cardEmptyState = cardView;
        this.cardLastSynced = cardView2;
        this.chartProgressBar = chartView;
        this.chartViewDetail = chartView2;
        this.chartViewHistory = chartView3;
        this.chartViewToday = chartView4;
        this.containerDetail = relativeLayout;
        this.containerHistory = relativeLayout2;
        this.containerToday = relativeLayout3;
        this.containerTodayChartInfo = relativeLayout4;
        this.customToolbar = customToolbar;
        this.tvAboutDesc = textView;
        this.tvAboutTitle = textView2;
        this.tvChartDetailTitle = textView3;
        this.tvChartHistoryTitle = textView4;
        this.tvChartTodaySubheading = textView5;
        this.tvChartTodayTitle = textView6;
        this.tvEmptyStateDescription = textView7;
        this.tvEmptyStateTitle = textView8;
        this.tvFullHistory = textView9;
        this.tvFullHistoryDetail = textView10;
        this.tvLastSynced = textView11;
        this.tvMetricName = textView12;
        this.tvSecondAboutDesc = textView13;
        this.tvSecondAboutTitle = textView14;
        this.viewAnimContainer = view;
    }

    public static FragmentGenericWorkoutMetricDetailBinding bind(View view) {
        int r1 = R.id.card_empty_state;
        CardView cardView = (CardView) ViewBindings.findChildViewById(R.id.card_empty_state, view);
        if (cardView != null) {
            r1 = R.id.card_last_synced;
            CardView cardView2 = (CardView) ViewBindings.findChildViewById(R.id.card_last_synced, view);
            if (cardView2 != null) {
                r1 = R.id.chart_progress_bar;
                ChartView chartView = (ChartView) ViewBindings.findChildViewById(R.id.chart_progress_bar, view);
                if (chartView != null) {
                    r1 = R.id.chart_view_detail;
                    ChartView chartView2 = (ChartView) ViewBindings.findChildViewById(R.id.chart_view_detail, view);
                    if (chartView2 != null) {
                        r1 = R.id.chart_view_history;
                        ChartView chartView3 = (ChartView) ViewBindings.findChildViewById(R.id.chart_view_history, view);
                        if (chartView3 != null) {
                            r1 = R.id.chart_view_today;
                            ChartView chartView4 = (ChartView) ViewBindings.findChildViewById(R.id.chart_view_today, view);
                            if (chartView4 != null) {
                                r1 = R.id.container_detail;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.container_detail, view);
                                if (relativeLayout != null) {
                                    r1 = R.id.container_history;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(R.id.container_history, view);
                                    if (relativeLayout2 != null) {
                                        r1 = R.id.container_today;
                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(R.id.container_today, view);
                                        if (relativeLayout3 != null) {
                                            r1 = R.id.container_today_chart_info;
                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(R.id.container_today_chart_info, view);
                                            if (relativeLayout4 != null) {
                                                r1 = R.id.custom_toolbar;
                                                CustomToolbar customToolbar = (CustomToolbar) ViewBindings.findChildViewById(R.id.custom_toolbar, view);
                                                if (customToolbar != null) {
                                                    r1 = R.id.tv_about_desc;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(R.id.tv_about_desc, view);
                                                    if (textView != null) {
                                                        r1 = R.id.tv_about_title;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.tv_about_title, view);
                                                        if (textView2 != null) {
                                                            r1 = R.id.tv_chart_detail_title;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(R.id.tv_chart_detail_title, view);
                                                            if (textView3 != null) {
                                                                r1 = R.id.tv_chart_history_title;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(R.id.tv_chart_history_title, view);
                                                                if (textView4 != null) {
                                                                    r1 = R.id.tv_chart_today_subheading;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(R.id.tv_chart_today_subheading, view);
                                                                    if (textView5 != null) {
                                                                        r1 = R.id.tv_chart_today_title;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(R.id.tv_chart_today_title, view);
                                                                        if (textView6 != null) {
                                                                            r1 = R.id.tv_empty_state_description;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(R.id.tv_empty_state_description, view);
                                                                            if (textView7 != null) {
                                                                                r1 = R.id.tv_empty_state_title;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(R.id.tv_empty_state_title, view);
                                                                                if (textView8 != null) {
                                                                                    r1 = R.id.tv_full_history;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(R.id.tv_full_history, view);
                                                                                    if (textView9 != null) {
                                                                                        r1 = R.id.tv_full_history_detail;
                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(R.id.tv_full_history_detail, view);
                                                                                        if (textView10 != null) {
                                                                                            r1 = R.id.tv_last_synced;
                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(R.id.tv_last_synced, view);
                                                                                            if (textView11 != null) {
                                                                                                r1 = R.id.tv_metric_name;
                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(R.id.tv_metric_name, view);
                                                                                                if (textView12 != null) {
                                                                                                    r1 = R.id.tv_second_about_desc;
                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(R.id.tv_second_about_desc, view);
                                                                                                    if (textView13 != null) {
                                                                                                        r1 = R.id.tv_second_about_title;
                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(R.id.tv_second_about_title, view);
                                                                                                        if (textView14 != null) {
                                                                                                            r1 = R.id.view_anim_container;
                                                                                                            View findChildViewById = ViewBindings.findChildViewById(R.id.view_anim_container, view);
                                                                                                            if (findChildViewById != null) {
                                                                                                                return new FragmentGenericWorkoutMetricDetailBinding((FrameLayout) view, cardView, cardView2, chartView, chartView2, chartView3, chartView4, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, customToolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, findChildViewById);
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r1)));
    }

    public static FragmentGenericWorkoutMetricDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentGenericWorkoutMetricDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_generic_workout_metric_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
