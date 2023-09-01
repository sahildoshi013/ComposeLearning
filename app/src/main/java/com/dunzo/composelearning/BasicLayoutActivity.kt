package com.dunzo.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dunzo.composelearning.ui.theme.ComposeLearningTheme

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
class BasicLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                val windowSizeClass = calculateWindowSizeClass(this)
                MyApp(windowSizeClass)
            }
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search"
            )
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = MaterialTheme.colorScheme.surface,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(
                text = stringResource(R.string.placeholder_search)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    ComposeLearningTheme {
        SearchBar()
    }
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyElementPreview() {
    ComposeLearningTheme {
        AlignYourBodyElement(
            text = R.string.ab1_inversions,
            drawable = R.drawable.ab1_inversions,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionCardPreview() {
    ComposeLearningTheme {
        FavoriteCollectionCard(
            text = R.string.fc2_nature_meditations,
            drawable = R.drawable.fc2_nature_meditations,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier,
    alignYourBodyData: List<AlignYourBodyData>
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(alignYourBodyData.size) { index ->
            val item = alignYourBodyData[index]
            AlignYourBodyElement(item.drawable, item.text)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyRowPreview() {
    ComposeLearningTheme {
        AlignYourBodyRow(
            modifier = Modifier.padding(8.dp),
            alignYourBodyData = listOf(
                AlignYourBodyData(R.drawable.ab1_inversions, R.string.ab1_inversions),
                AlignYourBodyData(R.drawable.ab1_inversions, R.string.ab1_inversions),
                AlignYourBodyData(R.drawable.ab1_inversions, R.string.ab1_inversions),
                AlignYourBodyData(R.drawable.ab1_inversions, R.string.ab1_inversions),
            )
        )
    }
}

data class AlignYourBodyData(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

data class FavoriteCollectionData(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier,
    favoriteCollectionsData: List<FavoriteCollectionData>
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)
    ) {
        items(favoriteCollectionsData.size) { index ->
            val item = favoriteCollectionsData[index]
            FavoriteCollectionCard(
                drawable = item.drawable,
                text = item.text,
                modifier = Modifier.height(80.dp)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionPreview(
    modifier: Modifier = Modifier,
    favoriteCollectionsData: List<FavoriteCollectionData> = listOf(
        FavoriteCollectionData(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations),
        FavoriteCollectionData(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations),
        FavoriteCollectionData(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations),
        FavoriteCollectionData(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations),
        FavoriteCollectionData(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations),
        FavoriteCollectionData(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations),
    )
) {
    ComposeLearningTheme {
        FavoriteCollectionsGrid(
            modifier = modifier.padding(8.dp),
            favoriteCollectionsData = favoriteCollectionsData
        )
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun HomeSectionPreview() {
    ComposeLearningTheme {
        HomeSection(R.string.align_your_body) {
            AlignYourBodyRow(
                modifier = Modifier.padding(8.dp),
                alignYourBodyData = listOf(
                    AlignYourBodyData(R.drawable.ab1_inversions, R.string.ab1_inversions),
                    AlignYourBodyData(R.drawable.ab1_inversions, R.string.ab1_inversions),
                    AlignYourBodyData(R.drawable.ab1_inversions, R.string.ab1_inversions),
                    AlignYourBodyData(R.drawable.ab1_inversions, R.string.ab1_inversions),
                )
            )
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow(
                modifier = Modifier.padding(8.dp),
                alignYourBodyData = listOf(
                    AlignYourBodyData(R.drawable.ab1_inversions, R.string.ab1_inversions),
                    AlignYourBodyData(R.drawable.ab1_inversions, R.string.ab1_inversions),
                    AlignYourBodyData(R.drawable.ab1_inversions, R.string.ab1_inversions),
                    AlignYourBodyData(R.drawable.ab1_inversions, R.string.ab1_inversions),
                )
            )
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid(
                modifier = modifier.padding(8.dp),
                favoriteCollectionsData = listOf(
                    FavoriteCollectionData(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations),
                    FavoriteCollectionData(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations),
                    FavoriteCollectionData(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations),
                    FavoriteCollectionData(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations),
                    FavoriteCollectionData(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations),
                    FavoriteCollectionData(R.drawable.fc2_nature_meditations, R.string.fc2_nature_meditations),
                )
            )
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE, heightDp = 180)
@Composable
fun ScreenContentPreview() {
    ComposeLearningTheme { HomeScreen() }
}

@Composable
private fun BottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Spa,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            },
            selected = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun NavigationPreview() {
    ComposeLearningTheme {
        BottomNavigation()
    }
}

@Composable
fun MyAppPortrait() {
    ComposeLearningTheme {
        Scaffold(
            bottomBar = { BottomNavigation() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

@Composable
private fun NavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Spa,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_home))
                },
                selected = true,
                onClick = {}
            )
            Spacer(modifier = Modifier.height(8.dp))
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_profile))
                },
                selected = false,
                onClick = {}
            )
        }
    }
}

@Composable
fun MyAppLandscape() {
    ComposeLearningTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                NavigationRail()
                HomeScreen()
            }
        }
    }
}

@Composable
fun MyApp(windowSize: WindowSizeClass) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            MyAppPortrait()
        }

        WindowWidthSizeClass.Expanded -> {
            MyAppLandscape()
        }
    }
}