package com.example.makemytrip

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import androidx.compose.ui.res.painterResource as painterResource

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {

    Scaffold (
        topBar = { TopAppBarContent()},
        bottomBar = {BottomNavigationBar(navController = navController )}
    ){padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            HomeScreenElem()
        }
    }



}


@Composable
fun HomeScreenElem() {

    Surface(modifier = Modifier
        .fillMaxHeight(),

        ) {
        Column(modifier = Modifier.padding(all = 8.dp)) {

            Row(modifier = Modifier.padding(bottom = 16.dp)) {

                Card(
                    modifier = Modifier
                        .width(90.dp)
                        .height(120.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    shape = RoundedCornerShape(16.dp),

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize() // Ensure Column takes full size of Card
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_flight_takeoff_24),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color.Blue
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(text = "Flights",
                            fontWeight = FontWeight.Black)
                    }
                }

                Spacer(modifier = Modifier.width(14.dp))

                Card(
                    modifier = Modifier
                        .width(90.dp)
                        .height(120.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(all = 8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        Icon(
                            painter = painterResource(R.drawable.baseline_fence_24),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color.Blue
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(text = "Hotels",
                            fontWeight = FontWeight.Black)
                    }
                }
                Spacer(modifier = Modifier.width(14.dp))

                Card(
                    modifier = Modifier
                        .width(90.dp)
                        .height(120.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize() // Ensure Column takes full size of Card
                            .padding(all = 8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_fence_24),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color.Blue
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(text = "Holiday",
                            fontWeight = FontWeight.Black)
                    }
                }
                Spacer(modifier = Modifier.width(4.dp))

            }

            Spacer(modifier = Modifier.height(16.dp))

            ExpandableCard()
            PreviewCardWithBackgroundAndImage()
            PreviewCardWithWelcomeOffer()


        }
    }

}

//Composable function for Top Nav bar


@Preview
@Composable
fun TopNavigationBar() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    NavigationBar(modifier = Modifier.height(100.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.wrapContentSize(Alignment.CenterStart)
            ) {
                IconButton(onClick = {  scope.launch { drawerState.open() } }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
//            Image(
//                bitmap = imageResource(id = R.drawable.logo),
//                contentDescription = "Logo",
//                modifier = Modifier.size(40.dp)
//            )
            }
            Row(
                modifier = Modifier.wrapContentSize(Alignment.CenterEnd)
            ) {
                IconButton(onClick = { /* search */ }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "My Cash",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "My Biz",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }

}

//Composable function for Bottom menu bar

val items = listOf(
    BtmNavDataClass(
        title = "Home",
        icon = Icons.Outlined.Home,
        route = Routes.Home
    ),
    BtmNavDataClass(
        title = "My Trips",
        icon = Icons.Outlined.Home,
        route = Routes.MyTrip
    ),
    BtmNavDataClass(
        title = "Where2Go",
        icon = Icons.Outlined.Home,
        route = Routes.WhereToGo
    ),
    BtmNavDataClass(
        title = "Trip Money",
        icon = Icons.Outlined.Home,
        route = Routes.TripMoney
    ),
    BtmNavDataClass(
        title = "Be A Host",
        icon = Icons.Outlined.Home,
        route = Routes.BeAhost
    )
)
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)) // Add this line
            .background(MaterialTheme.colorScheme.inverseSurface)
    ) {
        Row (modifier =
        Modifier.background(
            MaterialTheme
                .colorScheme.inverseSurface),
        )
        {
            items.forEachIndexed { index,
                                   item ->
                NavigationBarItem(selected = index ==0,
                    onClick = { navController.navigate(item.route) },
                    icon = {
                        Icon(imageVector = item.icon ,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.inverseOnSurface
                        )
                    },
                    label ={
                        Text(text = item.title,
                            color = MaterialTheme.colorScheme.inverseOnSurface)
                    }
                )
            }
        }
    }
}

//Composable function for Expandable card
@Composable
fun ExpandableCard() {
    var expanded by remember { mutableStateOf(false) }

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),

    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
