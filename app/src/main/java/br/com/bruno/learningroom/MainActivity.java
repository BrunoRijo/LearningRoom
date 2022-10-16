package br.com.bruno.learningroom;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonDataBase db = Room.databaseBuilder(
                  getApplicationContext()
                , PersonDataBase.class
                , "person-database").allowMainThreadQueries().build();
        /*A função allowMainThreadQueries não deve ser colocada na activity principal, coloquei aqui
        por se tratar de uma prática para estudo*/

        Person Suzana = new Person("Suzana", "0000000000000");
        Person Lucas = new Person("Lucas", "0000000000000");

        //Enviando para o banco
        db.personDao().insertAll(Suzana, Lucas);

        //Recebendo do banco
        List<Person> listaPessoas = db.personDao().getAllPersons();

        //Visualização simples dos dados armazenados.
        for(Person person : listaPessoas){
            Log.d("pessoas", "Nome: " + person.name + " CPF:" + person.cpf);
        }
    }
}
