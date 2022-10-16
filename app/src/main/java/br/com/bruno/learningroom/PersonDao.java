package br.com.bruno.learningroom;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Insert
    void insertAll(Person... persons);

    @Query("SELECT * FROM person")
    List<Person> getAllPersons();

    /*Esse trecho manipula as operações no banco de dados que serão feitas com os dados
    contidos nas entidades declaradas nas classes*/

}
