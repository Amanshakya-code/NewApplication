package com.example.newsapplication.db;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.newsapplication.model.ArticleItem;
import com.example.newsapplication.model.Source;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ArticleDao_Impl implements ArticleDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ArticleItem> __insertionAdapterOfArticleItem;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<ArticleItem> __deletionAdapterOfArticleItem;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllArticle;

  public ArticleDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfArticleItem = new EntityInsertionAdapter<ArticleItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `articles` (`id`,`publishedAt`,`author`,`urlToImage`,`description`,`source`,`title`,`url`,`content`,`isExpanded`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ArticleItem value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getPublishedAt() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPublishedAt());
        }
        if (value.getAuthor() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAuthor());
        }
        if (value.getUrlToImage() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUrlToImage());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDescription());
        }
        final String _tmp;
        _tmp = __converters.fromSource(value.getSource());
        if (_tmp == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp);
        }
        if (value.getTitle() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTitle());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUrl());
        }
        if (value.getContent() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getContent());
        }
        final int _tmp_1;
        _tmp_1 = value.isExpanded() ? 1 : 0;
        stmt.bindLong(10, _tmp_1);
      }
    };
    this.__deletionAdapterOfArticleItem = new EntityDeletionOrUpdateAdapter<ArticleItem>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `articles` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ArticleItem value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAllArticle = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM articles";
        return _query;
      }
    };
  }

  @Override
  public Object upsert(final ArticleItem article, final Continuation<? super Long> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfArticleItem.insertAndReturnId(article);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteArticle(final ArticleItem article, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfArticleItem.handle(article);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteAllArticle(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllArticle.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllArticle.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public LiveData<List<ArticleItem>> getAllArticles() {
    final String _sql = "SELECT * FROM articles";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"articles"}, false, new Callable<List<ArticleItem>>() {
      @Override
      public List<ArticleItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPublishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "publishedAt");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfUrlToImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlToImage");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfIsExpanded = CursorUtil.getColumnIndexOrThrow(_cursor, "isExpanded");
          final List<ArticleItem> _result = new ArrayList<ArticleItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ArticleItem _item;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final String _tmpPublishedAt;
            _tmpPublishedAt = _cursor.getString(_cursorIndexOfPublishedAt);
            final String _tmpAuthor;
            _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            final String _tmpUrlToImage;
            _tmpUrlToImage = _cursor.getString(_cursorIndexOfUrlToImage);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final Source _tmpSource;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfSource);
            _tmpSource = __converters.toSource(_tmp);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpUrl;
            _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            final String _tmpContent;
            _tmpContent = _cursor.getString(_cursorIndexOfContent);
            final boolean _tmpIsExpanded;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsExpanded);
            _tmpIsExpanded = _tmp_1 != 0;
            _item = new ArticleItem(_tmpId,_tmpPublishedAt,_tmpAuthor,_tmpUrlToImage,_tmpDescription,_tmpSource,_tmpTitle,_tmpUrl,_tmpContent,_tmpIsExpanded);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
