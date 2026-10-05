# AndroidApp2 – Tim Hortons Order App

AndroidApp2 is a Tim Hortons ordering application developed in Kotlin using Android Studio.

This project recreates and expands the features from the iOS Tim Hortons application as an Android application.

## Features

- Tim Hortons splash screen
- Coffee cup image/icon
- Red and white app theme
- Displays the current date
- Create a new customer order
- Enter the customer's name
- Select a drink
- Select a drink size
- Increase or decrease order quantity using stepper-style controls
- Save orders using SharedPreferences
- View saved orders
- Display recent orders by customer name
- Cancel/delete saved orders
- Confirmation dialog before cancelling an order
- Input validation for customer names

## Drink Options

- Coffee
- Tea
- Hot Chocolate
- French Vanilla

## Size Options

- Small
- Medium
- Large
- Extra Large

## Technologies Used

- Kotlin
- Android Studio
- XML layouts
- SharedPreferences
- Android Activities
- ListView
- Spinner
- AlertDialog
- TextWatcher

## App Screens

The application contains the following main screens:

1. Splash Screen
2. Main Menu
3. Create Your Order
4. Saved Orders

## How the App Works

The app begins with a Tim Hortons splash screen and then opens the main menu.

Users can create an order by entering their name, selecting a drink and size, and choosing the quantity.

Orders are saved locally using SharedPreferences.

When a customer enters their name again, their recent orders are displayed.

Saved orders can also be viewed from the Saved Orders screen. Tapping an order displays a confirmation dialog allowing the user to cancel and delete the order.

## Course Project

Developed as part of the Android development coursework at triOS College.

The project applies Android development concepts while recreating features from the previous iOS Tim Hortons application.
