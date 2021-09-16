package com.example.newsapplication.ui.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020!H\u0016J\u001a\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020!H\u0002J\b\u0010+\u001a\u00020!H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006,"}, d2 = {"Lcom/example/newsapplication/ui/fragments/SavedNewsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "savedAdapter", "Lcom/example/newsapplication/adapters/SavedAdapter;", "getSavedAdapter", "()Lcom/example/newsapplication/adapters/SavedAdapter;", "setSavedAdapter", "(Lcom/example/newsapplication/adapters/SavedAdapter;)V", "savedarticleList", "Ljava/util/ArrayList;", "Lcom/example/newsapplication/model/ArticleItem;", "Lkotlin/collections/ArrayList;", "getSavedarticleList", "()Ljava/util/ArrayList;", "setSavedarticleList", "(Ljava/util/ArrayList;)V", "tempsavedList", "getTempsavedList", "setTempsavedList", "viewModel", "Lcom/example/newsapplication/ui/NewsViewModel;", "getViewModel", "()Lcom/example/newsapplication/ui/NewsViewModel;", "setViewModel", "(Lcom/example/newsapplication/ui/NewsViewModel;)V", "displaysearch", "", "textsearch", "", "onStart", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupRecycleView", "setupsearchba", "app_debug"})
public final class SavedNewsFragment extends androidx.fragment.app.Fragment {
    public com.example.newsapplication.ui.NewsViewModel viewModel;
    public com.example.newsapplication.adapters.SavedAdapter savedAdapter;
    public java.util.ArrayList<com.example.newsapplication.model.ArticleItem> savedarticleList;
    public java.util.ArrayList<com.example.newsapplication.model.ArticleItem> tempsavedList;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job job;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newsapplication.ui.NewsViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull()
    com.example.newsapplication.ui.NewsViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newsapplication.adapters.SavedAdapter getSavedAdapter() {
        return null;
    }
    
    public final void setSavedAdapter(@org.jetbrains.annotations.NotNull()
    com.example.newsapplication.adapters.SavedAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.newsapplication.model.ArticleItem> getSavedarticleList() {
        return null;
    }
    
    public final void setSavedarticleList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.newsapplication.model.ArticleItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.newsapplication.model.ArticleItem> getTempsavedList() {
        return null;
    }
    
    public final void setTempsavedList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.newsapplication.model.ArticleItem> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.coroutines.Job getJob() {
        return null;
    }
    
    public final void setJob(@org.jetbrains.annotations.Nullable()
    kotlinx.coroutines.Job p0) {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupsearchba() {
    }
    
    private final void displaysearch(java.lang.String textsearch) {
    }
    
    private final void setupRecycleView() {
    }
    
    public SavedNewsFragment() {
        super();
    }
}