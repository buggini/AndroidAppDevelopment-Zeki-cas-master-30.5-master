package rs.aleph.android.example12.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import rs.aleph.android.example12.R;
import rs.aleph.android.example12.model.Sastojak;
import rs.aleph.android.example12.providers.JeloProvider;
import rs.aleph.android.example12.providers.KategorijaProvider;
import rs.aleph.android.example12.providers.SastojciProvider;

// Each activity extends Activity class
public class SecondActivity extends Activity {

    private int position = 0;
    private static final int CAMERA_REQUEST_CODE = 10;
    private static final int PERMISSIONS_REQUEST_INTERNET = 0;



    // onCreate method is a lifecycle method called when he activity is starting

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Each lifecycle method should call the method it overrides
        super.onCreate(savedInstanceState);
        // setContentView method draws UI
        setContentView(R.layout.activity_second);

        if (savedInstanceState != null) {
            this.position = savedInstanceState.getInt("position");
        }

        position = getIntent().getIntExtra("position", 0);

        // Finds "tvName" TextView and sets "text" property
        ImageView ivImage= (ImageView) findViewById(R.id.iv_image);
        InputStream is =null;
        try {
            is = getAssets().open(JeloProvider.getJeloById(position).getSlika());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        TextView tvName = (TextView) findViewById(R.id.tv_name);
        tvName.setText(JeloProvider.getJeloById(position).getNaziv());


        // Finds "tvDescription" TextView and sets "text" property
        TextView tvDescription = (TextView) findViewById(R.id.tv_description);
        tvDescription.setText(JeloProvider.getJeloById(position).getOpis());

        TextView kaloriskVr= (TextView) findViewById(R.id.tv_kaloriska_vrednost);
        String kaloStr =String.valueOf(JeloProvider.getJeloById(position).getKlVresnost());
        kaloriskVr.setText(kaloStr);

        TextView cena= (TextView) findViewById(R.id.tv_cena_hrane);
        String cenaStr = String.valueOf(JeloProvider.getJeloById(position).getCena());
        cena.setText(cenaStr);

        // Finds "rbRating" RatingBar and sets "rating" property
        RatingBar rbRating = (RatingBar) findViewById(R.id.rb_rating);
        rbRating.setRating(JeloProvider.getJeloById(position).getRating());


        // Finds "spCategory" Spiner and sets "selection" property
        Spinner category = (Spinner) findViewById(R.id.sp_kategorija);
        List<String> katogrijaNames = KategorijaProvider.getKatogrijaNames();
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, katogrijaNames);
        category.setAdapter(adapter);
        category.setSelection((int)JeloProvider.getJeloById(position).getKategorija().getId());
//
//        //spiner za ssastojke
        Spinner sastojak = (Spinner) findViewById(R.id.sp_lista_sastojka);
        List<Sastojak> sastojakName = JeloProvider.getJeloById(position).getSastojci();
        ArrayAdapter<Sastojak> adapterr = new ArrayAdapter(this, android.R.layout.simple_spinner_item, sastojakName);
        sastojak.setAdapter(adapterr);
        sastojak.setSelection((int)SastojciProvider.getSastojakById(position).getId());





//        final List<String> sastojakNames = SastojciProvider.getSastojakNames();
//
//        // Creates an ArrayAdaptar from the array of String
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,R.layout.list_item, sastojakNames);
//        ListView listView = (ListView) findViewById(R.id.listaSastojka);
//
//        // Assigns ArrayAdaptar to ListView
//        listView.setAdapter(dataAdapter);


//        // Starts the SecondActivity and sends it the selected URL as an extra data
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                intent.putExtra("position", position);
//                startActivity(intent);
//            }
//        });
        // Finds "btnBuy" Button and sets "onClickListener" listener
        Button btnBuy = (Button) findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(v.getContext(), "You've bought " + JeloProvider.getJeloById(position).getNaziv() + "!", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        // Shows a toast message (a pop-up message)
        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onCreate()", Toast.LENGTH_SHORT);
        toast.show();

//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
//
//            // PERMISSIONS_REQUEST_INTERNET is an app-defined int constant.
//            // The callback method gets the result of the request.
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PERMISSIONS_REQUEST_INTERNET);
//
//        } else {
//
//            // Loads an URL into the WebView
//            String URL = getIntent().getStringExtra("URL");
//            if (!URL.trim().equalsIgnoreCase("")) {
//                WebView myWebView = (WebView) findViewById(R.id.pageInfo);
//                myWebView.getSettings().setJavaScriptEnabled(true);
//                myWebView.setWebViewClient(new MyWebViewClient());
//                myWebView.loadUrl(URL.trim());
//            }
//
//        }

    }


    // onStart method is a lifecycle method called after onCreate (or after onRestart when the
    // activity had been stopped, but is now again being displayed to the user)
    @Override
    protected void onStart() {
        super.onStart();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onStart()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onRestart method is a lifecycle method called after onStop when the current activity is
    // being re-displayed to the user
    @Override
    protected void onRestart() {
        super.onRestart();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onRestart()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onResume method is a lifecycle method called after onRestoreInstanceState, onRestart, or
    // onPause, for your activity to start interacting with the user
    @Override
    protected void onResume() {
        super.onResume();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onResume()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onPause method is a lifecycle method called when an activity is going into the background,
    // but has not (yet) been killed
    @Override
    protected void onPause() {
        super.onPause();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onPause()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onStop method is a lifecycle method called when the activity are no longer visible to the user
    @Override
    protected void onStop() {
        super.onStop();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onStop()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onDestroy method is a lifecycle method that perform any final cleanup before an activity is destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onDestroy()", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        // Shows a toast message (a pop-up message)
        Toast.makeText(this, "FirstActivity.onSaveInstanceState()", Toast.LENGTH_SHORT).show();

        savedInstanceState.putInt("position", position);
    }
    //    public void btnStartActivityClicked (View view){
//        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
//        // startActivity method starts an activity
//        startActivity(intent);
//    }
    public void btnOpenCameraClicked (View view) {
//        if (ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST_CODE);
//        }else{
        invokeCamera();
//        }
    }


    private void invokeCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivity(takePictureIntent);
    }

//    private class MyWebViewClient extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//
//            return false;
//        }
//    }

//     This method is invoked asynchronously for every call on requestPermissions

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
//        switch (requestCode) {
//            case PERMISSIONS_REQUEST_INTERNET: {
//                // If request is cancelled, the result arrays are empty.
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//
//                    // Permission was granted
//
//                    // Loads an URL into the WebView
//                    String URL = getIntent().getStringExtra("URL");
//                    if (!URL.trim().equalsIgnoreCase("")) {
//                        WebView myWebView = (WebView) findViewById(R.id.pageInfo);
//                        myWebView.getSettings().setJavaScriptEnabled(true);
//                        myWebView.setWebViewClient(new MyWebViewClient());
//                        myWebView.loadUrl(URL.trim());
//                    }
//
//                } else {
//
//                    // Permission denied
//                }
//                return;
//            }
//            case CAMERA_REQUEST_CODE:{
//
//                    if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                        invokeCamera();
//                    }else{
//                        Toast.makeText(this, getString(R.string.unable_to_invoke_camera), Toast.LENGTH_LONG).show();
//                    }
//                return;
//
//            }
//            // other 'case' lines to check for other permissions this app might request
//     }
//    }


}
