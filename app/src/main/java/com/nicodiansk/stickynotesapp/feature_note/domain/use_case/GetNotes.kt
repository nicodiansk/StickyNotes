package com.nicodiansk.stickynotesapp.feature_note.domain.use_case

import com.nicodiansk.stickynotesapp.feature_note.domain.model.Note
import com.nicodiansk.stickynotesapp.feature_note.domain.repository.NoteRepository
import com.nicodiansk.stickynotesapp.feature_note.domain.util.NoteOrder
import com.nicodiansk.stickynotesapp.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(private val repository: NoteRepository) {
    operator fun invoke(
        nodeOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when (nodeOrder.orderType) {
                OrderType.Ascending -> {
                    when (nodeOrder) {
                        is NoteOrder.Color -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Title -> notes.sortedBy { it.color }
                    }
                }
                OrderType.Descending -> {
                    when (nodeOrder) {
                        is NoteOrder.Color -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Title -> notes.sortedByDescending { it.color }
                    }
                }
            }
            notes
        }
    }
}