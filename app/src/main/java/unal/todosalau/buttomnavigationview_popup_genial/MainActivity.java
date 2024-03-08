package unal.todosalau.buttomnavigationview_popup_genial;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;

import android.annotation.SuppressLint;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar barra de herramientas
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //configurar titulo de la barra de herramientas
         TextView toolbarTitle = findViewById(R.id.toolbar_title);
         toolbarTitle.setText("Mi app genial");

         //configura boton de menu de la barra de herramientas
        ImageButton menuButton = findViewById(R.id.boton_bar_menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopUp(v);
            }//showpopup muestra un menu emergente
        });                                              //cuando se hace clic en el boton menu.

        //configuracion barra inferior
        BottomAppBar bottomAppBar = findViewById(R.id.bottom_appbar);
        setSupportActionBar(bottomAppBar);

        //configuracion navegacion en la barra inferio
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(),Toast.LENGTH_LONG).show();
                //logicapara manejar la seleccion de elementos en la barro inferio
                return true;
            }
        });
    }
        //creamos una instancia de popupMenu y la asociomos con la actividad MainActivity.This
        //y la vista (v) pasadas como parametros. luego , infla el menu definido en el archivo
        //popup_Menu.xml utilizando popupMenu.getMenuInflater().inflate().
        //acontinuacion se configura un OnMenuItemClicklisterner anonimo para manejar las acciones
        // de los elementos del menu emergente.Cuando se hace clic en un elemento, se muestra un
        // mensaje. Toas con el titulo del elemento seleccionado. finalmente el menu emergente se
        //muestra llamando a popupMenu.show().


         // *muestra un menu emergente al hacer clic en el boton del menu.
         //@param v la vista que ha sido clicliada
        protected void showPopUp(View v){
            PopupMenu popupMenu = new PopupMenu(MainActivity.this,v);
            popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
            //configurar acciones para los elementos del menu emergente
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    //logica para manejar las acciones de los elementos del menu emergente
                    Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
            //mostrar el menu emergente
            popupMenu.show();
        }

}