package br.com.bruno.learningroom;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.btn_addPessoa);

        PersonViewModel personViewModel = ViewModelProviders.of(this).get(PersonViewModel.class);

        Person Suzana = new Person("Suzana", "0000000000000");
        Person Lucas = new Person("Lucas", "0000000000000");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personViewModel.insertPerson(Suzana);
            }
        });

        personViewModel.getAllPersons().observe(this, personList -> {
            Log.d("person", "" + personList.size());

            //Visualização simples dos dados armazenados.
            for(Person person : personList){
                Log.d("pessoas", "Nome: " + person.name + " CPF:" + person.cpf);
            }
        });
    }
}
