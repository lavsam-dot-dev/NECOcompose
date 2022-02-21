package lavsam.dev.necocompouse

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lavsam.dev.necocompouse.ui.theme.NECOcompouseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircleItem()
            }
        }
    }
}

@Composable
private fun CircleItem() {
    val counter = remember {
        mutableStateOf(0)
    }
    val color = remember {
        mutableStateOf(Color.Blue)
    }

    Box(
        modifier = Modifier
            .size(200.dp)
            .background(color = color.value, shape = CircleShape)
            .clickable {

                when(++counter.value){
                    10 -> color.value = Color.Red
                    20 -> color.value = Color.Green
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = counter.value.toString(),
            style = TextStyle(color = Color.White, fontSize = 70.sp)
        )

    }
}

@Composable
private fun ListItem(name: String, prof: String) {
    val counter = remember {
        mutableStateOf(0)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                counter.value++
                //Log.d("MyLog", "Counter $counter.")

            },
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.lav_ava),
                    contentDescription = "lav_ava",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(text = counter.value.toString())
                    Text(text = prof)
                }
            }
        }
    }

}

