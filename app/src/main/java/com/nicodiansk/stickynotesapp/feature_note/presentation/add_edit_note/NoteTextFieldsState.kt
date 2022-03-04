package com.nicodiansk.stickynotesapp.feature_note.presentation.add_edit_note

data class NoteTextFieldsState(
   val text:String = "",
   val hint:String = "",
   val isHintVisible:Boolean = true,
)
