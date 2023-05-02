package com.example.meditationui.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationui.BottomMenuContent
import com.example.meditationui.Feature
import com.example.meditationui.Meditation
import com.example.meditationui.R
import com.example.meditationui.standardQuadFromTo


@Composable
fun HomeScreen(){
    Box(modifier = Modifier //creation box
        .background(DeepBlue)
        .fillMaxSize()
    ){
        Column {
            GreetingSection()
            ChipSection(chips = listOf("Sweet Sleep", "Insomnia", "Depression"))
            CurrentMeditation(
                meditation = Meditation(
                        title = "Daily Thought",
                        R.drawable.ic_play,
                        LightRed,
                        DarkRed,
                        MediumRed,

                        )
                )


            FeatureSection(
                features = listOf(
                Feature(
                    title = "Sleep meditation",
                    R.drawable.ic_headphone,
                    BlueViolet1,
                    BlueViolet2,
                    BlueViolet3
                ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                )
            )
        }
        BottomMenu(items = listOf(
            BottomMenuContent("Home", R.drawable.ic_home),
            BottomMenuContent("Meditate", R.drawable.ic_bubble),
            BottomMenuContent("Sleep", R.drawable.ic_moon),
            BottomMenuContent("Music", R.drawable.ic_music),
            BottomMenuContent("Profile", R.drawable.ic_profile),
        ), modifier = Modifier.align(Alignment.BottomCenter))
    }
}


@Composable
fun GreetingSection(
    name: String ="Ankit"
){
  Row (
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
          .fillMaxWidth()
          .padding(15.dp)

  ){
      Column(
          verticalArrangement = Arrangement.Center
      ) {
          Text(
          text = "Good Morning, $name",
              style = MaterialTheme.typography.h5,
              color = Color(0xffeeeeee)

          )
          Text(
          text = "We wish you to have a good day!",
              style = MaterialTheme.typography.body1,
          color = Color(0xff9aa5c4)
          )
      }
      Icon(painter = painterResource(id = R.drawable.ic_search),
          contentDescription = "Search",
          tint = Color.White,
          modifier = Modifier.size(24.dp)
      )
  }

}


@Composable
fun ChipSection(
    chips: List<String>

){
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(10.dp)
            ){
                Text(text = chips[it], color = TextWhite)
            }
        }

    }

}
@Composable

fun CurrentMeditation(
    meditation: Meditation,
    color: Color = LightRed
) {

    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(3f)
            .clip(RoundedCornerShape(10.dp))
            .background(meditation.darkColor)

    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = meditation.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = meditation.lightColor
            )
        }
            Column {

                Text(
                    text = "Daily Thought",
                    style = MaterialTheme.typography.h5,
                    color = Color(0xffeeeeee),
                    modifier = Modifier
                        .padding(10.dp)
                        .offset(0.dp,10.dp)


                )
                Text(
                    text = "Meditation . 3-10 min",
                    style = MaterialTheme.typography.body1,
                    color = Color(0xffeeeeee),
                    modifier = Modifier
                            .padding(10.dp)


                )
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .offset(290.dp, (-85).dp)
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(12.dp)
        ) {
            Icon(
                painter = (painterResource(id = R.drawable.ic_play)),
                contentDescription = "play",
                tint = Color.White,
                modifier = Modifier.size(15.dp)
            )
        }
    }



    @Composable
    fun FeatureSection(features: List<Feature>) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Featured",
                style = MaterialTheme.typography.h4,
                color = Color(0xffeeeeee),
                modifier = Modifier
                    .padding(15.dp)
                    .offset(0.dp, (-40).dp)
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
                modifier = Modifier
                    .fillMaxHeight()
                    .offset(0.dp, (-30).dp)
            ) {
                items(features.size) {
                    FeatureItem(feature = features[it])
                }
            }

        }

    }


    @Composable
    fun FeatureItem(
        feature: Feature
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .padding(7.5.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(feature.darkColor)

        ) {
            val width = constraints.maxWidth
            val height = constraints.maxHeight

            // Medium colored path
            val mediumColoredPoint1 = Offset(0f, height * 0.3f)
            val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
            val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
            val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
            val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

            val mediumColoredPath = Path().apply {
                moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
                standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
                standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
                standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
                standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
                lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
                lineTo(-100f, height.toFloat() + 100f)
                close()
            }

            // Light colored path
            val lightPoint1 = Offset(0f, height * 0.35f)
            val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
            val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
            val lightPoint4 = Offset(width * 0.65f, height.toFloat())
            val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

            val lightColoredPath = Path().apply {
                moveTo(lightPoint1.x, lightPoint1.y)
                standardQuadFromTo(lightPoint1, lightPoint2)
                standardQuadFromTo(lightPoint2, lightPoint3)
                standardQuadFromTo(lightPoint3, lightPoint4)
                standardQuadFromTo(lightPoint4, lightPoint5)
                lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
                lineTo(-100f, height.toFloat() + 100f)
                close()
            }
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                drawPath(
                    path = mediumColoredPath,
                    color = feature.mediumColor
                )
                drawPath(
                    path = lightColoredPath,
                    color = feature.lightColor
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {
                Text(
                    text = feature.title,
                    style = MaterialTheme.typography.h5,
                    color = Color(0xffeeeeee),
                    lineHeight = 26.sp,
                    modifier = Modifier.align(Alignment.TopStart)
                )
                Icon(
                    painter = painterResource(id = feature.iconId),
                    contentDescription = feature.title,
                    tint = Color.White,
                    modifier = Modifier.align(Alignment.BottomStart)
                )
                Text(
                    text = "Start",
                    color = TextWhite,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable {
                            // Handle the click
                        }
                        .align(Alignment.BottomEnd)
                        .clip(RoundedCornerShape(10.dp))
                        .background(ButtonBlue)
                        .padding(vertical = 6.dp, horizontal = 15.dp)
                )
            }
        }
    }

    @Composable
    fun BottomMenu(
        items: List<BottomMenuContent>,
        modifier: Modifier = Modifier,
        activeHighlightColor: Color = ButtonBlue,
        activeTextColor: Color = Color.White,
        inactiveTextColor: Color = AquaBlue,
        initialSelectedItemIndex: Int = 0
    ) {
        var selectedItemIndex by remember {
            mutableStateOf(initialSelectedItemIndex)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .background(DeepBlue)
                .padding(15.dp)
        ) {
            items.forEachIndexed { index, item ->
                BottomMenuItem(
                    item = item,
                    isSelected = index == selectedItemIndex,
                    activeHighlightColor = activeHighlightColor,
                    activeTextColor = activeTextColor,
                    inactiveTextColor = inactiveTextColor
                ) {
                    selectedItemIndex = index
                }
            }
        }
    }

    @Composable
    fun BottomMenuItem(
        item: BottomMenuContent,
        isSelected: Boolean = false,
        activeHighlightColor: Color = ButtonBlue,
        activeTextColor: Color = Color.White,
        inactiveTextColor: Color = AquaBlue,
        onItemClick: () -> Unit
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.clickable {
                onItemClick()
            }
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (isSelected) activeHighlightColor else Color.Transparent)
                    .padding(10.dp)
            ) {
                Icon(
                    painter = painterResource(id = item.iconId),
                    contentDescription = item.title,
                    tint = if (isSelected) activeTextColor else inactiveTextColor,
                    modifier = Modifier.size(20.dp)
                )
            }
            Text(
                text = item.title,
                color = if (isSelected) activeTextColor else inactiveTextColor
            )
        }
    }










