package com.example.newsapplication.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020#H\u0016J\u001a\u0010&\u001a\u00020#2\u0006\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020#H\u0002J\b\u0010-\u001a\u00020#H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006."}, d2 = {"Lcom/example/newsapplication/ui/fragments/BreakingNewsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isLastPage", "", "()Z", "setLastPage", "(Z)V", "isLoading", "setLoading", "isScrolling", "setScrolling", "newsAdapter", "Lcom/example/newsapplication/adapters/NewsAdapter;", "getNewsAdapter", "()Lcom/example/newsapplication/adapters/NewsAdapter;", "setNewsAdapter", "(Lcom/example/newsapplication/adapters/NewsAdapter;)V", "scrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "getScrollListener", "()Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "setScrollListener", "(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V", "viewModel", "Lcom/example/newsapplication/ui/NewsViewModel;", "getViewModel", "()Lcom/example/newsapplication/ui/NewsViewModel;", "setViewModel", "(Lcom/example/newsapplication/ui/NewsViewModel;)V", "hideShimmer", "", "hidemainprogressbar", "onStart", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupRecycleView", "showShimmer", "showmainprogressbar", "app_debug"})
public final class BreakingNewsFragment extends androidx.fragment.app.Fragment {
    public com.example.newsapplication.ui.NewsViewModel viewModel;
    public com.example.newsapplication.adapters.NewsAdapter newsAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String TAG = "BreakingNewsFragment";
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private boolean isScrolling = false;
    @org.jetbrains.annotations.NotNull()
    private androidx.recyclerview.widget.RecyclerView.OnScrollListener scrollListener;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newsapplication.ui.NewsViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull()
    com.example.newsapplication.ui.NewsViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newsapplication.adapters.NewsAdapter getNewsAdapter() {
        return null;
    }
    
    public final void setNewsAdapter(@org.jetbrains.annotations.NotNull()
    com.example.newsapplication.adapters.NewsAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public final void setLoading(boolean p0) {
    }
    
    public final boolean isLastPage() {
        return false;
    }
    
    public final void setLastPage(boolean p0) {
    }
    
    public final boolean isScrolling() {
        return false;
    }
    
    public final void setScrolling(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView.OnScrollListener getScrollListener() {
        return null;
    }
    
    public final void setScrollListener(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.OnScrollListener p0) {
    }
    
    private final void hidemainprogressbar() {
    }
    
    private final void showmainprogressbar() {
    }
    
    private final void setupRecycleView() {
    }
    
    private final void hideShimmer() {
    }
    
    private final void showShimmer() {
    }
    
    public BreakingNewsFragment() {
        super();
    }
}