package com.example.neetrootcourse
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

data class Contact(
    val name: String,
    val phoneNumber: String
)

@Composable
fun Test(){
    val contacts = remember {
        listOf(
            Contact(
                name = "contact1",
                phoneNumber = "1234567890"
            ),
            Contact(
                name = "contact1",
                phoneNumber = "1234567890"
            ),
            Contact(
                name = "contact1",
                phoneNumber = "1234567890"
            ),
            Contact(
                name = "contact1",
                phoneNumber = "1234567890"
            ),
            Contact(
                name = "contact1",
                phoneNumber = "1234567890"
            ),
            Contact(
                name = "contact1",
                phoneNumber = "1234567890"
            ),
            Contact(
                name = "contact1",
                phoneNumber = "1234567890"
            ) ,
            Contact(
                name = "contact1",
                phoneNumber = "1234567890"
            ),
            Contact(
                name = "contact1",
                phoneNumber = "1234567890"
            ),
        )
    }
    LazyRow (
        modifier = Modifier.fillMaxWidth().padding(25.dp).border(1.dp, color = androidx.compose.ui.graphics.Color.DarkGray, shape = RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center

    ) {
        items (contacts) {contact ->
            Card (
                modifier = Modifier.fillMaxWidth().padding(20.dp),
                )
            {
                Box(
                    modifier = Modifier.fillMaxWidth().padding(20.dp),
                ){
                    Column {
                        Text(text = contact.name)
                        Text(text = contact.phoneNumber)
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

    }

}