//                horizontalArrangement = Arrangement.SpaceBetween
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_directions_car_24),
                            contentDescription = "Icon 5"
                        )
                        Text(text = "Airport Cabs",
                            fontSize = 12.sp)
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_temple_buddhist_24),
                            contentDescription = "Icon 6"
                        )
                        Text(text = "HomeStays\n&Villa",
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 19.9.sp)
                    }
                    Column (verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_directions_car_24),
                            contentDescription = "Icon 7"
                        )
                        Text(text = "Outstation\nCabs",
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 19.9.sp)
                    }
                    Column (verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_currency),
                            contentDescription = "Icon 8"
                        )
                        Text(text = "ForexCard\nCurrency",
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 19.9.sp)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                //Second line item start for Giftcards, Hourly Stays, Nearby Staycation,
                // Travel Insurance
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_directions_car_24),
                            contentDescription = "Icon 5"
                        )
                        Text(text = "Gift Cards",
                            fontSize = 12.sp)
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_temple_buddhist_24),
                            contentDescription = "Icon 6"
                        )
                        Text(text = "Hourly stays",
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 9.9.sp)
                    }
                    Column (verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_directions_car_24),
                            contentDescription = "Icon 7"
                        )
                        Text(text = "Nearby\nStaycation",
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 9.9.sp)
                    }
                    Column (verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_currency),
                            contentDescription = "Icon 8"
                        )
                        Text(text = "Travel\nInsurance",
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 9.9.sp)
                    }
                }

            }
        }
        // Content
        if (expanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_flight_takeoff_24),
                            contentDescription = "Icon 5"
                        )
                        Text(text = "Flight Status",
                            fontSize = 12.sp)
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_flight_takeoff_24),
                            contentDescription = "Icon 6"
                        )
                        Text(text = "PNR Status",
                            fontSize = 12.sp)
                    }
                    Column (verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_flight_takeoff_24),
                            contentDescription = "Icon 7"
                        )
                        Text(text = "Visa",
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 9.9.sp)
                    }
                    Column (verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                        ){

                    }
                }

            }
        }
        IconButton(onClick = { expanded =!expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = "Expand/Collapse",
                )
        }

    }


}

@Preview
@Composable
fun PreviewExpandableCard() {
    ExpandableCard()
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarContent() {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row( modifier = Modifier.wrapContentSize(Alignment.CenterStart)) {
                    IconButton(onClick = { /* navigate back */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu"
                        )
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
                Row( modifier = Modifier.wrapContentSize(Alignment.CenterEnd)) {
                    IconButton(onClick = { /* search */ }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search"
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    IconButton(onClick = { /* cash */ }) {
                        Icon(
                            imageVector = Icons.Filled.AttachMoney,
                            contentDescription = "Cash"
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    IconButton(onClick = { /* biz */ }) {
                        Icon(
                            imageVector = Icons.Filled.Business,
                            contentDescription = "Biz"
                        )
                    }
                }
            }
        },
        //elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // Adjust elevation as needed
    )

}

@Composable
//fun CardWithBackgroundAndImage(imageResId: Int, backgroundResId: Int, title: String) {
fun CardWithBackgroundAndImage( backgroundResId: Int, title: String) {

    Card(
        modifier = Modifier
            .width(180.dp)
            .height(290.dp)
            .padding(top = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        BoxWithConstraints(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(backgroundResId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                Image(
//                    painter = painterResource(imageResId),
//                    contentDescription = title,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .size(120.dp)
//                        .clip(RoundedCornerShape(16.dp))
//                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = title,
                    color = Color.White,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewCardWithBackgroundAndImage() {
    Text(text = "Flagship Hotel Stores",
        modifier = Modifier.padding(top = 30.dp),
        fontWeight = FontWeight.Black)
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround) {
        CardWithBackgroundAndImage(
            //imageResId = R.drawable.baseline_temple_buddhist_24,
            backgroundResId = R.drawable.heritage,
            title = "Welcome Heritage"
        )
        CardWithBackgroundAndImage(
            //imageResId = R.drawable.baseline_temple_buddhist_24,
            backgroundResId = R.drawable.heritage,
            title = "CGH Eaeth\nExperience Hotels"
        )
    }
}


//Welcome offer, for user


@Composable
//fun CardWithBackgroundAndImage(imageResId: Int, backgroundResId: Int, title: String) {
fun CardWithWelcomeOffer( backgroundResId: Int, title: String,offer:String) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .padding(top = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        BoxWithConstraints(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(backgroundResId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                Image(
//                    painter = painterResource(imageResId),
//                    contentDescription = title,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .size(120.dp)
//                        .clip(RoundedCornerShape(16.dp))
//                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = title,
                    color = Color.White,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = offer,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .background(Color.White)
                )

            }
        }
    }
}

@Preview
@Composable
fun PreviewCardWithWelcomeOffer() {
    Text(text = "Welcome Offer",
        modifier = Modifier.padding(top = 30.dp),
        fontWeight = FontWeight.Black)
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround) {
        CardWithWelcomeOffer(
            //imageResId = R.drawable.baseline_temple_buddhist_24,
            backgroundResId = R.drawable.heritage,
            title = "WELCOME, TRAVELLER:",
            offer = "OFFERS"

        )
    }
}

@Composable
fun DiscoverMoreThanTravel() {
    Row {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
                .padding(top = 8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column {

            }
        }
    }
}
