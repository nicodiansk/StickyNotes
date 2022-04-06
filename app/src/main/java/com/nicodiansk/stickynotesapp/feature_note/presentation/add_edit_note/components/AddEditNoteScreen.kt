package com.nicodiansk.stickynotesapp.feature_note.presentation.add_edit_note.components

import androidx.compose.animation.Animatable
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.nicodiansk.stickynotesapp.feature_note.presentation.add_edit_note.AddEditNodeViewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun AddEditNoteScreen(
    navigator: DestinationsNavigator,
    viewModel: AddEditNodeViewModel = hiltViewModel(),
    noteColor: Int
) {
    val titleState = viewModel.noteTitle.value
    val contentState = viewModel.noteContent.value
    val scaffoldState = rememberScaffoldState()

    val noteBackgroundAnimatable = remember {
        Animatable(Color(noteColor))
    }
}