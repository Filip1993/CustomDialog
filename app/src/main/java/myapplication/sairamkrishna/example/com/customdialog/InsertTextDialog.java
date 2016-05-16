package myapplication.sairamkrishna.example.com.customdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by programer on 16.5.2016..
 */
public class InsertTextDialog extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final MainActivity ma = (MainActivity) getActivity();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.insert_nick_name);

        //inflateamo xml sucelje, kao setContextView
        //Odlican snippet koda koji nam objasnjava kako inflateati
        LayoutInflater li = getActivity().getLayoutInflater();
        View v = li.inflate(R.layout.insert_text_dialog, null);
        final EditText etNick = (EditText) v.findViewById(R.id.etNick);

        //zakucamo odmah u EditText
        etNick.setText(ma.getNick());

        builder.setView(v);

        //negativni button:
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });

        //pozitivni button:
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String text = etNick.getText().toString();
                ma.setNick(text);
                dismiss();
            }
        });

        return builder.create();
    }
}
