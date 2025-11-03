package com.example.kotlin_lev1_hw1

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlin_lev1_hw1.viewModel.NumberViewModel

class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NumbersGrid()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NumbersGrid(viewModel: NumberViewModel = viewModel()) {
    val numbers = viewModel.numbers
    val config = LocalConfiguration.current
    val columns = if (config.orientation == Configuration.ORIENTATION_PORTRAIT) 3 else 4

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .padding(top = 24.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(columns),
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(numbers.size){ index ->
                NumberItem(index)
            }
        }

        // Кнопка добавления элементов списка
        FloatingActionButton(
            onClick = {viewModel.addNumber()},
            modifier = Modifier
                .align(Alignment.End)
                .padding(8.dp),

        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = stringResource(R.string.add)
            )
        }
    }
}

@Composable
fun NumberItem(index: Int) {
    val color = if (index % 2 == 0)
        colorResource(id = R.color.red)
    else
        colorResource(id = R.color.blue)
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .background(
                color = color,
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = index.toString(),
            textAlign = TextAlign.Center,
            color = Color.White
            )
    }
}