package com.example.tiendavivapets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tiendavivapets.ui.theme.TiendaVivaPetsTheme
import com.example.tiendavivapets.ui.pantallas.HomeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TiendaVivaPetsTheme {
                Column {
                    MiApp()
                }


            }
        }
    }
}

@Composable
fun MiApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "inicio",
            modifier = Modifier.padding(innerPadding)
        )


        {
            composable ("inicio") { HomeScreen() }
            composable("perfil") { Registro(navController = navController) }
            composable("nosotros") { Nosotros() }
            composable("carrito") { Carrito() }
            composable("productos") { Productos() }
            composable("agregarProducto") { AgregarProducto() } //TODO
            composable("login") { Login(navController = navController) }


        }
    }
}
@Composable
fun BottomNavBar(navController: NavHostController) {
    val items = listOf(
        NavItem("Inicio", "inicio", Icons.Default.Home),
        NavItem("Perfil", "perfil", Icons.Default.Person),
        NavItem("Productos", "productos", Icons.Default.Star),
        NavItem("Nosotros", "nosotros", Icons.Default.Face),
        NavItem("Carrito", "carrito", Icons.Default.ShoppingCart),
        NavItem("Agr. Prod.", "agregarProducto", Icons.Default.Add)
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentDestination?.route == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Evita duplicar destinos
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

data class NavItem(val label: String, val route: String, val icon: ImageVector)



@Composable
fun Registro(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Pantalla de registro")
    }
}

@Composable
fun Nosotros() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Pantalla de Configuración")
    }
}

@Composable
fun Carrito() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Pantalla de Carrito")
    }
}
@Composable
fun Productos() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Pantalla de Productos")
    }
}
@Composable
fun Login(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Pantalla de login")
    }
}
@Composable
fun AgregarProducto() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Pantalla de agregar producto")
    }
}