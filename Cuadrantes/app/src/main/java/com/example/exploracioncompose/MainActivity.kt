package com.example.exploracioncompose

// Práctica de Android Developers: aspectos básicos de Compose.
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = true
        setContent { MaterialTheme { Cuadrantes() } }
    }
}

@Composable fun Articulo() {
    Column(Modifier.fillMaxSize().statusBarsPadding()) {
        Image(painterResource(R.drawable.bg_compose_background), contentDescription = null,
            modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
        Text(stringResource(R.string.article_title), fontSize = 24.sp, modifier = Modifier.padding(16.dp))
        Text(stringResource(R.string.article_intro), textAlign = TextAlign.Justify, modifier = Modifier.padding(horizontal = 16.dp))
        Text(stringResource(R.string.article_body), textAlign = TextAlign.Justify, modifier = Modifier.padding(16.dp))
    }
}
@Composable fun Tareas() {
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painterResource(R.drawable.ic_task_completed), contentDescription = null)
        Text(stringResource(R.string.tasks_completed), fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 24.dp, bottom = 8.dp))
        Text(stringResource(R.string.nice_work), fontSize = 16.sp)
    }
}
@Composable fun Cuadrantes() {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            Cuadrante(stringResource(R.string.text_title), stringResource(R.string.text_description), Color(0xFFEADDFF), Modifier.weight(1f).fillMaxHeight())
            Cuadrante(stringResource(R.string.image_title), stringResource(R.string.image_description), Color(0xFFD0BCFF), Modifier.weight(1f).fillMaxHeight())
        }
        Row(Modifier.weight(1f)) {
            Cuadrante(stringResource(R.string.row_title), stringResource(R.string.row_description), Color(0xFFB69DF8), Modifier.weight(1f).fillMaxHeight())
            Cuadrante(stringResource(R.string.column_title), stringResource(R.string.column_description), Color(0xFFF6EDFF), Modifier.weight(1f).fillMaxHeight())
        }
    }
}
@Composable fun Cuadrante(titulo: String, descripcion: String, color: Color, modifier: Modifier = Modifier) {
    Column(modifier.background(color).padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(titulo, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
        Text(descripcion, textAlign = TextAlign.Justify)
    }
}
@Preview(showBackground = true) @Composable fun VistaPrevia() { Cuadrantes() }
