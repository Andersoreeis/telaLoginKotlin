package br.senai.sp.jandira.loginsynbian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LifecycleCoroutineScope
import br.senai.sp.jandira.loginsynbian.screen.ScreenLogin
import br.senai.sp.jandira.loginsynbian.ui.theme.LoginSynbianTheme
import androidx.lifecycle.lifecycleScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginSynbianTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ExibirTela()
                }
            }
        }
    }
}

@Composable
fun ExibirTela() {
    val lifecycleScope = LocalLifecycleOwner.current.lifecycleScope
    ScreenLogin(lifecycleScope)
}

@Preview(showBackground = true)
@Composable
fun ExibirTelaPreview() {
}
