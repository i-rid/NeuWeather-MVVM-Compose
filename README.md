<div id="top"></div>

<table style="width:100%">
  <tr>
    <td>

## NeuWeather

<p align="left">Android app built with Jetpack Compose and MVVM, implemented Neumorphic UI.</p>

<p align="left">
    <a href = "https://kotlinlang.org/docs/home.html">
      <img src = "https://img.shields.io/badge/Kotlin-1.7.20-blue.svg?color=blue&style=for-the-badge" />
    </a>
    <a href = "https://kotlinlang.org/docs/home.html">
      <img src = "https://img.shields.io/badge/Jetpack%20Compose-1.3.2-blue.svg?color=blue&style=for-the-badge" />
    </a>
    <a href="https://m2.material.io/design/introduction">
      <img src="https://img.shields.io/badge/Material%20Design-3-blue.svg?color=blue&style=for-the-badge"/>
    </a>
    <a href="https://m2.material.io/design/introduction">
      <img src="https://img.shields.io/badge/Forenwid%20Neumorphism-0.3.0-blue.svg?color=blue&style=for-the-badge"/>
    </a>
</p>

### The purpose of this repository

- Build a fully functional Android app built entirely with Kotlin and Jetpack Compose.
- Follows Android design and development best practices with Compose and MVVM.
- Explore the possibilities of creating complex UI and UX of a popular design trends like Neumorphic UI design using
  Compose.

### Status: 👨‍💻 In progress

<p>NeuWeather is under active development.</p>

</td> 
<td>

  <img src = "NeuWeather_SS/NeuWeatherDemo.gif" width="220"/>
</td>
</tr>
</table>

### Stack

| Tools & Libraries| Link |
|     :---      |          :---: |
| 🤖 Kotlin | [Kotlin](https://kotlinlang.org) |](https://developer.android.com/jetpack/compose) |
| <img src = "https://tabris.com/wp-content/uploads/2021/06/jetpack-compose-icon_RGB.png" width="15"/> Jetpack Compose | [Jetpack Compose](https://developer.android.com/jetpack) |
| <img src = "https://static.vecteezy.com/system/resources/previews/010/878/962/original/3d-rendering-of-cute-icon-illustration-timeout-timer-empty-state-png.png" width="15"/> Compose State Hoisting | [State Hoisting](https://developer.android.com/jetpack/compose/state) |
| <img src = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Animated-runner.svg/1024px-Animated-runner.svg.png" width="15"/> Compose Animation | [Compose Animation](https://developer.android.com/jetpack/compose/animation) |
| 🌐 Material Design | [Material Design](https://developer.android.com/jetpack/androidx/releases/compose-material) |
| <img src = "https://static.vecteezy.com/system/resources/previews/011/893/886/non_2x/neumorphic-circle-icon-neumorphism-ui-button-free-png.png" width="15"/> Fornewid-Neumorphism | [Neumorphism](https://github.com/fornewid/neumorphism) |
| Accompanist | [UI Controller](https://github.com/google/accompanist/tree/main/systemuicontroller) |
| 🌊 Coroutines | [Coroutines](https://developer.android.com/kotlin/coroutines) |
|  Retrofit | [Retrofit](https://square.github.io/retrofit/) |
| ViewModel | [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) |
|   LiveData | [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) |
| Glide | [Glide](https://github.com/bumptech/glide) |
| Gson | [GSon](https://github.com/google/gson) |


## 📷 Screenshots (Dark theme)

<table style="width:100%">
  <tr>
    <th>Spinner (City List)</th>
    <th>Weather & Map</th> 
    <th>Weather & Map</th>
    <th>Weather & Map</th>
  </tr>
  <tr>
    <td><img src = "NeuWeather_SS/d1.jpg" width=240/></td> 
    <td><img src = "NeuWeather_SS/d2.jpg" width=240/></td>
    <td><img src = "NeuWeather_SS/d3.jpg" width=240/></td> 
    <td><img src = "NeuWeather_SS/d4.jpg" width=240/></td>
  </tr>
  <tr>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
  </tr>
  <tr>
    <td><img src = "NeuWeather_SS/d5.jpg" width=240/></td>
    <td><img src = "NeuWeather_SS/d6.jpg" width=240/></td>
    <td><img src = "NeuWeather_SS/d7.jpg" width=240/></td>
    <td><img src = "NeuWeather_SS/d8.jpg" width=240/></td>
  </tr>
</table>


## 📷 Screenshots (Light theme)

<table style="width:100%">
  <tr>
    <th>Spinner (City List)</th>
    <th>Weather & Map</th> 
    <th>Weather & Map</th>
    <th>Weather & Map</th>
  </tr>
  <tr>
    <td><img src = "NeuWeather_SS/l1.png" width=240/></td> 
    <td><img src = "NeuWeather_SS/l6.png" width=240/></td>
    <td><img src = "NeuWeather_SS/l2.png" width=240/></td> 
    <td><img src = "NeuWeather_SS/l3.png" width=240/></td>
  </tr>
  <!-- <tr>
    <th>Invite</th>
    <th>Password Manager Dialog</th>
    <th>Create Server</th>
    <th>Friends</th>
  </tr> -->
  <!-- <tr>
    <td><img src = "NeuWeather_SS/l5.png" width=240/></td>
    <td><img src = "NeuWeather_SS/l6.png" width=240/></td>
    <td><img src = "NeuWeather_SS/l7.png" width=240/></td>
    <td><img src = "NeuWeather_SS/l8.png" width=240/></td>
  </tr> -->
</table>


# Package Structure

    NeuWeather-MVVM Project Structure
    .
    └── neuweather_mvvm
        ├── common
        │   └── RequestCompleteListener.kt
        ├── experiment_views
        │   ├── Lottie.kt
        │   └── NeuUi.kt
        ├── features
        │   └── weather_info_show
        │       ├── model
        │       │   ├── data_class
        │       │   │   ├── City.kt
        │       │   │   ├── Clouds.kt
        │       │   │   ├── Coord.kt
        │       │   │   ├── Main.kt
        │       │   │   ├── NeuMapImages.kt
        │       │   │   ├── Sys.kt
        │       │   │   ├── WeatherButtonLabel.kt
        │       │   │   ├── WeatherDataModel.kt
        │       │   │   ├── WeatherInfoResponse.kt
        │       │   │   ├── Weather.kt
        │       │   │   └── Wind.kt
        │       │   ├── WeatherInfoShowModelImpl.kt
        │       │   └── WeatherInfoShowModel.kt
        │       ├── view
        │       │   ├── MainActivity.kt
        │       │   ├── MainView.kt
        │       │   ├── NeumorphicCard.kt
        │       │   ├── NeuMorphicCell.kt
        │       │   └── NeumorphicSpinner.kt
        │       └── viewmodel
        │           └── WeatherInfoViewModel.kt
        ├── network
        │   ├── ApiInterface.kt
        │   ├── QueryParameterAddInterceptor.kt
        │   └── RetrofitClient.kt
        ├── theme
        │   ├── Shape.kt
        │   ├── ThemeCompose.kt
        │   ├── ThemeManagerImpl.kt
        │   ├── ThemeManager.kt
        │   ├── ThemeModule.kt
        │   └── Type.kt
        └── utils
            └── Extensions.kt

<p align="right">[<a href="#top">Back to top</a>]</p>
