package com.sample.prak6.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sample.prak6.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    var textNama by remember { mutableStateOf(value = "") }
    var textAlamat by remember { mutableStateOf(value = "") }
    var textJK by remember { mutableStateOf(value = "") }
    var textSP by remember { mutableStateOf(value = "") }

    var nama by remember { mutableStateOf(value = "") }
    var alamat by remember { mutableStateOf(value = "") }
    var jenis by remember { mutableStateOf(value = "") }
    var status by remember { mutableStateOf(value = "") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")
    val statusKawin: List<String> = listOf("Janda", "Lajang", "Duda")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Formulir Pendaftaran", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "NAMA LENGKAP",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )

            OutlinedTextField(
                value = textNama,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Nama Lengkap") },
                onValueChange = {
                    textNama = it
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "JENIS KELAMIN",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )

            Column {
                gender.forEach { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = textJK == item,
                                onClick = {
                                    textJK = item
                                }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = textJK == item,
                            onClick = {
                                textJK = item
                            }
                        )
                        Text(text = item)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "STATUS PERKAWINAN",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                statusKawin.forEach { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = textSP == item,
                                onClick = { textSP = item }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = textSP == item,
                            onClick = { textSP = item }
                        )
                        Text(text = item)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "ALAMAT",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Start)
            )

            OutlinedTextField(
                value = textAlamat,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Alamat Lengkap") },
                onValueChange = {
                    textAlamat = it
                }
            )

            HorizontalDivider(
                modifier = Modifier.padding(
                    bottom = dimensionResource(R.dimen.padding_medium),
                    top = dimensionResource(R.dimen.padding_medium)
                ),
                thickness = dimensionResource(R.dimen.divider_tipis),
                color = Color.DarkGray
            )

            Button(
                modifier = Modifier.fillMaxWidth(fraction = 1f),
                enabled = textAlamat.isNotEmpty() && textSP.isNotEmpty(),
                onClick = {
                    nama = textNama
                    jenis = textJK
                    alamat = textAlamat
                    status = textSP
                }
            ) {
                Text(text = stringResource(id = R.string.submit))
            }

            HorizontalDivider(
                modifier = Modifier.padding(
                    bottom = dimensionResource(id = R.dimen.padding_medium),
                    top = dimensionResource(id = R.dimen.padding_medium)
                ),
                thickness = dimensionResource(id = R.dimen.divider_tipis),
                color = Color.DarkGray
            )

            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 15.dp)
                ) {
                    Text(text = "Nama   : $nama", color = Color.White)
                    Text(text = "Gender : $jenis", color = Color.White)
                    Text(text = "Status : $status", color = Color.White)
                    Text(text = "Alamat : $alamat", color = Color.White)
                }
            }
        }
    }
}

