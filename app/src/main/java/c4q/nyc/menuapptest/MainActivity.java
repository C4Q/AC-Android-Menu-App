package c4q.nyc.menuapptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private Button contextButton;

    private final String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Registering a view on which to trigger the context menu.
         * Long-pressing this contextButton would cause a context menu to be displayed.
         */
        contextButton = (Button) findViewById(R.id.context_button);
        registerForContextMenu(contextButton);
    }

    /**
     * Options menu is the menu displayed in the app bar by default.
     * This method inflates the menu from a menu file.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    /**
     * This method is called when an item in the options menu is clicked.
     * Since there can be many items in the menu,
     * we use `item.getItemId()` to determine which menu item was clicked
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.item:
                Toast.makeText(this, "Options Menu: Item was clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.help:
                Toast.makeText(this, "Options Menu: Help was clicked", Toast.LENGTH_SHORT).show();
                Intent helpIntent = new Intent(this, HelpActivity.class);
                startActivity(helpIntent);
                break;
            default:
                Toast.makeText(this, "Options Menu: Some menu button was clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    /**
     * Called when a view, v, that is registered to trigger a context menu is clicked
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
    }

    /**
     * Called when an item in a context menu is clicked.
     * Very similar to `onOptionsItemSelected` for options menu.
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.item:
                Toast.makeText(this, "Context Menu: Item was clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.help:
                Toast.makeText(this, "Context Menu: Help was clicked", Toast.LENGTH_SHORT).show();
                Intent helpIntent = new Intent(this, HelpActivity.class);
                startActivity(helpIntent);
                break;
            default:
                Toast.makeText(this, "Context Menu: Some menu button was clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    /**
     * Called to create a popup menu.
     * OnClickHandler for popup button in activity_main.xml
     * @param v
     */
    public void onCreatePopupMenu(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        popup.setOnMenuItemClickListener(this);
        inflater.inflate(R.menu.options_menu, popup.getMenu());
        popup.show();
    }

    /**
     * Called when an item in a popup menu is clicked.
     * @param item
     * @return
     */
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.item:
                Toast.makeText(this, "Popup Menu: Item was clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.help:
                Toast.makeText(this, "Popup Menu: Help was clicked", Toast.LENGTH_SHORT).show();
                Intent helpIntent = new Intent(this, HelpActivity.class);
                startActivity(helpIntent);
                break;
            default:
                Toast.makeText(this, "Popup Menu: Some menu button was clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
