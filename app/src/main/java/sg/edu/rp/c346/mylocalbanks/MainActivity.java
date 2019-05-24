package sg.edu.rp.c346.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
  //Declare fields
  Button btnDBS, btnOCBC, btnUOB;

  int mode = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Link fields
    btnDBS = findViewById(R.id.btnDBS);
    btnOCBC = findViewById(R.id.btnOCBC);
    btnUOB = findViewById(R.id.btnUOB);

    //Register context menu for buttons
    registerForContextMenu(btnDBS);
    registerForContextMenu(btnOCBC);
    registerForContextMenu(btnUOB);
  }

  //Set context menu
  @Override
  public void onCreateContextMenu(ContextMenu menu, View v,
                                  ContextMenu.ContextMenuInfo menuInfo)
  {
    super.onCreateContextMenu(menu, v, menuInfo);

    menu.add(0,0,0, "Website");
    menu.add(0,1,1,"Contact the bank");

    if(v.getId() == R.id.btnDBS)
    {
      mode = 1;
    }
    else if (v.getId() == R.id.btnOCBC)
    {
      mode = 2;
    }
    else
    {
      mode = 3;
    }
  }

  @Override
  public boolean onContextItemSelected(MenuItem item)
  {
    if(item.getItemId()==0) //Website menu
    {
      if(mode == 1)
      {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
        startActivity(browserIntent);
      }
      else if (mode == 2)
      {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
        startActivity(browserIntent);
      }
      else
      {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com"));
        startActivity(browserIntent);
      }
      return true;

    }
    else if (item.getItemId() == 1) //Phone menu
    {
      if(mode == 1)
      {
        Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 180011111));
        startActivity(intentCall);
      }
      else if (mode == 2)
      {
        Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 123));
        startActivity(intentCall);
      }
      else
      {
        Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 333));
        startActivity(intentCall);
      }
      return true;
    }
    return super.onContextItemSelected(item);
  }

  //Set option menu
  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return super.onCreateOptionsMenu(menu);
  }

  //Set translation
  @Override
  public boolean onOptionsItemSelected(MenuItem item)
  {
    int id = item.getItemId();

    if(id == R.id.EnglishSelection)
    {
      btnDBS.setText("DBS");
      btnOCBC.setText("OCBC");
      btnUOB.setText("UOB");
    }
    else if(id == R.id.ChineseSelection)
    {
      btnDBS.setText("星展银行");
      btnOCBC.setText("华侨银行");
      btnUOB.setText("大华银行");
    }
    else
    {
      btnDBS.setText("Error");
      btnOCBC.setText("Error");
      btnUOB.setText("Error");
    }
    return super.onOptionsItemSelected(item);
  }
}
