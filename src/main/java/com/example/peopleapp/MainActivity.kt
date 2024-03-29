package com.example.peopleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.peopleapp.ui.RandomUser.RandomUserScreen
import com.example.peopleapp.ui.RandomUser.RandomUserViewModel
import com.example.peopleapp.ui.theme.PeopleAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PeopleAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UsersScreen()
                }
            }
        }
    }
}


@Composable
fun UsersScreen(viewmodel : RandomUserViewModel = hiltViewModel())
{
    val uiState by viewmodel.uiState.collectAsStateWithLifecycle()

    uiState.users?.let { users ->
        RandomUserScreen(users = users)
    }
}
