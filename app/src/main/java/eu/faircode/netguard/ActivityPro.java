package eu.faircode.netguard;

/*
    This file is part of NetGuard.

    NetGuard is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    NetGuard is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with NetGuard.  If not, see <http://www.gnu.org/licenses/>.

    Copyright 2015-2025 by Marcel Bokhorst (M66B)
*/

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;

public class ActivityPro extends AppCompatActivity {
    private static final String TAG = "NetGuard.Pro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Create");
        Util.setTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pro);

        getSupportActionBar().setTitle(R.string.title_pro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        // Initial state
        updateState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Log.i(TAG, "Up");
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateState() {
        Button btnLog = findViewById(R.id.btnLog);
        Button btnFilter = findViewById(R.id.btnFilter);
        Button btnNotify = findViewById(R.id.btnNotify);
        Button btnSpeed = findViewById(R.id.btnSpeed);
        Button btnTheme = findViewById(R.id.btnTheme);
        Button btnAll = findViewById(R.id.btnAll);
        Button btnDev1 = findViewById(R.id.btnDev1);
        Button btnDev2 = findViewById(R.id.btnDev2);
        TextView tvLog = findViewById(R.id.tvLog);
        TextView tvFilter = findViewById(R.id.tvFilter);
        TextView tvNotify = findViewById(R.id.tvNotify);
        TextView tvSpeed = findViewById(R.id.tvSpeed);
        TextView tvTheme = findViewById(R.id.tvTheme);
        TextView tvAll = findViewById(R.id.tvAll);
        TextView tvDev1 = findViewById(R.id.tvDev1);
        TextView tvDev2 = findViewById(R.id.tvDev2);

        TextView tvLogUnavailable = findViewById(R.id.tvLogUnavailable);
        TextView tvFilterUnavailable = findViewById(R.id.tvFilterUnavailable);

        btnLog.setVisibility(View.VISIBLE);
        btnFilter.setVisibility(View.VISIBLE);
        btnNotify.setVisibility(View.VISIBLE);
        btnSpeed.setVisibility(View.VISIBLE);
        btnTheme.setVisibility(View.VISIBLE);
        btnAll.setVisibility(View.VISIBLE);
        btnDev1.setVisibility(View.VISIBLE);
        btnDev2.setVisibility(View.VISIBLE);

        tvLog.setVisibility(View.VISIBLE);
        tvFilter.setVisibility(View.VISIBLE);
        tvNotify.setVisibility(View.VISIBLE);
        tvSpeed.setVisibility(View.VISIBLE);
        tvTheme.setVisibility(View.VISIBLE);
        tvAll.setVisibility(View.VISIBLE);
        tvDev1.setVisibility(View.VISIBLE);
        tvDev2.setVisibility(View.VISIBLE);

        tvLogUnavailable.setVisibility(View.VISIBLE);
        tvFilterUnavailable.setVisibility(View.VISIBLE);
    }
}
