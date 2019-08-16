/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 15/08/19 18:15
 */

package aldy.uas10116158.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface TemanDao {
    @Insert
    Long insert(Teman t);

    @Query("SELECT * FROM `Teman`")
    List<Teman> getAllUsers();

    @Query("SELECT * FROM `Teman` WHERE `nim` =:nim")
    Teman getTeman(String nim);

    @Update
    void update(Teman t);

    @Delete
    void delete(Teman t);
}
