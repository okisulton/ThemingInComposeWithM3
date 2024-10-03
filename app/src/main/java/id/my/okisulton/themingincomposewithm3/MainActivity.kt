package id.my.okisulton.themingincomposewithm3

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.my.okisulton.themingincomposewithm3.data.LocalEmailsDataProvider
import id.my.okisulton.themingincomposewithm3.ui.ReplyApp
import id.my.okisulton.themingincomposewithm3.ui.ReplyHomeUIState
import id.my.okisulton.themingincomposewithm3.ui.ReplyHomeViewModel
import id.my.okisulton.themingincomposewithm3.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    private val viewModel: ReplyHomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val uiState by viewModel.uiState.collectAsState()
            AppTheme {
                Surface(tonalElevation = 5.dp) {
                    ReplyApp(
                        replyHomeUIState = uiState,
                        closeDetailScreen = {
                            viewModel.closeDetailScreen()
                        },
                        navigateToDetail = { emailId ->
                            viewModel.setSelectedEmail(emailId)
                        }
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Default Preview Dark"
)
@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Default Preview Light"
)
@Composable
fun ReplyAppPreviewLight() {
    Surface(tonalElevation = 5.dp) {
        AppTheme {
            ReplyApp(
                replyHomeUIState = ReplyHomeUIState(
                    emails = LocalEmailsDataProvider.allEmails
                )
            )
        }
    }
}