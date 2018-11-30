package s.ftrichet.liste_planete;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class androidAdapter extends ArrayAdapter<Androidversion> {


    private final ArrayList<Androidversion> AndroidVersionList;
    private final Context context;
    private final Resources res;
    private final int viewRes;

    public androidAdapter(Context context, int textViewResourceId, ArrayList<Androidversion> versions){
        super(context,textViewResourceId,versions);
        this.AndroidVersionList = versions;
        this.context = context;
        this.res = context.getResources();
        this.viewRes = textViewResourceId;
    }

    static class ViewHolder {
        TextView title;
        TextView description;
        ImageView image;
    }

    @Override //Il faut implémenter getView ici
    public View getView(int position, View ConvertView, ViewGroup parent) {
        View view = ConvertView;
        ViewHolder holder;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false); //cf. jeu du pendu et explications effectuée en cours…
            holder = new ViewHolder();
            holder.title= (TextView) view.findViewById(R.id.nomplanete);
            holder.description = (TextView) view.findViewById(R.id.description);
            holder.image = (ImageView) view.findViewById(R.id.IMGPlanete);
            view.setTag(holder);
        } else {
            holder= (ViewHolder) view.getTag();
        }
        final Androidversion androidVersion = AndroidVersionList.get(position);
        if (androidVersion != null) {
            final String versionName = String.format("%s", androidVersion.getVersionName());//nom planete
            holder.title.setText(versionName);
            final String versionNumber = String.format("Dist moy: %s kms", androidVersion.getVersionNumber());//description
            holder.description.setText(versionNumber);
            switch (versionName){
                case "Jupiter" : holder.image.setBackgroundResource(R.drawable.jupiter);break;
                case "Neptune" : holder.image.setBackgroundResource(R.drawable.neptune);break;
                case "Terre" : holder.image.setBackgroundResource(R.drawable.terre);break;
                case "Mars" : holder.image.setBackgroundResource(R.drawable.mars);break;
                case "Saturne" : holder.image.setBackgroundResource(R.drawable.saturn);break;
                case "Mercure" : holder.image.setBackgroundResource(R.drawable.mercure);break;
                case "Pluton" : holder.image.setBackgroundResource(R.drawable.morte);break;
                case "Venus" : holder.image.setBackgroundResource(R.drawable.venus);break;
                case "Uranus" : holder.image.setBackgroundResource(R.drawable.uranus);break;
            }
        }
        return view;
    }
    //Nombre d’éléments de la liste
    public int getCount() {
        return AndroidVersionList.size();
    }
}
