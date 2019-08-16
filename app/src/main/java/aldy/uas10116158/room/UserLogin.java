/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 14/08/19 14:30
 */

/*
 * Created by Aldy Ferdian Adam (10116158 - IF4) on 14/08/19 06:45
 */

package aldy.uas10116158.room;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_login")
public class UserLogin {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
