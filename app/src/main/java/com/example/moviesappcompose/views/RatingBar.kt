import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviesappcompose.R
import kotlin.math.roundToInt

@ExperimentalComposeUiApi
@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double
) {

    var ratingState by remember {
        mutableIntStateOf(rating.roundToInt())
    }
    val myTargetValue by remember {
        mutableIntStateOf(34)
    }

    val size by animateDpAsState(
        targetValue = myTargetValue.dp,
        label = "Stars"
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 1..10) {
            Icon(
                painter = painterResource(id = R.drawable.ic_round_star_24),
                contentDescription = "star",
                modifier = modifier
                    .width(size)
                    .height(size),
//                    .pointerInteropFilter {
//                        when (it.action) {
//                            MotionEvent.ACTION_DOWN -> {
//                                selected = true
//                                ratingState = i
//                            }
//                            MotionEvent.ACTION_UP -> {
//                                selected = false
//                            }
//                        }
//                        true
//                    },
                tint = if (i <= ratingState) Color(0xFFFFD700) else Color(0xFFA2ADB1)
            )
        }
    }
    Text(text = "Unrounded: $rating, rounded: $ratingState")
}

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun prev(){
    RatingBar(rating = 5.0)
}