package lln.product.control.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import lln.product.control.db.entity.JellyEntity;

@Dao
public interface JellyDao {

    @Query("SELECT * FROM jelly")
    JellyEntity getJelly();

    @Query("SELECT COUNT(*) from jelly")
    int countJelly();

    @Query("SELECT * FROM jelly where name LIKE  :name")
    JellyEntity findByName(String name);

    @Insert
    void insertAll(JellyEntity... newJams);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(JellyEntity newJelly);

    @Delete
    void delete(JellyEntity removeJelly);

    @Query("DELETE FROM jelly")
    void deleteAll();

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(JellyEntity jelly);
}
