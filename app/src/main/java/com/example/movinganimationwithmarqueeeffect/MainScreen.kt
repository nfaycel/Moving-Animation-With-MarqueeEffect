package com.example.movinganimationwithmarqueeeffect

import android.media.Image
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen() {
    val focusRequester = remember {
        FocusRequester()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .background(Color.Red)
                .padding(vertical = 10.dp)
                .basicMarquee(
                    iterations = Int.MAX_VALUE,
                    delayMillis = 0,
                    initialDelayMillis = 0,
                    velocity = 100.dp
                ),
            color = Color.White,
            text = "BREAKING NEWS! Global Summit on Climate Change Ends with Historic Agreement to Cut Carbon" +
                    "Emissions by 50% by 2030"
        )
        Row(
            modifier = Modifier
                .basicMarquee(
                    animationMode = MarqueeAnimationMode.WhileFocused,
                    velocity = 100.dp,
                    iterations = Int.MAX_VALUE,
                )
                // Be carful we must call focusRequester() before focusable()
                .focusRequester(focusRequester)
                .focusable()
        ) {
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(id = R.drawable.train),
                contentDescription = "Train"
            )
            repeat(20) {
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = R.drawable.wagon),
                    contentDescription = "Train Wagon"
                )
            }
        }
        Button(onClick = { focusRequester.requestFocus() }) {
            Text(text = "Woo-hoo!")
        }

    }
}