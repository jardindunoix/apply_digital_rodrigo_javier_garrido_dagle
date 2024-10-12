package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.ui.screens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.domain.model.Hit
import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.utilities.Constants.DETAIL_SCREEN
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@Composable
fun ColumnItem(
    modifier: Modifier,
    hit: Hit,
    navController: NavController,
) {
    val author = hit.author
    val title = hit.title ?: hit.storyTitle
    val storyDate = hit.updatedAt ?: hit.createdAt
    val storyLink = hit.storyUrl ?: "no link"
//    val createdAtId = hit.createdAtI
//    val storyText = hit.storyText ?: hit.commentText

    Card(
        modifier
            .fillMaxWidth()
            .padding(1.dp)
            .wrapContentSize()
            .padding(1.dp)
            .clickable {
                navController.navigate(route = DETAIL_SCREEN)
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(3.dp),
        shape = RoundedCornerShape(1.dp)
    ) {
        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            Column(modifier.padding(8.dp)) {
                Text(text = title!!, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }

        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            Column(modifier.padding(8.dp)) {
                val then = storyDate!!.split("Z")[0] + ".000"
                val start = LocalDateTime.parse(then).minus(6, ChronoUnit.HOURS)
                val end = LocalDateTime.now()
                val difference = start.until(end, ChronoUnit.HOURS)

                val message = if (difference > 0L) {
                    "Posted $difference hours ago"
                } else {
                    "Just posted"
                }

                Text(
                    text = "$author - $message",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}