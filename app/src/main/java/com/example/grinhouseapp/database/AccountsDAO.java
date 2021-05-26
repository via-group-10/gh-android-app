package com.example.grinhouseapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.grinhouseapp.model.Account;

@Dao
public interface AccountsDAO {
    @Insert(onConflict = (OnConflictStrategy.REPLACE))
    void insert(Account account);

    @Query("SELECT * FROM account_table WHERE loginName=:username AND loginPassword=:password")
    LiveData<Account> getAccount(String username, String password);
}
