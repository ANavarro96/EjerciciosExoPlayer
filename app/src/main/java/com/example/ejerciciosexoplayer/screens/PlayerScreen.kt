package com.example.ejerciciosexoplayer.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.exoplayer.ExoPlayer
import com.example.ejerciciosexoplayer.R
import com.example.ejerciciosexoplayer.shared.ExoPlayerViewModel
import com.example.ejerciciosexoplayer.shared.ScaffoldViewModel

@Composable
fun ExoPlayerScreen(viewModelScaffold: ScaffoldViewModel = viewModel()){
    val contexto = LocalContext.current

    /* Variables de estado */
    val exoPlayerViewModel: ExoPlayerViewModel = viewModel()
    val duracion by exoPlayerViewModel.duracion.collectAsStateWithLifecycle()
    val posicion by exoPlayerViewModel.progreso.collectAsStateWithLifecycle()

    /* TODO: Llamar a crearExoPlayer y hacerSonarMusica */

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("La duración  de este temazo es ${duracion/1000} " +
                "y vamos por el segundo ${posicion/1000}")
        Button(onClick = { exoPlayerViewModel.PausarOSeguirMusica() }) {
            Text("Play")
        }
        Button(onClick = {
            // En este caso modifico tanto la canción de este componente...
            exoPlayerViewModel.CambiarCancion(contexto);
            // ...como valores de otros componentes, siempre pasando el VM asociado!
            viewModelScaffold.modificarCancion()
       }) {
            Text("Next")
        }

    }
}