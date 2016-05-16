package myapplication.sairamkrishna.example.com.customdialog;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnCustom;
    private TextView tvNick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();
    }

    private void initWidgets() {
        btnCustom = (Button) findViewById(R.id.btnCustom);
        tvNick = (TextView) findViewById(R.id.tvNick);
    }

    private void setupListeners() {
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new InsertTextDialog();
                dialogFragment.show(getFragmentManager(), null);
            }
        });
    }

    public void setNick(String nick) {
        tvNick.setText(nick);
    }

    public String getNick() {
        return tvNick.getText().toString();
    }
}
