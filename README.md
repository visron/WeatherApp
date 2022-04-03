# WeatherApp

[![Build Status](https://github.com/visron/WeatherApp/actions)](https://github.com/visron/WeatherApp)


Sample Android App Written almost purely in kotlin

Used openWeatherApi to get data https://openweathermap.org
 

## How to install
 - Clone the repo
 - build and run the app from android studio.

## Features 
 - Fetch Current Weather Data from OpenWeatherMap Api 
 - Fetch Forecast Data from OpenWeatherMap Api

## Pattern
 - MVP 

## CI/CD
 ### Added github actions
  -- set up master as automated branch.
   --- merge to master through pull requests 
  - Sets up java 11
  - Runs Defined testcases 
  - Build the app
## TODO
  - Location menu where one can save locations and refer to them later
  - Add Maps to show markers of different locations
  - Increase test coverage

## Libraries

- Room Database
- Kotlin serialization
- Ktor as http client
- Gson
- google places library
