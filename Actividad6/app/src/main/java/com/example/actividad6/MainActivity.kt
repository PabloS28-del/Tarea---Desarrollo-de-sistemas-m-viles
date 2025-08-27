package com.example.actividad6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.actividad6.ui.theme.Actividad6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Actividad6Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFDCEFE4) // verde muy claro
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        ProfileSection(
            modifier = Modifier
                .align(Alignment.Center)
        )
        ContactSection(
            phone = "+51 929 158 221",
            handle = "@androidDev",
            email = "pablo.suarez2@unmsm.edu.pe",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        )
    }
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(96.dp)
                .clip(CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape)
            )
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Pablo Suarez",
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 14.sp,
            color = Color(0xFF2C7A7B) // tono verdoso para contraste
        )
    }
}

@Composable
fun ContactRow(
    icon: @Composable () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Spacer(Modifier.width(12.dp))
        Text(text = text, fontSize = 14.sp)
    }
}

@Composable
fun ContactSection(
    phone: String,
    handle: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(bottom = 8.dp)
    ) {
        Divider(thickness = 1.dp, color = Color(0xFFB7D6C7))
        Spacer(Modifier.height(8.dp))

        ContactRow(
            icon = { Icon(Icons.Filled.Phone, contentDescription = "Teléfono", tint = Color(0xFF2C7A7B)) },
            text = phone,
            modifier = Modifier.align(Alignment.Start)
        )
        ContactRow(
            icon = { Icon(Icons.Filled.Email, contentDescription = "Usuario", tint = Color(0xFF2C7A7B)) },
            text = handle,
            modifier = Modifier.align(Alignment.Start)
        )
        ContactRow(
            icon = { Icon(Icons.Filled.Email, contentDescription = "Correo", tint = Color(0xFF2C7A7B)) },
            text = email,
            modifier = Modifier.align(Alignment.Start)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    Actividad6Theme {
        Surface(color = Color(0xFFDCEFE4)) {
            BusinessCardApp()
        }
    }
}
