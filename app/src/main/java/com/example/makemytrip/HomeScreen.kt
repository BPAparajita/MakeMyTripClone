package com.example.makemytrip

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ModalDrawer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AirlineSeatReclineNormal
import androidx.compose.material.icons.outlined.ArrowCircleRight
import androidx.compose.material.icons.outlined.ArrowUpward
import androidx.compose.material.icons.outlined.CardGiftcard
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocalOffer
import androidx.compose.material.icons.outlined.Money
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.rememberScaffoldState
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
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
    var isDrawerOpen by remember { mutableStateOf(false) }
    val drawerState = rememberDrawerState(androidx.compose.material.DrawerValue.Closed)

    LaunchedEffect(isDrawerOpen) {
        if (isDrawerOpen) {
            drawerState.open()
        } else {
            drawerState.close()
        }
    }

    ModalDrawer(
        drawerState = drawerState,
        drawerContent = {
            NavigationDrawerContent()
        }
    ) {
        Scaffold(
            topBar = { TopAppBarContent(onMenuClick = { isDrawerOpen = !isDrawerOpen }) },
            bottomBar = { BottomNavigationBar(navController = navController) }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(padding)
            ) {
                HomeScreenElem(navController = navController)
            }
        }
    }
}


@Composable
fun HomeScreenElem(navController: NavHostController) {

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

            ExpandableCard(navController = navController)
            PreviewCardWithBackgroundAndImage()
            PreviewCardWithWelcomeOffer()


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



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarContent(onMenuClick: () -> Unit) {
    Box() {
        Column {
            // Top App Bar
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.wrapContentSize(Alignment.CenterStart),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(onClick = onMenuClick) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Menu"
                                )
                            }
                            Image(
                                painter = painterResource(id = R.drawable.makemytriplog),
                                contentDescription = "Logo",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Row(modifier = Modifier.wrapContentSize(Alignment.CenterEnd)) {
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
    }
}

//Sidenavbar
@Composable
fun NavigationDrawerContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        HeaderSection()
        Spacer(modifier = Modifier.height(16.dp))
        NavigationRow("My Account", R.drawable.baseline_train_24)
        NavigationRow("Support", R.drawable.icons8home100)
        NavigationRow("Notifications", R.drawable.icons8home100)
        Spacer(modifier = Modifier.height(16.dp))
        SectionCard(
            title = "My Trips",
            items = listOf(
                "View/Manage Trips" to R.drawable.baseline_currency,
                "Wishlist" to R.drawable.baseline_fence_24
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        SectionCard(
            title = "Rewards",
            items = listOf(
                "Gift Cards" to R.drawable.baseline_temple_buddhist_24,
                "Rewards" to R.drawable.baseline_fence_24,
                "Refer & Earn" to R.drawable.icons1,
                "Holidays Refer & Earn" to R.drawable.baseline_flight_takeoff_24
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        NavigationRow("MMTBLACK", R.drawable.baseline_flight_takeoff_24)
        Spacer(modifier = Modifier.height(16.dp))
        SectionCard(
            title = "Settings",
            items = listOf(
                "Language English" to R.drawable.baseline_directions_car_24,
                "Country" to R.drawable.baseline_temple_buddhist_24
            )
        )
    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Blue, Color.Cyan),
                    startY = 0f,
                    endY = 1000f
                ),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Gray, shape = CircleShape)
            ) {
                // Profile Image Placeholder
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Hi Traveller", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }
    }
}

@Composable
fun SectionCard(title: String, items: List<Pair<String, Int>>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF6F6F6), shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(8.dp))
        items.forEach { item ->
            NavigationRow(item.first, item.second)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun NavigationRow(title: String, iconRes: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = title,
            tint = Color.Unspecified,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title, fontSize = 16.sp)
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Outlined.ArrowCircleRight,
            contentDescription = "Arrow",
            tint = Color.Gray,
            modifier = Modifier.size(24.dp)
        )
    }
}


//Offers

//Composable function for Expandable card
@Composable
fun ExpandableCard(navController: NavHostController) {
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
                        IconButton(onClick = { navController.navigate("Home_Stays_Villa") }) {

                            Icon(
                                painter = painterResource(id = R.drawable.baseline_temple_buddhist_24),
                                contentDescription = "Icon 5"
                            )
                        }
                        Text(text = "HomeStays\n&Villa",
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 19.9.sp)
                    }
                    Column (verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_directions_car_24),
                                contentDescription = "Icon 7"
                            )
                        }
                        Text(text = "Outstation\nCabs",
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 19.9.sp)
                    }
                    Column (verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_currency),
                                contentDescription = "Icon 8"
                            )
                        }
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
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_directions_car_24),
                                contentDescription = "Icon 5"
                            )
                        }
                        Text(text = "Gift Cards",
                            fontSize = 12.sp)
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_temple_buddhist_24),
                                contentDescription = "Icon 6"
                            )
                        }
                        Text(text = "Hourly stays",
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 9.9.sp)
                    }
                    Column (verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally)
                    {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_directions_car_24),
                                contentDescription = "Icon 7"
                            )
                        }
                        Text(text = "Nearby\nStaycation",
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 9.9.sp)
                    }
                    Column (verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                       IconButton(onClick = { /*TODO*/ }) {
                           Icon(
                               painter = painterResource(id = R.drawable.baseline_currency),
                               contentDescription = "Icon 8"
                           )
                       }
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
        Box(
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
        Box(
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



