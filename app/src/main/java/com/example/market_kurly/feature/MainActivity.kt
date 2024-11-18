package com.example.market_kurly.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.market_kurly.core.base.BaseViewModelFactory
import com.example.market_kurly.data.ServicePool
import com.example.market_kurly.domain.repositoryimpl.ExampleRepositoryImpl
import com.example.market_kurly.feature.nav.NavGraph
import com.example.market_kurly.ui.theme.MARKETKURLYTheme

class MainActivity : ComponentActivity() {

    private val exampleRepository by lazy { ExampleRepositoryImpl(ServicePool.exampleService) }
    private val viewModelFactory by lazy { BaseViewModelFactory(exampleRepository) }

    private val viewModel: ExampleViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MARKETKURLYTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavGraph(navController = navController)
                }
            }
        }
    }
}