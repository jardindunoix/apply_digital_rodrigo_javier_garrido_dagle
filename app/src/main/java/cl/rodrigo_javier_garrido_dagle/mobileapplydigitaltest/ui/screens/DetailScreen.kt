package cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.R
import cl.rodrigo_javier_garrido_dagle.mobileapplydigitaltest.MainViewModel

@Composable
fun DetailScreen(
   navController: NavHostController,
   viewmodel: MainViewModel,
) {
   Surface(
      modifier = Modifier
         .fillMaxSize()
         .padding(0.dp)
   ) {
      Column(
         Modifier.background(Color.Yellow)
      ) {

         Spacer(Modifier.padding(12.dp))
         Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
         ) {
            Image(
               modifier = Modifier
                  .padding(top = 0.dp)
                  .width(180.dp)
                  .height(180.dp)
                  .padding(0.dp),
               painter = painterResource(id = R.drawable.icon),
               contentDescription = "image"
            )
         }
         Spacer(Modifier.padding(12.dp))
         Text(
            text = "DETAAIILLLL",
            color = Color.Black,
            fontSize = 20.sp
         )
      }
   }
}