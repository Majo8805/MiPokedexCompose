package enriquez.mariajose.mipokedexcompose.view.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun ImagePickerPreview (
    currentUri: Uri,
    onUriChange: (uri: Uri?) -> Unit,
    pickerModifier: Modifier? = null,
    previewModifier: Modifier? = null
) {
    val selectorModifier = pickerModifier ?: Modifier
    val imagePreviewModifier =previewModifier ?: Modifier

    val context = LocalContext.current
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {uri -> onUriChange(uri)}
    )
    Button({imagePickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))},
        modifier = selectorModifier
    ) { Text("Seleccione una imagen") }

}