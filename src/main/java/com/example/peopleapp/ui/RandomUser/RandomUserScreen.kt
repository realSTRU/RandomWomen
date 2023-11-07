package com.example.peopleapp.ui.RandomUser

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.peopleapp.data.remote.dto.PersonDto


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RandomUserScreen (users : List<PersonDto>){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Historial", color = MaterialTheme.colorScheme.primary, style= MaterialTheme.typography.titleMedium) },
            )
        }, content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top=70.dp)
            )
            {
                items(users){ user ->

                    UserItem(user = user)

                }
            }
        }
    )

}


@Composable
fun UserItem( user : PersonDto)
{
    Surface(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        color = Color.White,
        shadowElevation = 3.dp,
        shape = RoundedCornerShape(8.dp)
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            RoundImage(image = user.picture.large , Description = user.name.first, modifier = Modifier.padding(top = 10.dp, bottom = 5.dp))
            Row {
                Text(text=user.name.title, color= MaterialTheme.colorScheme.tertiary, style= MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.padding(3.dp))
                Text(text=user.name.first, style= MaterialTheme.typography.bodyMedium)
                Text(text=user.name.last, style= MaterialTheme.typography.bodyMedium)
            }
            Divider()
            Text(text = user.nationality, style = MaterialTheme.typography.displaySmall, color = MaterialTheme.colorScheme.primary)


        }

    }
}

@Composable
fun RoundImage(
    image: String,
    modifier: Modifier = Modifier,
    Description: String?
)
{
    AsyncImage(model = image,
        contentDescription =Description,
        modifier= modifier
            .border(
                width = 5.dp,
                color = MaterialTheme.colorScheme.onSecondary,
                shape = CircleShape
            )
            .clip(CircleShape)
            .aspectRatio(1f, true)
    )
}