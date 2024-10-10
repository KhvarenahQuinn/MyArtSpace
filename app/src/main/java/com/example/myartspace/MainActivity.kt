package com.example.myartspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myartspace.ui.theme.MyArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), //agar konten memenuhi layar
                    color = MaterialTheme.colorScheme.background //mengatur background sesuai theme
                ) {
                    ArtSpaceMain() //memanggil fungsi utama untuk tampilan aplikasi
                }
            }
        }
    }
}

@Composable
fun ArtSpace1(Pict : Int, Title: String, Loc: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = Pict), //mengambil gambar dari resource berdasarkan id
            contentDescription = null,
            modifier = Modifier
                .padding(20.dp)
                .height(300.dp)
                .width(300.dp)
                .shadow(elevation = 1.dp)
                .padding(10.dp)
        )
        Card( //untuk bagian nama tempat wisata dan lokasinya
            modifier = Modifier
                .padding(horizontal = 45.dp, vertical = 90.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = Title, //menampilkan nama tempat wisata
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    lineHeight = 30.sp
                )
                Text(
                    text = Loc, //menampilkan lokasi tempat wisata
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Composable
fun ArtSpaceMain(){
    var result by remember {
        mutableStateOf(0)
    }
    when (result){
        1-> ArtSpace1(
            Pict = R.drawable.air_terjun_sekumpul,
            Title = stringResource(R.string.ATS1),
            Loc = stringResource(R.string.ATS2)

        )
        2->ArtSpace1(
            Pict = R.drawable.gunung_bromo,
            Title = stringResource(R.string.GB1),
            Loc = stringResource(R.string.GB2)
        )
        3->ArtSpace1(
            Pict = R.drawable.hutan_pinus_limpakuwus,
            Title = stringResource(R.string.LIM1),
            Loc = stringResource(R.string.LIM2)
        )
        4->ArtSpace1(
            Pict = R.drawable.labuan_bajo,
            Title = stringResource(R.string.LB1),
            Loc = stringResource(R.string.LB2)
        )
        5->ArtSpace1(
            Pict = R.drawable.nusa_penida,
            Title = stringResource(R.string.NP1),
            Loc = stringResource(R.string.NP2)
        )
        6->ArtSpace1(
            Pict = R.drawable.pantai_lampuuk,
            Title = stringResource(R.string.PL1),
            Loc = stringResource(R.string.PL2)
        )
        else->ArtSpace1( //default, menampilkan tempat wisata Tegallalang
            Pict = R.drawable.tegallalang,
            Title = stringResource(R.string.TG1),
            Loc = stringResource(R.string.TG2)
        )
    }
    Row( //berisi tommbol sebelumnya dan berikutnya
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 700.dp)
    ){
        Button(
            onClick ={result --},
            shape = RoundedCornerShape(50.dp),
            border = BorderStroke(1.dp, Color.Black),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp
            )
        ) { Text(text = "Sebelumnya") }
        Button(
            onClick ={result ++},
            shape = RoundedCornerShape(50.dp),
            border = BorderStroke(1.dp, Color.Black),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp
            )
        ) { Text(text = "Berikutnya") }
    }
}
@Preview(showBackground = true)
@Composable
fun ArtSpaceMainPreview() {
    MyArtSpaceTheme {
        ArtSpaceMain()
    }
}
