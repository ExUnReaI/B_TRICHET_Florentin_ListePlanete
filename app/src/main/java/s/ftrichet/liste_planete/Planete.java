package s.ftrichet.liste_planete;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Planete extends AppCompatActivity {

    //Déclarer un objet ListView dans la classe MainActivity
    private ListView MaListe ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_planete);

            ArrayList<Androidversion> androidList = new ArrayList<Androidversion>();
            initList(androidList);
            androidAdapter adapter = new androidAdapter(this,R.layout.items,androidList);
            final ListView list = (ListView) findViewById(R.id.maliste);
            list.setAdapter(adapter);
            //MyList est le layout principal ; list_layout est le layout personnalisé (soit la structure de chaque ligne). C’est
            //ainsi que les éléments sont liéés.
            //Gestion du clic sur élément de la liste
            //Classe imbriquée ; pas d'implémentation de l'interface
            list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                    Androidversion selectedItem = (Androidversion)adapter.getItemAtPosition(position);
                    Log.v("ListPersonnalisée", "Element selectionné : " + selectedItem.getVersionName());
                    //Vous pouvez faire un TOAST
                }
            });
        }


    private void initList(ArrayList<Androidversion> androidList){

        Resources res = getResources();
        String[]MesValeurs = res.getStringArray(R.array.montableau);
        String[]MesDesc = res.getStringArray(R.array.montableaudesc);
        for (int i=0; i<MesValeurs.length;i++){
            Androidversion version= new Androidversion();
            version.setVersionName(MesValeurs[i]);
            version.setVersionNumber(MesDesc[i]);
            androidList.add(version);
        }



    }

}


