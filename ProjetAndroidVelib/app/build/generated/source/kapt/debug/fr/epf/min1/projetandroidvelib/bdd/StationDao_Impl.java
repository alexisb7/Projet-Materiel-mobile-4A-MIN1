package fr.epf.min1.projetandroidvelib.bdd;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class StationDao_Impl implements StationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<StationEntity> __insertionAdapterOfStationEntity;

  public StationDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStationEntity = new EntityInsertionAdapter<StationEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `StationEntity` (`id`,`name`,`operationnel`,`capacity`,`nb_bike_availabale`,`nb_dock_availabale`,`mechanical`,`eBike`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, StationEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getOp() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOp());
        }
        stmt.bindLong(4, value.getCapacity());
        stmt.bindLong(5, value.getNbBikeAvailable());
        stmt.bindLong(6, value.getNbDockAvailable());
        stmt.bindLong(7, value.getMechanical());
        stmt.bindLong(8, value.getEBike());
      }
    };
  }

  @Override
  public Object insert(final StationEntity[] stations,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfStationEntity.insert(stations);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAll(final Continuation<? super List<StationEntity>> continuation) {
    final String _sql = "SELECT * FROM stationEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<StationEntity>>() {
      @Override
      public List<StationEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfOp = CursorUtil.getColumnIndexOrThrow(_cursor, "operationnel");
          final int _cursorIndexOfCapacity = CursorUtil.getColumnIndexOrThrow(_cursor, "capacity");
          final int _cursorIndexOfNbBikeAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "nb_bike_availabale");
          final int _cursorIndexOfNbDockAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "nb_dock_availabale");
          final int _cursorIndexOfMechanical = CursorUtil.getColumnIndexOrThrow(_cursor, "mechanical");
          final int _cursorIndexOfEBike = CursorUtil.getColumnIndexOrThrow(_cursor, "eBike");
          final List<StationEntity> _result = new ArrayList<StationEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final StationEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpOp;
            if (_cursor.isNull(_cursorIndexOfOp)) {
              _tmpOp = null;
            } else {
              _tmpOp = _cursor.getString(_cursorIndexOfOp);
            }
            final int _tmpCapacity;
            _tmpCapacity = _cursor.getInt(_cursorIndexOfCapacity);
            final int _tmpNbBikeAvailable;
            _tmpNbBikeAvailable = _cursor.getInt(_cursorIndexOfNbBikeAvailable);
            final int _tmpNbDockAvailable;
            _tmpNbDockAvailable = _cursor.getInt(_cursorIndexOfNbDockAvailable);
            final int _tmpMechanical;
            _tmpMechanical = _cursor.getInt(_cursorIndexOfMechanical);
            final int _tmpEBike;
            _tmpEBike = _cursor.getInt(_cursorIndexOfEBike);
            _item = new StationEntity(_tmpId,_tmpName,_tmpOp,_tmpCapacity,_tmpNbBikeAvailable,_tmpNbDockAvailable,_tmpMechanical,_tmpEBike);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
