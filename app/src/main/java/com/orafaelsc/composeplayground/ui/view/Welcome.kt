package com.orafaelsc.composeplayground.ui.view

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.orafaelsc.composeplayground.R
import com.orafaelsc.composeplayground.ui.theme.ComposePlaygroundThemeExtended


@Composable
fun WelcomeView(context: Context) {
    val action = { Toast.makeText(context, "Welcome toast", Toast.LENGTH_SHORT).show() }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp, vertical = 22.dp)
        ) {
            Text(
                text = context.getString(R.string.compose_playground),
                style = ComposePlaygroundThemeExtended.typographyCustom.h1
            )
            Text(
                text = context.getString(R.string.welcome_message),
                style = ComposePlaygroundThemeExtended.typographyCustom.body1,
                modifier = Modifier.padding(vertical = 16.dp)
            )

        }

    }
}