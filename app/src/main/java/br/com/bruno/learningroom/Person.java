package br.com.bruno.learningroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Person {

    /* Ao utilizar as notações @Entity, @PrimaryKey e @ColumnInfo estamos informando ao banco de dados
    as tabelas que ele irá armazenar com os dados que queremos.*/

    @PrimaryKey(autoGenerate = true)
    public int person_id;

    @ColumnInfo(name = "Nome")
    public String name;

    @ColumnInfo(name = "CPF")
    public String cpf;

    public Person(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }
}
