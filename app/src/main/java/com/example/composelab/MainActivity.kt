package com.example.composelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelab.ui.theme.ComposeLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeLabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DisplayArticle(
                        modifier = Modifier.padding(innerPadding).fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun DisplayArticle(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background);
    Column(modifier = Modifier) {
        Image(
            painter = image,
            contentDescription = null,
            alpha = 1f,
            modifier = Modifier
                .fillMaxWidth()
        )
        DisplayTitle(
            title = stringResource(R.string.para_title)
        )
        DisplayParagraph(
            para = stringResource(R.string.para_1),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        DisplayParagraph(
            para = stringResource(R.string.para_2),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp)
        )
    }
}

@Composable
fun DisplayTitle(modifier: Modifier = Modifier, title: String){
    Text(
        text = title,
        textAlign = TextAlign.Center,
        fontSize = 24.sp,
        modifier = modifier
            .padding(16.dp)
    )
}

@Composable
fun DisplayParagraph(modifier: Modifier = Modifier, para: String){
    Text(
        text = para,
        fontSize = 12.sp,
        modifier = modifier,
        textAlign = TextAlign.Justify
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeLabTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            DisplayArticle(
                modifier = Modifier.padding(innerPadding).fillMaxSize()
            )
        }
    }
}