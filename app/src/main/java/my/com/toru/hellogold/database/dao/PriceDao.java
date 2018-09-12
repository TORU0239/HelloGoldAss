package my.com.toru.hellogold.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import my.com.toru.hellogold.model.response.Data;

@Dao
public interface PriceDao {
    @Query("SELECT * FROM priceData")
    List<Data> getAll();

    @Query("SELECT COUNT(*) from priceData")
    int countAllSavedData();

    @Insert
    void insertEachData(Data data);

    @Insert
    void insertAll(Data... datas);

    @Delete
    void delete(Data data);

}