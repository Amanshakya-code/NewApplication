package com.example.newsapplication.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010%\u001a\u00020&J\u000e\u0010\'\u001a\u00020&2\u0006\u0010(\u001a\u00020)J\u000e\u0010\u000b\u001a\u00020&2\u0006\u0010*\u001a\u00020+J\u0016\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020+J\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0100J\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\n04H\u0002J\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\n04H\u0002J\b\u00106\u001a\u000207H\u0002J\u0019\u00108\u001a\u0002092\u0006\u0010*\u001a\u00020+H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010:J\u0019\u0010;\u001a\u0002092\u0006\u0010<\u001a\u00020+H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010:J\u000e\u0010=\u001a\u00020&2\u0006\u0010(\u001a\u00020)J\u000e\u0010\u001c\u001a\u00020&2\u0006\u0010<\u001a\u00020+R&\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR&\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001a\u0010\u001f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R\u001c\u0010\"\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0017\"\u0004\b$\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006>"}, d2 = {"Lcom/example/newsapplication/ui/NewsViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "newsRepository", "Lcom/example/newsapplication/repository/NewsRepository;", "(Landroid/app/Application;Lcom/example/newsapplication/repository/NewsRepository;)V", "breakingNews", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/newsapplication/util/Resource;", "Lcom/example/newsapplication/model/NewsResponse;", "getBreakingNews", "()Landroidx/lifecycle/MutableLiveData;", "setBreakingNews", "(Landroidx/lifecycle/MutableLiveData;)V", "breakingNewsPage", "", "getBreakingNewsPage", "()I", "setBreakingNewsPage", "(I)V", "breakingNewsResponse", "getBreakingNewsResponse", "()Lcom/example/newsapplication/model/NewsResponse;", "setBreakingNewsResponse", "(Lcom/example/newsapplication/model/NewsResponse;)V", "getNewsRepository", "()Lcom/example/newsapplication/repository/NewsRepository;", "searchNews", "getSearchNews", "setSearchNews", "searchNewsPage", "getSearchNewsPage", "setSearchNewsPage", "searchNewsResponse", "getSearchNewsResponse", "setSearchNewsResponse", "deleteAllArticle", "Lkotlinx/coroutines/Job;", "deleteArticle", "article", "Lcom/example/newsapplication/model/ArticleItem;", "countryCode", "", "getCategoryNews", "CountryCode", "category", "getsavedNews", "Landroidx/lifecycle/LiveData;", "", "handleBreakingNewsResponse", "response", "Lretrofit2/Response;", "handleSearchNewsResponse", "hasInternetConnection", "", "safeBreakingnewsCall", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeSearchNewsCall", "searchQuery", "saveArticle", "app_debug"})
public final class NewsViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.example.newsapplication.util.Resource<com.example.newsapplication.model.NewsResponse>> breakingNews;
    private int breakingNewsPage = 1;
    @org.jetbrains.annotations.Nullable()
    private com.example.newsapplication.model.NewsResponse breakingNewsResponse;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.example.newsapplication.util.Resource<com.example.newsapplication.model.NewsResponse>> searchNews;
    private int searchNewsPage = 1;
    @org.jetbrains.annotations.Nullable()
    private com.example.newsapplication.model.NewsResponse searchNewsResponse;
    @org.jetbrains.annotations.NotNull()
    private final com.example.newsapplication.repository.NewsRepository newsRepository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.newsapplication.util.Resource<com.example.newsapplication.model.NewsResponse>> getBreakingNews() {
        return null;
    }
    
    public final void setBreakingNews(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.example.newsapplication.util.Resource<com.example.newsapplication.model.NewsResponse>> p0) {
    }
    
    public final int getBreakingNewsPage() {
        return 0;
    }
    
    public final void setBreakingNewsPage(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.newsapplication.model.NewsResponse getBreakingNewsResponse() {
        return null;
    }
    
    public final void setBreakingNewsResponse(@org.jetbrains.annotations.Nullable()
    com.example.newsapplication.model.NewsResponse p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.newsapplication.util.Resource<com.example.newsapplication.model.NewsResponse>> getSearchNews() {
        return null;
    }
    
    public final void setSearchNews(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.example.newsapplication.util.Resource<com.example.newsapplication.model.NewsResponse>> p0) {
    }
    
    public final int getSearchNewsPage() {
        return 0;
    }
    
    public final void setSearchNewsPage(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.newsapplication.model.NewsResponse getSearchNewsResponse() {
        return null;
    }
    
    public final void setSearchNewsResponse(@org.jetbrains.annotations.Nullable()
    com.example.newsapplication.model.NewsResponse p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getBreakingNews(@org.jetbrains.annotations.NotNull()
    java.lang.String countryCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job searchNews(@org.jetbrains.annotations.NotNull()
    java.lang.String searchQuery) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getCategoryNews(@org.jetbrains.annotations.NotNull()
    java.lang.String CountryCode, @org.jetbrains.annotations.NotNull()
    java.lang.String category) {
        return null;
    }
    
    private final com.example.newsapplication.util.Resource<com.example.newsapplication.model.NewsResponse> handleBreakingNewsResponse(retrofit2.Response<com.example.newsapplication.model.NewsResponse> response) {
        return null;
    }
    
    private final com.example.newsapplication.util.Resource<com.example.newsapplication.model.NewsResponse> handleSearchNewsResponse(retrofit2.Response<com.example.newsapplication.model.NewsResponse> response) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job saveArticle(@org.jetbrains.annotations.NotNull()
    com.example.newsapplication.model.ArticleItem article) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.newsapplication.model.ArticleItem>> getsavedNews() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteAllArticle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteArticle(@org.jetbrains.annotations.NotNull()
    com.example.newsapplication.model.ArticleItem article) {
        return null;
    }
    
    private final boolean hasInternetConnection() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.newsapplication.repository.NewsRepository getNewsRepository() {
        return null;
    }
    
    public NewsViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app, @org.jetbrains.annotations.NotNull()
    com.example.newsapplication.repository.NewsRepository newsRepository) {
        super(null);
    }
}