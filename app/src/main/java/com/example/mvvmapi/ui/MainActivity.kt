package com.example.mvvmapi.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvmapi.model.Todo
import com.example.mvvmapi.ui.theme.MvvmApiTheme
import com.example.mvvmapi.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MvvmApiTheme {
                    TodoScreen()
            }
        }
    }
}

@Composable
fun TodoScreen(todoViewModel: TodoViewModel = viewModel()) {
    TodoList(todoViewModel.todos)
}

@Composable
fun TodoList(todos: List<Todo>) {
    LazyColumn (
        modifier = Modifier.padding(8.dp)
    ){
        items(todos) { todo ->
            Text(
                text = todo.title,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
            HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoPreview() {
    MvvmApiTheme {
        TodoScreen()
    }
}